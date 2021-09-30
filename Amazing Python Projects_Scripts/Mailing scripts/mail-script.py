# A simple python based script to read from CSV files and send a message

import smtplib
import csv
import re
import time
from os import system, name
from getpass import getpass

def clear():
	if name=='nt':
		_ = system('cls')
	else:
		_ = system('clear')

clear()
print("Ensure you have saved your database file in the .csv format in this very directory!")
time.sleep(5)
db = input("Enter the database file name with the extension: ")
email = input("Enter your gmail address: ")
password = getpass("Enter your password: ")
server = smtplib.SMTP('smtp.gmail.com', 587)
server.starttls()
server.login(email, password)

with open(''+db+'') as data:
	row = csv.DictReader(data)
	for line in row:
		name = line['fullname']
		msg = "Hey"+name+" ! Hope you're having a good time!"
		add = line['email']
		server.sendmail(email, add, msg)
		print("Mail sent to "+name+"")

server.quit()