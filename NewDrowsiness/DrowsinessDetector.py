import cv2
from pygame import mixer

#For playing our sound in background
mixer.init()
sound=mixer.Sound("C:\\Users\\AKASH SRIVASTAVA\\Desktop\\NewDrowsiness\\alarm.wav")


# Getting our dataset
# Haar Cascades can be used to detect any types of objects 
# as long as you have the appropriate XML file for it. 

face_cascade = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')
eye_cascade = cv2.CascadeClassifier('haarcascade_eye.xml')
lefteye_cascade = cv2.CascadeClassifier('haarcascade_lefteye_2splits.xml') 

# define a video capture object
vid = cv2.VideoCapture(0)
  
while(True):
      # Capture the video frame by frame
      ret, frame = vid.read()
      grayFrame = cv2.cvtColor(frame , cv2.COLOR_BGR2GRAY)
      faces = face_cascade.detectMultiScale(grayFrame , 1.1, 4)
      
      for (x, y, w, h) in faces:
            cv2.rectangle(frame , (x, y), (x + w, y + h) , (255, 0, 0) , 2)
            x1=(x+w)//2

            #Region of interest for gray and for coloured image 
            roi_gray = grayFrame[y:y + h, x1:x1 + w]
            roi_color = frame[y:y + h, x1:x1 + w]

            eye = 0
            openEye = 0
            closeEye = 0

            openEyes = eye_cascade.detectMultiScale(roi_gray)
            AllEyes = lefteye_cascade.detectMultiScale(roi_gray)

            for (ex, ey, ew, eh) in openEyes:
                  openEye += 1
                  cv2.rectangle(roi_color, (ex, ey), (ex + ew, ey + eh), (0, 255, 0),2)

            for (ex, ey, ew, eh) in AllEyes:
                  eye += 1
                  cv2.rectangle(roi_color, (ex, ey), (ex + ew, ey + eh), (0, 0, 40),2)

                  if (openEye!=eye):
                        sound.play()

      # Display the resulting frame
      cv2.imshow('frame', frame)
      
      # Pressing 'q' will exit the frame 
      # cv2 waitkey() allows you to wait for a specific time in milliseconds 
      # until you press any button on the keyword.

      if cv2.waitKey(1) & 0xFF == ord('q'):
            break


# After the loop vid object is released 
vid.release()

# Destroy all the windows
cv2.destroyAllWindows()