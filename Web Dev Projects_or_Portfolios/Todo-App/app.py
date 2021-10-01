from datetime import datetime
from flask import Flask,render_template,redirect,request,url_for
from flask_sqlalchemy import SQLAlchemy


app = Flask(__name__)
app.config ['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///todo.db'
app.config ['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

db = SQLAlchemy(app)

class Todo(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String(100))
    status = db.Column(db.Boolean)
    date = db.Column(db.DateTime,nullable=False)
   
@app.route("/")
def index():
    todos = Todo.query.all()
    return render_template("index.html",todos=todos)

@app.route("/add",methods=["POST"])
def add():

    title = request.form.get("title")
    date_time = request.form.get("date")
    y = date_time.replace('T',' ')
    deadline = datetime.strptime(y, '%Y-%m-%d %H:%M')
    new_todo = Todo(title=title,status=False,date=deadline)
    db.session.add(new_todo)
    db.session.commit()
    return redirect(url_for("index"))

@app.route("/delete")
def delete():
    idno1 = int(request.args.get("id"))
    todo = Todo.query.filter_by(id=idno1).first()
    db.session.delete(todo)
    db.session.commit()
    return redirect(url_for("index"))

@app.route("/update")
def update():
    idno2 = int(request.args.get("id"))
    x = Todo.query.filter_by(id=idno2).first()
    x.status = not x.status
    db.session.commit()
    return(redirect(url_for("index")))

if __name__ == "__main__":
    db.create_all()
    app.run(debug=True)