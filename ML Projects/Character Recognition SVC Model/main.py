'''
/*
 * @Author: Pasindu Akalpa 
 * @Date: 2021-01-22 22:54:13 
 * @Last Modified by: Pasindu Akalpa
 * @Last Modified time: 2021-01-23 01:10:54
 */
'''
import tkinter as tk
from PIL import Image,ImageDraw,ImageTk
import numpy as np
import cv2
import os
import joblib

model = joblib.load('English_Char_SVC.sav')

win = tk.Tk()

count = 0
width = 500
height = 500
font_btn = 'Helvetica 20 bold'
font_lbl = 'Helvetica 22 bold'
lbl_dict = {0:'A',1:'B',2:'C',3:'D',4:'E',5:'F',6:'G',7:'H',8:'I',9:'J',10:'K',11:'L',12:'M',13:'N',14:'O',15:'P',16:'Q',17:'R',18:'S',19:'T',20:'U',21:'V',22:'W',23:'X',24:'Y',25:'Z'}

def event_function(event):
    x = event.x
    y = event.y
    
    x1 = x-20
    x2 = x+20

    y1 = y-20
    y2 = y+20

    canvas.create_oval((x1,y1,x2,y2),fill='black')
    img_draw.ellipse((x1,y1,x2,y2),fill='black')

def save():
    global count
    if not os.path.exists('data'):
        os.makedirs('data')
    img_array = np.array(img)
    path = os.path.join('data',str(count)+'.jpg')
    cv2.imwrite(path,img_array)
    count = count + 1

def clear():
    global img,img_draw

    canvas.delete('all')
    img = Image.new('RGB',(width,height),(255,255,255))
    img_draw = ImageDraw.Draw(img)
    pLbl.config(text='PREDICTED CHARACTER: NONE')

def predict():
    img_array = np.array(img)

    img_array = cv2.cvtColor(img_array,cv2.COLOR_BGR2GRAY)
    img_array = cv2.resize(img_array,(28,28))
    img_array = np.reshape(img_array,(1,784))

    result = model.predict(img_array)[0]
    #print(lbl_dict[result])
    sCharacter = lbl_dict[result]
    pLbl.config(text='PREDICTED CHARACTER:'+sCharacter)

canvas = tk.Canvas(win,width=width,height=height,bg='white')
canvas.grid(row=0,column=0,columnspan=4)

saveBtn = tk.Button(win,text='SAVE',bg='green',fg='white',font=font_btn,command=save)
saveBtn.grid(row=1,column=0)
predictBtn = tk.Button(win,text='PREDICT',bg='blue',fg='white',font=font_btn,command=predict)
predictBtn.grid(row=1,column=1)
clearBtn = tk.Button(win,text='CLEAR',bg='yellow',fg='white',font=font_btn,command=clear)
clearBtn.grid(row=1,column=2)
exitBtn = tk.Button(win,text='EXIT',bg='red',fg='white',font=font_btn,command=win.destroy)
exitBtn.grid(row=1,column=3)

pLbl = tk.Label(win,text='PREDICTED CHARACTER: NONE',bg='white',font=font_lbl)
pLbl.grid(row=2,column=0,columnspan=4)

canvas.bind('<B1-Motion>',event_function)

img = Image.new('RGB',(width,height),(255,255,255))
img_draw = ImageDraw.Draw(img)

#win.iconbitmap('src/icon.ico')
win.title('English Character Recognizer')
win.mainloop()