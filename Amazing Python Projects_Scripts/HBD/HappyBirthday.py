# Basic concept of the code is to send email to the friend and wish Happy Birthday.

import datetime as dt
import pandas
import random
import smtplib

my_email = "your_email@gmail.com"
passw = "your_password"

data = pandas.read_csv("birthdays.csv")
today = dt.datetime.now()
bday = data[(data.month == today.month) & (data.day == today.day)]
name = bday["name"].tolist()
email = bday["email"].tolist()

# generate friends list
friends = []

# name and email of friends
for n, enumerate(name):
    friends.append(
        {
            "name": name[n],
            "email": email[n]
        }
    )
# check for birthdays
if not friends:
    print("no birthday")
else:
    for friend in friends:
        num = random.randint(1, 3)
        with open(f"letters/letter_{num}.txt") as letter:
            lines = letter.readlines()
            lines[0].strip()
            lines[0] = lines[0].replace("[NAME]", friend["name"])
            message = "".join(lines)
# email friend to wish bday
        with smtplib.SMTP("smtp.gmail.com") as connection:
            connection.starttls()
            connection.login(user=my_email, password=passw)
            connection.sendmail(from_addr=my_email, to_addrs=friend["email"], msg=f"Subject: HAPPY BIRTHDAY\n\n{message}")
            print(f"message sent to {friend['name']}")
