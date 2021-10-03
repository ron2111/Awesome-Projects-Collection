# -*- coding: utf-8 -*-
"""
Created on Sat Apr 18 09:25:35 2020

@author: Dharani Reddy
"""


from flask import Flask
app = Flask(__name__)

@app.route('/')
def hello_world():
   return "Hello World"

if __name__ == '__main__':
   app.run(debug=True)
