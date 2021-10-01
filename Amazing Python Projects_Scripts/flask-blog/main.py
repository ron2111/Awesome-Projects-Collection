from flask import Flask, render_template, request, session, flash, redirect
from markupsafe import escape
from werkzeug.utils import secure_filename
from flask_sqlalchemy import SQLAlchemy
from datetime import datetime
from flask_mail import Mail, Message
import json
import math
import os

with open('config.json', 'r') as c:
    params = json.load(c) ["params"]

app = Flask(__name__)

app.secret_key = 'super-secret-key'

app.config['upload_folder'] = params['upload_location']

app.config.update(
    MAIL_SERVER = params['mail_server'],
    MAIL_PORT = params['mail_port'],
    MAIL_USE_SSL = True,
    MAIL_USERNAME = params['mail_uname'],
    MAIL_PASSWORD = params['mail_pwd']
)
mail = Mail(app)

local_server=params['local_server']
if (local_server=='True'):
    app.config['SQLALCHEMY_DATABASE_URI'] = params['local_uri']
else:
    app.config['SQLALCHEMY_DATABASE_URI'] = params['prod_uri']
db = SQLAlchemy(app)



class Contacts(db.Model):
    sno = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(80), nullable=False)
    phone_num = db.Column(db.String(13), unique=True, nullable=False)
    msg = db.Column(db.String(120), nullable=False)
    date = db.Column(db.String(12))
    email = db.Column(db.String(120), unique=True, nullable=False)

class Posts(db.Model):
    sno = db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String(50), nullable=False)
    subtitle = db.Column(db.String(50), nullable=False)
    slug = db.Column(db.String(20), unique=True, nullable=False)
    content = db.Column(db.String(1000), nullable=False)
    author = db.Column(db.String(10), nullable=False)
    img_file = db.Column(db.String(50), nullable=False)
    date = db.Column(db.String(12))

@app.route("/")                                        # for / endpoint
def home():
    posts = Posts.query.filter_by().all()
    last = math.ceil(len(posts)/int(params['no_of_posts']))
    page = request.args.get('page')
    if (not str(page).isnumeric()):
        page = 1
    page = int(page)
    posts = posts[(page-1)*int(params['no_of_posts']):(page-1)*int(params['no_of_posts'])+ int(params['no_of_posts'])]
    if page==1:
        prev = "#!"
        next = "/?page="+ str(page+1)
    elif page==last:
        prev = "/?page="+ str(page-1)
        next = "#!"
    else:
        prev = "/?page="+ str(page-1)
        next = "/?page="+ str(page+1)
    return render_template('index.html', params=params, posts=posts, prev=prev, next=next)

@app.route("/about")                                              # for /about endpoint
def about():
    return render_template('about.html', params=params)

@app.route("/contact", methods=['GET', 'POST'])                    # for /contact endpoint
def contact():
    if (request.method == 'POST'):
         #adding data to database
         name = request.form.get('name')
         email = request.form.get('email')
         phone = request.form.get('phone')
         message = request.form.get('message')
         date = None
         entry = Contacts(name = name, phone_num = phone, msg = message, date = date, email = email)
         db.session.add(entry)
         db.session.commit()  
         mail.send_message("New Message from Blog, " + name,
                            sender=email,
                            recipients=[params['mail_recipient']],
                            body = message + "\n" + phone
                            )
         flash("We will contact you soon", "success")                   
    return render_template('contact.html', params=params)

@app.route("/post/<string:post_slug>")                                  # for /posts ie viewing uploaded post endpoint
def post(post_slug):
    pst = Posts.query.filter_by(slug=post_slug).first()
    return render_template('post.html', params=params, post=pst)
                                                  
