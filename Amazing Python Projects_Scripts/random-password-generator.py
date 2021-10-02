from tkinter import *
from tkinter import messagebox
import random2
import clipboard

root = Tk()

root.title("Password Generator by akshay-cybersec")

passstring = StringVar()
passlen = IntVar()

passlen.set(0)


def generate():
    pass1 = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
            'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
            'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', 
            '9', '0', ' ', '!', '@', '#', '$', '%', '^', '&', 
            '*', '(', ')']

    password = ""

    for x in range(passlen.get()):
        password = password + random2.choice(pass1)

    passstring.set(password)

def copy():
    copytoclip = passstring.get()
    clipboard.copy(copytoclip)
    messagebox.showinfo("alert", "Copied to clipboard")


root.geometry("400x230")
root.minsize(350, 200)
root.maxsize(450, 230)

Label(root,text="Password Generator",font=("Arial", 25)).pack()
Label(root,text="Generate a strong password to save your accounts",font=("Arial", 13)).pack()
Entry(root,textvariable = passlen,font=("Arial", 14)).pack()
Label(root,text="How many characters do you want in your password",font=("Arial", 10)).pack()
Button(root,text="Generate",command=generate).pack()
Entry(root,textvariable=passstring,font=("Arial", 14)).pack()
Label(root,text="",font=("Arial", 10)).pack()
Button(root,text="Copy",command=copy).pack()

root.mainloop()
