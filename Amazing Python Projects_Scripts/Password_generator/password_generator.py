import string
import random
import tkinter as tk
from tkinter import messagebox
from PIL import ImageTk ##Importing this library for background image
root = tk.Tk()
root.geometry('350x260')
root.title("Password Generator App")

##This will make the window Non-Resizable
root.resizable(False,False)

##Setting the Background Image
root.bg = ImageTk.PhotoImage(file="14.jpg")
root.bg_image=tk.Label(root,image=root.bg)

##Placing the background image
root.bg_image.place(x=0,y=0)

x=tk.StringVar()

s = []

s1 = string.ascii_uppercase
s2 = string.ascii_lowercase
s3 = string.digits
s4 = string.punctuation

##Generate password Function
def generatepass():
    a = x.get()
    try:
        if a == "":
            messagebox.showerror("Error",
                                 "Invalid Input",
                                  parent=root )
        passlen = int(a)
        if passlen <= 0 :
            messagebox.showerror("Error",
                                 "Invalid Input",
                                  parent=root )
        else:
            s.extend(list(s1))
            s.extend(list(s2))
            s.extend(list(s3))
            s.extend(list(s4))
            random.shuffle(s)
            pas = "".join(s[0:passlen])
            lbl = tk.Label(root,
                           text=pas,
                           font=("times new roman",15,"bold"))
            lbl.place(x=50,
                      y=170,
                      width=250)
    except:
        pass
## Quit Button function
def finish():
    exit()

## Writing the Text as Label
labl = tk.Label(root,
                text="Enter the Length of the Password :-",
                font=("times new roman",15,"bold"))
##Placing the Label
labl.place(x=10,
           y=20)
### ENTRY BOX to get the Length of the password
Length_of_password = tk.Entry(root,
                              font=('Ubuntu',16),
                              textvariable=x)
## Setting the position of the Entry Box
Length_of_password.place(x=10,
                         y=70,
                         height=30,
                         width=330)
##Generate password Button
but = tk.Button(root,
                text="Generate the Password",
                fg="white",
                command=generatepass,
                font=("times new roman",15,"bold"),
                bg="black")
## Setting the position of the button
but.place(x=10,
          y=130,
          height=30,
          width=330)
## Quit Button
but1 = tk.Button(root,
                 text="QUIT",
                 fg="white",
                 command=finish,
                 font=("times new roman",15,"bold"),
                 bg="red")
## Setting the position of the Quit Button
but1.place(x=10,
           y=220,
           height=30,
           width=330)

root.mainloop()