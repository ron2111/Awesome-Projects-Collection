import cv2
import numpy as np

'''
Author Name: Manas Gupta
Description : This code will just identify all the red objects nearby seen through camera 

'''

cap=cv2.VideoCapture(1)
#cap=cv2.VideoCapture(0)
''' if you are using your webcam change your camera to 0
I used my mobile camera to test the code '''

while(1) :

    ret,frame=cap.read()
    hsv=cv2.cvtColor(frame,cv2.COLOR_BGR2HSV)
    
    lower_red=np.array([150,150,50])
    upper_red=np.array([255,255,180])

    mask=cv2.inRange(hsv,lower_red,upper_red)
    
    kernel=np.ones((1,1),np.uint8) # you can change the dimention of kenel matrix accordingly
 
    opening=cv2.morphologyEx(mask,cv2.MORPH_OPEN,kernel)
    closing=cv2.morphologyEx(mask,cv2.MORPH_CLOSE,kernel)

     
    finalImageMask=opening+closing
     
    res=cv2.bitwise_and(frame,frame,mask=finalImageMask)
    #cv2.imshow('frame',frame)
    #cv2.imshow('mask',mask)
    #cv2.imshow('res',res)
    cv2.imshow('res',res)
   

    k = cv2.waitKey(5) & 0xFF # simply press esc to break 
    if k == 27:
        break

cv2.destroyAllWindows()
cap.release()   