@app.route("/dashboard", methods=['GET', 'POST'])                       # for /dashboard ie for admin endpoint
def dashboard():
    if "user" in session and session['user']==params['admin_user']:
        posts = Posts.query.all()
        return render_template('dashboard.html', params=params, posts=posts)

    if request.method=="POST":
        username = request.form.get("uname")
        userpwd = request.form.get("upass")
        if username==params['admin_user'] and userpwd==params['admin_pwd']:
            # set the session variable
            session['user']=username
            posts = Posts.query.all()
            return render_template('dashboard.html', params=params, posts=posts)
        else:
            flash("Wrong Username/Password", "danger")
            return render_template('login.html', params=params)    
    else:
        return render_template('login.html', params=params)                                                 
    
    
@app.route("/edit/<string:sno>", methods=['GET', 'POST'])                     # for /edit ie editing uploaded post endpoint
def edit(sno):
    if "user" in session and session['user']==params['admin_user']:
        if request.method=="POST":
            box_title = request.form.get('title')
            subtitle = request.form.get('subtitle')
            slug = request.form.get('slug')
            content = request.form.get('content')
            author = request.form.get('author')
            img_file = request.form.get('img_file')
            date = None
            
            if sno=='0':
                post = Posts(title=box_title, slug=slug, content=content, subtitle=subtitle, author=author, img_file=img_file, date=date)
                db.session.add(post)
                db.session.commit()
            else:
                post = Posts.query.filter_by(sno=sno).first()
                post.title = box_title
                post.subtitle = subtitle
                post.slug = slug
                post.content = content
                post.author = author
                post.img_file = img_file
                post.date = date
                db.session.commit()
                return redirect('/edit/'+sno)
        post = Posts.query.filter_by(sno=sno).first()
        return render_template('edit.html', params=params, post=post, sno=sno)
    else:
        return render_template('login.html', params=params)                                                  
    
    

@app.route("/upload", methods=['GET', 'POST'])                  # for /upload ie uploading photo endpoint
def upload():
    if "user" in session and session['user']==params['admin_user']:
        if request.method=="POST":
            f = request.files['file1']
            f.save(os.path.join(app.config['upload_folder'], secure_filename(f.filename)))
            flash("Uploaded Successfully", "success")
            posts = Posts.query.all()
            return render_template('dashboard.html', params=params, posts=posts)
    else:
        return render_template('login.html', params=params)


@app.route("/logout")                                                 # for /logout loging out session endpoint 
def logout():
    session.pop('user')
    return redirect('/dashboard')

    
@app.route("/delete/<string:sno>", methods=['GET', 'POST'])            # for /delete ie deleteing post endpoint
def delete(sno):
    if "user" in session and session['user']==params['admin_user']:
        post = Posts.query.filter_by(sno=sno).first()
        db.session.delete(post)
        db.session.commit()
        return redirect('/dashboard')
    else:
        return render_template('login.html', params=params)        
    
    
    #end here end for blog

@app.route("/world")
def hello_world():
    return "<p>Hello, World!</p>"

@app.route("/hello")
def hello():
    return "<p>Hello, User!</p>"

@app.route("/help")
def help():
    namestr = "Nishith"
    return render_template('help.html', nme=namestr, params=params)

@app.route("/<name>")
def hi(name):
    return f"Hi, {escape(name)}!"

@app.route('/user/<username>')
def show_user_profile(username):
    # show the user profile for that user
    return f'User {escape(username)}'

@app.route('/post/<int:post_id>')#string,int,float,path,uuid
def show_post(post_id):
    # show the post with the given id, the id is an integer
    return f'Post {post_id}'

@app.route('/path/<path:subpath>')
def show_subpath(subpath):
    # show the subpath after /path/
    return f'Subpath {escape(subpath)}'

@app.route('/projects/')
def projects():
    return 'The project page'

@app.route('/post/api/<string:name>/<int:standard>/<path:subpath>')#string,int,float,path,uuid
def details(name,standard,subpath):
    # show the post with the given id, the id is an integer
    return f'Details :  {name}, {standard}, Path : {escape(subpath)}'

app.run(host="0.0.0.0", port=int("80"), debug=True)