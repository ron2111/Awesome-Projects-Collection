import speech_recognition as sr
import gtts
from playsound import playsound
import os as s
import webbrowser
#from time import ctime
import sys
import time


p='/mydir'

if not s.path.exists(p):
    s.makedirs(p)
    
txt=''
lst1=['what is your name','how are you','who are you','what is the time now','search','find location','exit','how old are you','play national anthem']
lst2=['my name is chinnna gadu','i am fine how do you do','i am your friend',time.ctime(),'what do you want to search for?','which place do you want to locate','x','i am 19 years old','Ok I request all my friends to standup at their places, while playing a National Anthem Thank You']

def speakout():
    txt=SpeakText()
    x=0
    t=gtts.gTTS('x')
    if(txt in lst1):
        x=lst1.index(txt)
        if(x==6):
            t=gtts.gTTS('Thank YOu, i miss you, bye bye')
            t.save('c:/mydir/h.mp3')
            playsound('c:/mydir/h.mp3')
            s.remove('c:/mydir/h.mp3')
            sys.exit()
        
        elif(x==4):
            t=gtts.gTTS(lst2[4])
            t.save('c:/mydir/h.mp3')
            playsound('c:/mydir/h.mp3')
            s.remove('c:/mydir/h.mp3')

            txt=SpeakText()

            url='https://google.com/search?q='+txt
            webbrowser.open_new(url)
            
            t=gtts.gTTS('This is what i found for your search request {} '.format(txt))
            t.save('c:/mydir/h.mp3')
            playsound('c:/mydir/h.mp3')
            s.remove('c:/mydir/h.mp3')
            time.sleep(4)

        elif(x==5):
            t=gtts.gTTS(lst2[5])
            t.save('c:/mydir/h.mp3')
            playsound('c:/mydir/h.mp3')
            s.remove('c:/mydir/h.mp3')

            txt=SpeakText()

            url='https://google.nl/maps/place/'+txt+'/&amp;'
            webbrowser.open_new(url)
            
            t=gtts.gTTS('This is what i found for your Asked Location {} '.format(txt))
            t.save('c:/mydir/h.mp3')
            playsound('c:/mydir/h.mp3')
            s.remove('c:/mydir/h.mp3')
            time.sleep(4)
        else:
            t=gtts.gTTS(lst2[x])
            t.save("c:/mydir/h.mp3")
            playsound("c:/mydir/h.mp3")
            s.remove('c:/mydir/h.mp3')
            if(x==8):
                #url='https://www.youtube.com/watch?v=sHSAOKYVzwg'
                #webbrowser.open_new(url)
                playsound('c:/mydir/anthem.mp3')
                time.sleep(2)
    
    t=gtts.gTTS('how can i help you')
    t.save('c:/mydir/h.mp3')
    playsound('c:/mydir/h.mp3')
    s.remove('c:/mydir/h.mp3')

# Initialize the recognizer 
 
        
# Function to convert text to
# speech

def SpeakText():
    r = sr.Recognizer()  
    try:
        # use the microphone as source for input.
        with sr.Microphone() as source:
              
            # wait for a second to let the recognizer
            # adjust the energy threshold based on
            # the surrounding noise level 
            r.adjust_for_ambient_noise(source, duration=0)
              
            #listens for the user's input 
            abc = r.listen(source)
              
            # Using ggogle to recognize audio
            tx = r.recognize_google(abc)
            tx = tx.lower()
  
            print("Did you say "+tx)
            return(tx)           
              
    except sr.RequestError as e:
        print("Could not request results; {0}".format(e))
          
    except sr.UnknownValueError:
        print("unknown error occured")


while True:
    print("Ask a Question : ")
    speakout()



