from tkinter import *
import tkinter.messagebox as tmsg
import os
import time
from math import *


def getvals(event):
    value = event.widget.cget('text')
    if value=='Clr':
        sc_variable.set('')
    elif value=='=':
        try:
            sc_variable.set(eval(screen.get()))
            screen.update()
        except Exception as e:
            sc_variable.set('Error - Wait for 3 sec')
            screen.update()
            status_var.set('Preparing...')
            screen.update()
            time.sleep(3)
            sc_variable.set('')
            screen.update()
            status_var.set('Ready..')
            screen.update()

    else:
        sc_variable.set(f'{sc_variable.get()}{value}')



def term_of_use():
    tmsg.showinfo('Terms of Use ','IF YOU LIVE IN (OR IF YOUR PRINCIPAL PLACE OF BUSINESS IS IN) THE UNITED STATES, PLEASE READ THE BINDING ARBITRATION CLAUSE AND CLASS ACTION WAIVER IN SECTION 11. IT AFFECTS HOW DISPUTES ARE RESOLVED.')

def send_feedback():
    ans=tmsg.askquestion('Feedback Hub','Was your experience good with us ? ')
    if ans=='yes':
        tmsg.showinfo('Feedback','Please Rate us on PlayStore')
    else:
        tmsg.showinfo('Feedback','We will contact you soon to know about your bad experience')

root=Tk()
canvas_width=555
canvas_height=620
root.geometry(f'{canvas_width}x{canvas_height}')
root.maxsize(canvas_width,canvas_height)
root.minsize(canvas_width,canvas_height)
root.title('CalCulator ')
root.call('wm', 'iconphoto', root._w, PhotoImage(file='D:\\python programming\\Tkinter-Scientific_calc\\calculator.png'))



my_menu=Menu(root)
m1=Menu(my_menu,tearoff=0,fg='red')
m1.add_command(label='Terms of Use',command=term_of_use)
m1.add_command(label='Send Feedback',command=send_feedback)
root.config(menu=my_menu)
my_menu.add_cascade(label=' About ',menu=m1)
my_menu.add_command(label='Exit',command=quit)


sc_variable=StringVar()
screen=Entry(root,textvariable=sc_variable,font='lucida 35 bold',fg='black',bg='white',borderwidth=10)
screen.pack(pady=30)


f=Frame(root)
f.pack()
b1=Button(f,text='7',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b2=Button(f,text='8',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b3=Button(f,text='9',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b4=Button(f,text='*',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b5=Button(f,text='sin',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b6=Button(f,text='(',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b1.bind('<Button-1>',getvals)
b2.bind('<Button-1>',getvals)
b3.bind('<Button-1>',getvals)
b4.bind('<Button-1>',getvals)
b5.bind('<Button-1>',getvals)
b6.bind('<Button-1>',getvals)
buttons=[b1,b2,b3,b4,b5,b6]
count=0
for i in range(6):
        buttons[count].grid(row=1,column=i)
        count += 1


f=Frame(root)
f.pack()
b1=Button(f,text='4',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b2=Button(f,text='5',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b3=Button(f,text='6',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b4=Button(f,text='-',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b5=Button(f,text='cos',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b6=Button(f,text=')',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)


b1.bind('<Button-1>',getvals)
b2.bind('<Button-1>',getvals)
b3.bind('<Button-1>',getvals)
b4.bind('<Button-1>',getvals)
b5.bind('<Button-1>',getvals)
b6.bind('<Button-1>',getvals)
buttons=[b1,b2,b3,b4,b5,b6]
count=0
for i in range(6):
    buttons[count].grid(row=2,column=i)
    count += 1
f=Frame(root)
f.pack()
b1=Button(f,text='1',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b2=Button(f,text='2',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b3=Button(f,text='3',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b4=Button(f,text='+',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b5=Button(f,text='tan',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b6=Button(f,text='%',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)


b1.bind('<Button-1>',getvals)
b2.bind('<Button-1>',getvals)
b3.bind('<Button-1>',getvals)
b4.bind('<Button-1>',getvals)
b5.bind('<Button-1>',getvals)
b6.bind('<Button-1>',getvals)
buttons=[b1,b2,b3,b4,b5,b6]
count=0
for i in range(6):
    buttons[count].grid(row=3,column=i)
    count += 1
f=Frame(root)
f.pack()
b1=Button(f,text='.',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b2=Button(f,text='0',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b3=Button(f,text='sinh',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b4=Button(f,text='cosh',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b5=Button(f,text='tanh',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b6=Button(f,text='pi',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b1.bind('<Button-1>',getvals)
b2.bind('<Button-1>',getvals)
b3.bind('<Button-1>',getvals)
b4.bind('<Button-1>',getvals)
b5.bind('<Button-1>',getvals)
b6.bind('<Button-1>',getvals)
buttons=[b1,b2,b3,b4,b5,b6]
count=0
for i in range(6):
    buttons[count].grid(row=4,column=i)
    count += 1
f=Frame(root)
f.pack()

b1=Button(f,text='log10',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b2=Button(f,text='exp',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b3=Button(f,text='/',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b4=Button(f,text='Clr',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b5=Button(f,text='log',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)

b6=Button(f,text='=',font='lucida 15 bold',padx=20,pady=20,borderwidth=3,fg='black',bg='grey',width=3)


b1.bind('<Button-1>',getvals)
b2.bind('<Button-1>',getvals)
b3.bind('<Button-1>',getvals)
b4.bind('<Button-1>',getvals)
b5.bind('<Button-1>',getvals)
b6.bind('<Button-1>',getvals)
buttons=[b1,b2,b3,b4,b5,b6]
count=0
for i in range(6):
    buttons[count].grid(row=5,column=i)
    count += 1
status_var=StringVar()
status_var.set('Ready..')
Label(root,textvariable=status_var,relief=SUNKEN,anchor='w',borderwidth=3,bg='yellow',fg='red').pack(side=BOTTOM,fill=X)

root.mainloop()
