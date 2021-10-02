import tkinter as tk
from PIL import Image, ImageTk
import random




#adding​ images
dice=["dice1.jfif","dice2.jfif","dice3.jfif","dice4.jfif","dice5.jfif","dice6.jfif"]



root=tk.Tk()
root.title("Dice simulator")
root.geometry("300x200")
root.configure(bg = 'yellow')


#label​
l1=tk.Label(root,text="Dice Rolling Simulator",fg="yellow",bg="black",font="Helvetica 16 bold ")
l1.pack()
img = ImageTk.PhotoImage(Image.open(random.choice(dice)))

#Image​ label
l2=tk.Label(root,image=img)
l2.image=img
l2.pack()


def roll():
    img = ImageTk.PhotoImage(Image.open(random.choice(dice)))
    l2.configure(image=img)
    l2.image = img

    
    
#button​  
button = tk.Button(root, text='Roll the Dice', fg='blue', command=roll)

button.pack()

root.mainloop()