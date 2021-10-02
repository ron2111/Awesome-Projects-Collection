#! /usr/bin/python3
import tkinter as tk    #import tkinter gui lib package
import random as rn     #import random for random clickbox coordinate generator
import time             #import time for calculation of time duration between successfull clicks 


#function to change position of clickbox
def change():
    global x,y
    start = time.time()
    x=rn.randrange(1,490)
    y=rn.randrange(1,490)
    c.delete("all")
    O=c.create_oval(x,y,x+60,y+60,fill="red")
    text.delete(1.0,tk.END)
    def callback(event):
        global x,y,sam,ctr,avg
        ex=event.x
        ey=event.y
        done = time.time()
        elapsed = done - start
        sam+=elapsed
        ctr+=1
        avg=sam/ctr
        if x<ex<x+60 and y<ey<y+60:
            text.insert(tk.INSERT,"\nCurrent Reaction time is "+str(elapsed)+" secs")
            text.insert(tk.INSERT,"\nClick on CHANGE BUTTON THEN FOLLOWED BY"
                                    " CLICKING ON THE CIRCLE")
            x=599
            y=599
            c.delete("all")            
    c.bind("<Button-1>", callback)

def felp(): 
    text.insert(tk.INSERT,"\nCLICK ON CHANGE BUTTON AND THEN CLICK "
                            "ON THE CIRCLE IN THE BLACK AREA THE "
                            "TIME  LAG BETWEEN THE CLICK OF CHANGE "
                            "BUTTON AND CIRCLE WILL GIVE U A REACTION TIME ::::"
                            "LET'S  SEE HOW FAST U CAN GO")

def savg(): #calculating average
    global avg
    text.insert(tk.INSERT,"\nAverage Reaction time is "+str(avg)+" secs")

if __name__=='__main__':  #main function block
    #initialization
    avg=0
    sam=0
    ctr=0
    x=599
    y=599
    
    #gui design for window
    w=tk.Tk()
    w.title("InteliReact")
    frame=tk.Frame(w)
    frame.pack()

    w.attributes('-fullscreen', True)

    c=tk.Canvas(w,bg="black",height=600,width=600)
    c.pack(side=tk.TOP)
    bu1 = tk.Button(w, text="CHANGE THE CLICKBOX POSITION", font="Consolas", command=change)
    bu1.pack(side=tk.LEFT,fill=tk.BOTH)
    
    bu4 = tk.Button(w, text="QUIT TEST", command=w.destroy)
    bu4.pack(side=tk.RIGHT)
    bu3 = tk.Button(w, text="SHOW AVERAGE", command=savg)
    bu3.pack(side=tk.RIGHT)
    bu2 = tk.Button(w, text="HELP", command=felp)
    bu2.pack(side=tk.RIGHT)

    text = tk.Text(w)
    text.pack(side=tk.BOTTOM)
    
    w.mainloop()  #start GUI and keep looping