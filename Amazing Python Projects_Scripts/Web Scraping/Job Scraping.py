# import module 
import requests 
import pandas as pd 
from bs4 import BeautifulSoup 
from tkinter import *
from tkinter import messagebox 
  
res = [] 
def getdata(url): 
    r = requests.get(url) 
    return r.text 
def getinfo(): 
    result = '' 
    htmldata = getdata("https://www.sarkariresult.com/latestjob.php") 
    soup = BeautifulSoup(htmldata, 'html.parser') 
      
    for li in soup.find_all("div", id="post"): 
        result += (li.get_text()) 
    res.set(result) 
  
  
# object of tkinter 
# and background set for light grey 
master = Tk() 
master.configure(bg='light grey') 
  
# Variable Classes in tkinter 
res = StringVar() 
  
# Creating label for each information 
# name using widget Label 
Label(master, text="List of the Jobs :", 
      bg="light grey", font="100").grid(row=0, sticky=W) 
  
# Creating lebel for class variable 
# name using widget Entry 
Label(master, text="", textvariable=res, bg="light grey").grid( 
    row=3, column=1, sticky=W) 
  
# creating a button using the widget 
# Button that will call the submit function 
b = Button(master, text="Get latest job", command=getinfo) 
b.grid(row=0, column=2, columnspan=2, rowspan=2, padx=5, pady=5) 
  
mainloop()