import img2pdf 
import PyPDF2 as pd
from PIL import Image 
import os 

def imgtopdf():
    list1 = []

    i= 1 

    for items in os.listdir():
        if items.endswith('.png') or items.endswith('.jpg') or items.endswith('.jpeg'):
            list1.append(items)
            print(i,"-",items)
            i=i+1

    def convert():
        n = list(map(int,input("Serial number of image separated by space and in proper sequence ").split()))
        print(n)
        for i in n:
        
            try:
                e= list1[i-1]
                image = Image.open(e)
                if image.mode == "RGBA":
                    image = image.convert("RGB")
                output= e.strip('.png') + ".pdf"
                image.save(output,"PDF",resolution=100.0)
            
            except:
                print("Please enter a number in range.")
                convert()
    convert()

def pdfmakeone():
    merger = pd.PdfFileMerger()

    list2 = []

    i= 1

    for things in os.listdir():
        if things.endswith('.pdf'):
            list2.append(things)
            print(i,"-",things)
            i=i+1


    def number():
        p = list(map(int,input("Serial number of pdf separated by space and in proper sequence ").split()))
        print(p)
        for i in p:
            try:
                s= list2[i-1]
                merger.append(s)
            except:
                print("Please enter a number in range.")
                number()

    number()
    merger.write("Final.pdf")
    merger.close()


option = input("Reply \"C\" for converting images to pdf and then merging pdfs and \"M\" for ony merging pdf\n").capitalize()

if option == "C":
    imgtopdf()
    pdfmakeone()
else:
    pdfmakeone()