#GUI based Calculator
#It performs functions that can be performed between 2 numbers
#It takes a number and when a operation is clicked, it stores it and starts showing the next element
#If any other operation or equals is presseds then it computes the result of previous operations but do not show at screen if other operation is pressed.

from tkinter import *               #importing library

window = Tk()                       #Tkinter instance
window.title('Calculator')          #Title of GUI
window.resizable(0,0)          
z = BooleanVar()                    #z ensures the occurence of decimal point only once.
z.set((True))
prev_data = ''                      #Stores previous operand
cmd2 = ''                           #Stores the operation to perform
commands = ['+','-','*','/']        #Available Commands

def number(digit):                  #Making a string with the numbers pressed
    global prev_data           
    x = data.get()
    data.delete(0, 'end')
    data.insert(0, x + str(digit))


def dec():                          #To insert decimal point
    x = data.get()
    if z.get():
        data.delete(0, 'end')
        data.insert(0, x + '.')
        z.set(False)


def operation(oper):                #To perform operation
    equals()
    global cmd2
    global prev_data
    cmd2 = oper
    if prev_data != '':
        print(data.get())
        equals()
    else:
        prev_data = data.get()
        data.delete(0, 'end')



def clearall():                     #Clears the screen
    data.delete(0, 'end')
    z.set(False)
    global prev_data
    prev_data = ''

def equals():                       #Displays result at screen
    global prev_data
    global cmd2,commands
    if cmd2 in commands:
        y = eval(prev_data+cmd2+(data.get()))
        x = str(format(y, '.5f'))

    else:
        x = data.get()
    prev_data = ''
    data.delete(0, 'end')
    data.insert(0, x)
    cmd2 = ''

#Various parts of GUI
data = Entry(window,width = 15,font = ('',24), justify = 'right')                                      
plusb = Button(window, text = '+',command = lambda: operation('+'),height = 7,width = 8)
minusb = Button(window, text = '-',command = lambda: operation('-'),height = 3,width = 8)
multpyb = Button(window, text = '*',command = lambda: operation('*'),height = 3,width = 8)
divd = Button(window, text = '/',command = lambda: operation('/'),height = 3,width = 8)
decimal = Button(window, text = '.',command = dec,height = 3,width = 8)
equalto = Button(window,text = '=',command = equals,height = 3,width = 8)
bt0 = Button(window, text = '0',command = lambda: number(0),height = 3,width = 18)
bt1 = Button(window, text = '1',command = lambda: number(1),height = 3,width = 8)
bt2 = Button(window, text = '2',command = lambda: number(2),height = 3,width = 8)
bt3 = Button(window, text = '3',command = lambda: number(3),height = 3,width = 8)
bt4 = Button(window, text = '4',command = lambda: number(4),height = 3,width = 8)
bt5 = Button(window, text = '5',command = lambda: number(5),height = 3,width = 8)
bt6 = Button(window, text = '6',command = lambda: number(6),height = 3,width = 8)
bt7 = Button(window, text = '7',command = lambda: number(7),height = 3,width = 8)
bt8 = Button(window, text = '8',command = lambda: number(8),height = 3,width = 8)
bt9 = Button(window, text = '9',command = lambda: number(9),height = 3,width = 8)
clearallb = Button(window, text = 'CE',command = clearall,height = 3,width = 18)

#Placements of various parts on the GUI window
data.grid(row = 0, column = 0,columnspan = 4)
clearallb.grid(row = 1, column = 0,columnspan = 2)
minusb.grid(row = 1, column = 2)
multpyb.grid(row = 1, column = 3)
bt7.grid(row = 2, column = 0)
bt8.grid(row = 2, column = 1)
bt9.grid(row = 2, column = 2)
divd.grid(row = 2, column = 3)
bt4.grid(row = 3, column = 0)
bt5.grid(row = 3, column = 1)
bt6.grid(row = 3, column = 2)
plusb.grid(row = 3, column = 3, rowspan = 2)
bt1.grid(row = 4, column = 0)
bt2.grid(row = 4, column = 1)
bt3.grid(row = 4, column = 2)
bt0.grid(row = 5, column = 0,columnspan = 2)
decimal.grid(row = 5, column = 2)
equalto.grid(row = 5,column = 3)

#To run untill close button is pressed
window.mainloop()