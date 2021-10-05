
import math
from tkinter import *
import re
root = Tk()
root.geometry('850x850')
root.title("STUDENT REGISTRATION FORM")
f=0
regex ='^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$'
def check3(email1):   
    if (re.search(regex,email1)) :  
        return email1  
          
    else:  
        return "Invalid Email"

def check1(val):
    try:
        val=float(val)
        bool1=(isinstance(val,float))
        if bool1==True:
            if val>100:
                print('INVALID INPUT1')
            else:
                if round(val,2)==val:
                    print(val)
        else:
            print('INVALID INPUT')
    except:
        print('INVALID INPUT')

def length(s1633):
    f633=0
    for i in s1633:
        f633+=1
    return f633

def check(str):
    if (str.isalpha() and length(str)<=30) or (str.isalpha() and length(str)<=10):
        return str
    elif str=="":
        return "FIELD MISSING"
    else:
        return "INVALID INPUT"
    
def validation():
    first_name=entry1.get()
    print("FIRST NAME:",check(first_name))
    last_name=entry2.get()
    print("LAST NAME:",check(last_name))
    email=entry3.get()
    print("EMAIL ID:",check3(email))
    try:
        a=(entry4.get())
        if a=="":
            print("FIELD MISSING")
        else:
            
            b=int(a)
            while(b!=0):
                b=b//10
                f+=1
            if f==10:
                print(a)
            else:
                print("MOBILE NUMBER: INVALID INPUT")
    except:
        if a=="":
            print("MOBILE NUMBER: FIELD MISSING")
        else:
            print("MOBILE NUMBER: INVALID INPUT")
    city=entry6.get()
    print("CITY:",check(city))
    f=0
    try:
        pin=(entry7.get())
        if pin=="":
            print("FIELD MISSING")
        else: 
            pin=int(a)
            while(b!=0):
                b=b//10
                f+=1
            if f==6:
                print(pin)
            else:
                print("PIN CODE: INVALID INPUT")
    except:
        if a=="":
            print("FIELD MISSING")
        else:
            print("PIN CODE: INVALID INPUT")
    
    state=entry8.get()
    print("STATE:",check(state))
    
    board0=entry11.get()
    print("CLASS X BOARD:",check(board0))
    board1=entry14.get()
    print("CLASS XII BOARD:",check(board1))
    board2=entry17.get()
    print("GRADUATION BOARD:",check(board2))
    board3=entry20.get()
    print("MASTERS BOARD:",check(board3))
    
    percentage0=entry12.get()
    print("CLASS X PERCENTAGE:")
    check1(percentage0)
    percentage1=entry15.get()
    print("CLASS XII PERCENTAGE:")
    check1(percentage1)
    percentage2=entry18.get()
    print("GRADUATION PERCENTAGE:")
    check1(percentage2)
    percentage3=entry21.get()
    print("MASTERS PERCENTAGE:")
    check1(percentage3)
    

def delete():
    entry1.delete(0,'end')
    entry2.delete(0,'end')
    entry3.delete(0,'end')
    entry4.delete(0,'end')
    entry5.delete(0,'end')
    entry6.delete(0,'end')
    entry7.delete(0,'end')
    entry8.delete(0,'end')
    entry9.delete(0,'end')
    entry10.delete(0,'end')
    entry10.delete(0,'end')
    entry11.delete(0,'end')
    entry12.delete(0,'end')
    entry13.delete(0,'end')
    entry14.delete(0,'end')
    entry15.delete(0,'end')
    entry16.delete(0,'end')
    entry17.delete(0,'end')
    entry18.delete(0,'end')
    entry19.delete(0,'end')
    entry20.delete(0,'end')
    entry21.delete(0,'end')
    entry22.delete(0,'end')
    var=IntVar()
    var.set(0)
    rb1.config(variable=var)
    rb2.config(variable=var)
    rb3.config(variable=var)
    rb4.config(variable=var)
    rb5.config(variable=var)
    rb6.config(variable=var)
    cb1.config(variable=var)
    cb2.config(variable=var)
    cb3.config(variable=var)
    cb4.config(variable=var)
    cb5.config(variable=var)
