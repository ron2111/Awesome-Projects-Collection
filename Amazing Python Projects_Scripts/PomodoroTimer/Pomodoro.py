import time
import datetime as dt
import tkinter
from tkinter import messagebox
import winsound

tnow=dt.datetime.now()                  #Current time for reference
tpom=25*60                              #pomodoro time
tdelta=dt.timedelta(0,tpom)              #time delta in mins
tfur=tnow+tdelta                        #Future time,ending pomodoro
deltasec=5*60                           #Break time ,after pomodoro
tfin=tnow+dt.timedelta(0,tpom+deltasec) #Final time (wait/5 min break)

root=tkinter.Tk()
root.withdraw()

messagebox.showinfo("Pomodoro Started !","\n It is now "+tnow.strftime("%H:%M")+"hrs. \n Timer set for 25 mins...")

total=0
breaks=0

while True:
    if tnow < tfur:
        print("Pomodoro")
    
    elif tfur<=tnow<=tfin:
        print("In Break")
        if breaks==0:
            print("If break")

            for i in range(5):
                winsound.Beep((i+100),700)
            print('Break time !')
            breaks=breaks+1

    else:
        print("Finished")
        breaks=0
        for i in range(10):
            winsound.Beep((i+100),500)

        userans=messagebox.askyesno("Pomodoro Finished ,Would you like to start another pomodoro ?")
        total=total+1
        if userans==True:
            tnow=dt.datetime.now()
            tfur=tnow+dt.timedelta(0,tpom)
            tfin=tnow+dt.timedelta(0,tpom+deltasec)
            continue

        elif userans==False:
            messagebox.showinfo("Pomodoro Finished !","\n You completed "
            +str(total)+"pomodoros today !")
            break

    print("Sleeping")
    time.sleep(20)
    tnow=dt.datetime.now()
    timenow=tnow.strftime("%H:%M")
