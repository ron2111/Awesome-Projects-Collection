import pyautogui
import time
pyautogui.hotkey("win","s")
pyautogui.write("Tor Browser")
pyautogui.press("enter")
# increase this if computer is slow
time.sleep(10)
pyautogui.hotkey("ctrl","shift","i")
time.sleep(3)
pyautogui.write('''document.getElementById("connectButton").click()''')
time.sleep(1)
pyautogui.press("enter")
time.sleep(5)
pyautogui.hotkey("alt","d")
pyautogui.write('ip.me')
pyautogui.press("enter")
while True:
    #customize this as per internet speed
    time.sleep(15)
    pyautogui.hotkey("ctrl","shift","l")
