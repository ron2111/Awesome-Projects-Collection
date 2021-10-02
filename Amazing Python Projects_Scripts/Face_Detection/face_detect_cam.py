import cv2 as cv
import pyautogui as win

img = cv.VideoCapture(0)

while True:
    isTrue, frame = img.read()
    gray = cv.cvtColor(frame, cv.COLOR_BGR2GRAY)
    haar_cascade = cv.CascadeClassifier('haar_face.xml')
    faces_rect = haar_cascade.detectMultiScale(gray, scaleFactor=1.1, minNeighbors=4)
    print(f'{len(faces_rect)} face(s) detected')
    faces = f'{len(faces_rect)} face(s)'

    cv.putText(frame, faces, (0,25), cv.FONT_HERSHEY_TRIPLEX, 1.0, (0,0,255), thickness=2)
    for (x,y,w,h) in faces_rect:
        cv.rectangle(frame, (x,y), (x+w,y+h), (0,255,0), thickness=2)

    cv.imshow('Video',frame)
    if cv.waitKey(20) & 0xFF==ord('d') :
        break

img.release()
cv.destroyAllWindows()
