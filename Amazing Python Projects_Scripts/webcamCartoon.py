from cv2 import cv2
import numpy as np

cap=cv2.VideoCapture(0)
cap.set(3,1536)
cap.set(4,864)
cap.set(10,100)

while True:
    success,img=cap.read()
    imgResize=cv2.resize(img,(1536,864))
    imgBlur=cv2.pyrDown(imgResize)
    num_iter = 5
    for _ in range(num_iter):
        imgBlur= cv2.bilateralFilter(imgBlur, d=9, sigmaColor=9, sigmaSpace=7)
    imgRGB=cv2.pyrUp(imgBlur)

    imgGray=cv2.cvtColor(imgRGB,cv2.COLOR_RGB2GRAY)
    imgBLUR=cv2.medianBlur(imgGray,7)

    imgEdge=cv2.adaptiveThreshold(imgBLUR,255,cv2.ADAPTIVE_THRESH_GAUSSIAN_C,cv2.THRESH_BINARY,9,2)
    imgEdge = img2 = cv2.merge((imgEdge,imgEdge,imgEdge))
    array=cv2.bitwise_and(imgRGB,imgEdge)
    cv2.imshow('Image',array) 
    if cv2.waitKey(1)&0xFF==ord('q'):
        cv2.imwrite("Cartoon1.jpg",array)
        cap.release()
        cv2.destroyAllWindows()
        break