label_0 = Label(root, text="STUDENT REGISTRATION FORM",foreground="blue",background="white",width=100,font=("bold", 20))
label_0.place(x=0,y=0)
root.configure(background = "blue")
label1=Label(root,text="FIRST NAME",foreground="white",background="blue",font=("bold",10))
label1.place(x=0,y=70)
entry1=Entry(root,width=30)
entry1.place(x=150,y=70)
label2=Label(root,text="LAST NAME",foreground="white",background="blue",font=("bold",10))
label2.place(x=0,y=100)
entry2=Entry(root,width=30)
entry2.place(x=150,y=100)
label3=Label(root,text="DATE OF BIRTH",foreground="white",background="blue",font=("bold",10))
label3.place(x=0,y=130)
clicked1=StringVar()
clicked2=StringVar()
clicked3=StringVar()
clicked1.set("Day")
clicked2.set("Month")
clicked3.set("Year")
drop1=OptionMenu(root,clicked1,"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
drop1.place(x=150,y=130)
drop2=OptionMenu(root,clicked2,"January","February","March","April","May","June","July","August","September","October","November","December")
drop2.place(x=270,y=130)
drop3=OptionMenu(root,clicked3,"1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021")
drop3.place(x=390,y=130)
label4=Label(root,text="EMAIL ID",foreground="white",background="blue",font=("bold",10))
label4.place(x=0,y=180)
entry3=Entry(root,width=30)
entry3.place(x=150,y=180)
label5=Label(root,text="MOBILE NUMBER",foreground="white",background="blue",font=("bold",10))
label5.place(x=0,y=210)
entry4=Entry(root,width=30)
entry4.place(x=150,y=210)


label6=Label(root,text="GENDER",foreground="white",background="blue",font=("bold",10))
label6.place(x=0,y=240)
var = IntVar()
rb1=Radiobutton(root, text="Male",padx = 5, variable=var, value=1,bg="blue")
rb1.place(x=150,y=240)
rb2=Radiobutton(root, text="Female",padx = 20, variable=var, value=2,bg="blue")
rb2.place(x=250,y=240)
label7=Label(root,text="ADDRESS",foreground="white",background="blue",font=("bold",10))
label7.place(x=0,y=270)
entry5=Entry(root,width=70)
entry5.place(x=150,y=270,height=80)

label8=Label(root,text="CITY",foreground="white",background="blue",font=("bold",10))
label8.place(x=0,y=370)
entry6=Entry(root,width=30)
entry6.place(x=150,y=370)

label9=Label(root,text="PIN CODE",foreground="white",background="blue",font=("bold",10))
label9.place(x=0,y=400)
entry7=Entry(root,width=30)
entry7.place(x=150,y=400)

label10=Label(root,text="STATE",foreground="white",background="blue",font=("bold",10))
label10.place(x=0,y=430)
entry8=Entry(root,width=30)
entry8.place(x=150,y=430)

label11=Label(root,text="COUNTRY",foreground="white",background="blue",font=("bold",10))
label11.place(x=0,y=460)
con=StringVar(root,value='India')
entry9=Entry(root,width=30,textvariable=con)
entry9.place(x=150,y=460)
label12=Label(root,text="HOBBIES",foreground="white",background="blue",font=("bold",10))
label12.place(x=0,y=490)
v1=IntVar()
v2=IntVar()
v3=IntVar()
v4=IntVar()
v5=IntVar()
cb1=Checkbutton(root,text='Drawing',variable=v1,background="blue")
cb1.place(x=150,y=490)
cb2=Checkbutton(root,text='Singing',variable=v2,background="blue")
cb2.place(x=250,y=490)
cb3=Checkbutton(root,text='Dancing',variable=v3,background="blue")
cb3.place(x=350,y=490)
cb4=Checkbutton(root,text='Sketching',variable=v4,background="blue")
cb4.place(x=450,y=490)
cb5=Checkbutton(root,text='Others',variable=v5,background="blue")
cb5.place(x=150,y=520)
entry10=Entry(root,width=30)
entry10.place(x=250,y=520)
label13=Label(root,text="QUALIFICATION",foreground="white",background="blue",font=("bold",10))
label13.place(x=0,y=550)
label14=Label(root,text="Sl.No.",foreground="white",background="blue",font=("bold",10))
label14.place(x=150,y=550)
label15=Label(root,text="Examination",foreground="white",background="blue",font=("bold",10))
label15.place(x=200,y=550)

label16=Label(root,text="Board",foreground="white",background="blue",font=("bold",10),justify="center")
label16.place(x=350,y=550)
label17=Label(root,text="Percentage",foreground="white",background="blue",font=("bold",10))
label17.place(x=450,y=550)
label18=Label(root,text="Year of Passing",foreground="white",background="blue",font=("bold",10))
label18.place(x=570,y=550)

label19=Label(root,text="1",foreground="white",background="blue",font=("bold",10))
label19.place(x=150,y=580)
label20=Label(root,text="Class X",foreground="white",background="blue",font=("bold",10))
label20.place(x=200,y=580)

entry11=Entry(root,width=20)
entry11.place(x=300,y=580)

entry12=Entry(root,width=20)
entry12.place(x=430,y=580)

entry13=Entry(root,width=20)
entry13.place(x=560,y=580)


label21=Label(root,text="2",foreground="white",background="blue",font=("bold",10))
label21.place(x=150,y=605)
label22=Label(root,text="Class XII",foreground="white",background="blue",font=("bold",10))
label22.place(x=200,y=605)

entry14=Entry(root,width=20)
entry14.place(x=300,y=605)

entry15=Entry(root,width=20)
entry15.place(x=430,y=605)

entry16=Entry(root,width=20)
entry16.place(x=560,y=605)

label23=Label(root,text="3",foreground="white",background="blue",font=("bold",10))
label23.place(x=150,y=630)
label24=Label(root,text="Graduation",foreground="white",background="blue",font=("bold",10))
label24.place(x=200,y=630)

entry17=Entry(root,width=20)
entry17.place(x=300,y=630)

entry18=Entry(root,width=20)
entry18.place(x=430,y=630)

entry19=Entry(root,width=20)
entry19.place(x=560,y=630)

label25=Label(root,text="4",foreground="white",background="blue",font=("bold",10))
label25.place(x=150,y=655)
label26=Label(root,text="Masters",foreground="white",background="blue",font=("bold",10))
label26.place(x=200,y=655)

entry20=Entry(root,width=20)
entry20.place(x=300,y=655)

entry21=Entry(root,width=20)
entry21.place(x=430,y=655)

entry22=Entry(root,width=20)
entry22.place(x=560,y=655)
label27=Label(root,text="COURSES     \nAPPLIED FOR",foreground="white",background="blue",font=("bold",10))
label27.place(x=0,y=690)
vari = IntVar()
rb3=Radiobutton(root, text="BCA",padx = 5, variable=vari, value=1,bg="blue")
rb3.place(x=150,y=700)
rb4=Radiobutton(root, text="B.Com.",padx = 5, variable=vari, value=2,bg="blue")
rb4.place(x=200,y=700)
rb5=Radiobutton(root, text="B.Sc.",padx = 5, variable=vari, value=3,bg="blue")
rb5.place(x=265,y=700)
rb6=Radiobutton(root, text="B.A.",padx = 5, variable=vari, value=4,bg="blue")
rb6.place(x=320,y=700)

MyButton1 = Button(root, text="Submit", width=10,foreground="black",background="white",font=("bold",10),bd=2,command=validation)
MyButton1.place(x=350,y=755)
MyButton2 = Button(root, text="Reset", width=10,foreground="black",background="white",font=("bold",10),bd=2,command=delete)
MyButton2.place(x=450,y=755)


root.mainloop()
