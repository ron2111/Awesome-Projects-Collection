import pyqrcode
import time
from pyzbar.pyzbar import decode
from PIL import Image
if __name__ == '__main__':

    while 1:
        print("What do you want to do: \n1.Generate QR Code\n2.Scan QR Code")
        sa = int(input())
        if sa == 1:
            sen = input("Please write something : ")
            qr = pyqrcode.create(sen)
            file = input("Under what name do you want to save the file: ")
            qr.png(f'{file}.png', scale=8)
            time.sleep(2)
            print("Successfully generated...")
        elif sa == 2:
            say = input("Which file do you want to Scan: ")
            a = decode(Image.open(f"{say}.png"))
            print("Scanning...")
            time.sleep(2)
            print(f"\nText Scanned :  {a[0][0]}")
        else:
            print("Warning!, wrong choice, Please try again")

        tri = input("Do you want to continue - Press[Y/N]").lower()
        if tri == 'y':
            continue
        else:
            exit()
