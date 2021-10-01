import pyttsx3
import datetime
import speech_recognition as sr
import wikipedia
import smtplib
import webbrowser as wb
import psutil 
import pyjokes
import os
import pyautogui
import random
import json
import requests

import time


from urllib.request import urlopen
engine= pyttsx3.init()


def speak(audio):
     engine.say(audio)
     engine.runAndWait()

def time_():
    time= datetime.datetime.now().strftime("%H:%M:%S")
    speak("The current time is")
    speak(time) 

def date_():
    year = datetime.datetime.now().year
    month=datetime.datetime.now().month   
    date= datetime.datetime.now().day
    speak("The date is")
    speak(date)
    speak(month)
    speak(year)
def wishme():
    speak("Welcome back Raj")
    hour = datetime.datetime.now().hour
    if hour>=6 and hour<12:
        speak("Good morning sir")
    elif hour >=12 and hour<18:
        speak("Good afternoon sir")
    elif hour>=18 and hour<24:
        speak("Good evening sir") 
    else:
        speak("Good night") 
    speak("Alpha is at your service please tell me what you want to do")   


def Takecommand():
    r=sr.Recognizer()
    with sr.Microphone() as source:
        print("Listenin")
        # r.pause_threshold=1
        audio=r.listen(source)
    try:
        print("Recognizing........")
        query=r.recognize_google(audio,language='en-US')
        print(query)
    except Exception as e:
         print(e)
         print("Say that again please....")
         return "None"
    return query   

def sendemail(to,content):
    server=smtplib.SMTP("smtp.gmail.com",587)
    server.ehlo()
    server.starttls()
    server.login('username@gmail.com','password')
    server.sendmail('sender email',to,content)

def cpu():
    usage=str(psutil.cpu_percent())
    speak('CPU is at'+usage)
    battery=psutil.sensors_battery()
    speak('Battery is at')
    speak(battery)

def joke():
    speak(pyjokes.get_joke())

def screenshot():
    img= pyautogui.screenshot()
    img.save('D:\screenshot.png')   

if __name__=="__main__":
    wishme()


    while True:
        query=Takecommand().lower()
        if "time" in query: #tell us time when asked
            time_()
        elif "date" in query:
            date_()    
        elif "wikipedia" in query:
            speak("Searching......")
            query=query.replace('wikipedia','')
            result=wikipedia.summary(query,sentences=3)
            speak("According to Wikipedia")
            print(result)
            speak(result)
        elif 'send email' in query:
            try:
                speak("What should I say?")
                content=Takecommand()
                speak("Who is the receiver?")
                reciever=input("Enter receivers email")
                reciever='reciever_is_me@gmail.com'
                to= reciever
                sendemail(to,content)
                speak(content)
                speak("Email has been sent")
            except Exception as e:
                print("e")
                speak("Unable to send Email")    

        elif 'search chrome' in query:
            speak("What should i search?")
            chromepath = 'C:/Program Files/Google/Chrome/Application/chrome.exe %s '
            search= Takecommand().lower()
            wb.get(chromepath).open_new_tab(search+'.com')

        elif 'open youtube' in query:
            speak('What to search?')
            search_term=Takecommand().lower()
            speak("Here we go to youtube!")
            wb.open('https://www.youtube.com/results?search_query='+search_term)
        elif 'search google' in query:
            speak("What should i search?")
            search_term=Takecommand().lower()
            speak('Searching')
            wb.open('https://www.google.com/search?q='+search_term)

        elif 'CPU' in query:
            cpu()
        elif 'joke' in query:
            joke()
        elif 'go offline' in query:
            speak('Going offline sir!')
            quit()
        elif 'word' in query:
            speak('Opening MS word.....')
            ms_word="C:\Program Files\Microsoft Office\root\Office16\WINWORD.EXE"
            os.startfile(ms_word)
            
        elif 'write a note' in query:
            speak("What to write")
            notes=Takecommand()
            file=open('notes.txt','w')
            speak("Sir should I include Date and time?")
            ans=Takecommand()
            if 'yes' in ans or 'sure' in ans:
                strtime= datetime.datetime.now().strftime("%H:%M:%S")
                file.write(strtime)
                file.write(':-')
                file.write(notes)
                speak('Done Taking Notes,SIR!')
            else:
                file.write(notes)    

        elif 'show notes' in query:
            file=open('notes.txt','r')
            print(file.read())
            speak(file.read())
        elif 'screenshot' in query:
            screenshot()
        elif 'play music' in query:
            songs_dir='D:\screenshot'    
            music=os.listdir(songs_dir)
            speak("What should i play")
            speak('select a number...')
            ans=Takecommand().lower()
            while('number'not in ans and ans != 'random'):
                speak('I couldnt understand what you said')
                ans=Takecommand().lower()
            if 'number' in ans:
                 no=int(ans.replace('number',''))
            elif 'random' in ans:
                no=random.randint(1,100)
            os.startfile(os.path.join(songs_dir,music[no]))
        elif 'remember that' in query:
            speak("What should i remember")    
            memory=Takecommand()
            speak("You asked me to remember that"+memory)
            remember=open('memory.txt','w')
            remember.write(memory)
            remember.close()
        elif 'do you remember anything'in query:
            remember= open('memory.txt','r')
            speak('You asked me to remember that'+remember.read()) 

        elif 'where is' in query:
            query=query.replace('Where is',"")
            location= query
            speak("User asked to locate"+location)
            wb.open_new_tab("https://www.google.com/maps/place/"+location)

             
        elif 'news' in query:
            try:
               jsonObj=urlopen('http://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=5a4579f9a4e4458b8b579781706efb5d') 
               data=json.load(jsonObj)
               i=1
               speak('Here are some top headlines from the tech industry')
               print('===top headlines======'+'\n')
               for item in data['articles']:
                    print(str(i)+'.'+item['title']+'\n')
                    print(item['description']+'\n')
                    speak(item['title'])
                    i+=1

            except Exception as e:
                print(str(e))

       

        elif 'rest' in query:
            speak("For how many seconds you want me to stop listening to your commands ?")
            ans= int(Takecommand())
            time.sleep(ans)
            print(ans)
        elif 'good job' in query:
            speak('Thank you sir')
        elif 'introduce' in query:
            speak('I am jarvis and i am assistant of raj.I love him very much and he created me.I follow all his commands sincerely')        

        