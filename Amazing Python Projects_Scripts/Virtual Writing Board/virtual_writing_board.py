# importing required libraries
import mediapipe as mp  # for handtracking
import cv2  # hand recognization
import numpy as np  # used for creating arrays
import time  # used for having a delay in selecting tool

# dimension and tool contants
ml = 150
max_x, max_y = 250+ml, 50
curr_tool = "select tool"
time_init = True
rad = 40
var_inits = False
thick = 4
prevx, prevy = 0, 0

# get tools function to specify which tool we are using


def getTool(x):
    # tool will be decided fromthe position of the index finger
    if x < 50 + ml:
        return "line"

    elif x < 100 + ml:
        return "rectangle"

    elif x < 150 + ml:
        return"draw"

    elif x < 200 + ml:
        return "circle"

    else:
        return "erase"

# check whether we have our index finger raised so as to choose the tool


def index_raised(yi, y9):
    # if the distance betweem bottom and tip of finger has distance > 40 then
    if (y9 - yi) > 40:
        return True

    return False


# initializing mediapipe to detect hands
hands = mp.solutions.hands
# draw hand landmarks using
hand_landmark = hands.Hands(
    min_detection_confidence=0.6, min_tracking_confidence=0.6, max_num_hands=1)
# draw hand utils
draw = mp.solutions.drawing_utils

#uint8 = 8-bit unsigned integer
# drawing tools
tools = cv2.imread("tools1.png")  # image selected for tools
tools = tools.astype('uint8')  # converting image into uint8

mask = np.ones((480, 640))*400  # creating pixels as matrix in canvas
mask = mask.astype('uint8')  # converting pixel matrix in uint8 conversion

cap = cv2.VideoCapture(0)  # capturing video from webcam
while True:
    _, frm = cap.read()  # reading video
    frm = cv2.flip(frm, 1)  # mirroring the video

    # conversion in rbg color format
    rgb = cv2.cvtColor(frm, cv2.COLOR_BGR2RGB)

    op = hand_landmark.process(rgb)

    if op.multi_hand_landmarks:  # if mediapipe able to detect hands
        # traversing through all the points in hand (0-20)
        for i in op.multi_hand_landmarks:
            # Connect all the points
            draw.draw_landmarks(frm, i, hands.HAND_CONNECTIONS)
            # check the current positiong of landmark
            x, y = int(i.landmark[8].x*640), int(i.landmark[8].y*480)
            # checks whether the point in inside the tools element
            if x < max_x and y < max_y and x > ml:
                # set time delay for choosing the tool
                if time_init:
                    ctime = time.time()
                    time_init = False
                ptime = time.time()
                # form a circle at the time of choosing the tool
                cv2.circle(frm, (x, y), rad, (0, 0, 0), 7)
                rad -= 1
                # checks if delay is greater than 0.8 seconds
                if (ptime - ctime) > 0.8:
                    curr_tool = getTool(x)
                    print("your current tool set to : ", curr_tool)
                    time_init = True
                    rad = 40

            else:
                time_init = True
                rad = 40
            # if selected tool is set to draw
            if curr_tool == "draw":
                # check the tip of middle finger
                xi, yi = int(i.landmark[12].x*640), int(i.landmark[12].y*480)
                y9 = int(i.landmark[9].y*480)  # bottom of index finger

                if index_raised(yi, y9):  # if index raised
                    # draw the line using mask
                    cv2.line(mask, (prevx, prevy), (x, y), 0, thick)
                    # updating the value of prevx and prevy
                    prevx, prevy = x, y

                else:
                    # update to current x and y coordinate of index finger
                    prevx = x
                    prevy = y

            elif curr_tool == "line":
                xi, yi = int(i.landmark[12].x*640), int(i.landmark[12].y*480)
                y9 = int(i.landmark[9].y*480)

                if index_raised(yi, y9):
                    if not(var_inits):
                        xii, yii = x, y
                        var_inits = True

                    cv2.line(frm, (xii, yii), (x, y), (255, 0, 0), thick)

                else:
                    if var_inits:
                        cv2.line(mask, (xii, yii), (x, y), 0, thick)
                        var_inits = False
            # if selected tool is a reactangle
            elif curr_tool == "rectangle":
                # check the current position of middle finger
                xi, yi = int(i.landmark[12].x*640), int(i.landmark[12].y*480)
                # bottom on index finger
                y9 = int(i.landmark[9].y*480)
                # whether it is raised or not
                if index_raised(yi, y9):
                    if not(var_inits):
                        xii, yii = x, y
                        var_inits = True

                    cv2.rectangle(frm, (xii, yii), (x, y), (0, 0, 0), thick)

                else:
                    if var_inits:
                        cv2.rectangle(mask, (xii, yii), (x, y), 0, thick)
                        var_inits = False

            elif curr_tool == "circle":
                xi, yi = int(i.landmark[12].x*640), int(i.landmark[12].y*480)
                y9 = int(i.landmark[9].y*480)

                if index_raised(yi, y9):
                    if not(var_inits):
                        xii, yii = x, y
                        var_inits = True

                    cv2.circle(frm, (xii, yii), int(
                        ((xii-x)**2 + (yii-y)**2)**0.5), (255, 255, 0), thick)

                else:
                    if var_inits:
                        cv2.circle(mask, (xii, yii), int(
                            ((xii-x)**2 + (yii-y)**2)**0.5), (0, 255, 0), thick)
                        var_inits = False

            # tool to erase the masked lines
            elif curr_tool == "erase":
                # check tip of middle finger
                xi, yi = int(i.landmark[12].x*640), int(i.landmark[12].y*480)
                y9 = int(i.landmark[9].y*480)

                if index_raised(yi, y9):
                    # draw circle
                    cv2.circle(frm, (x, y), 30, (0, 0, 0), -1)
                    # removing masked line
                    cv2.circle(mask, (x, y), 30, 255, -1)

    op = cv2.bitwise_and(frm, frm, mask=mask)
    frm[:, :, 1] = op[:, :, 1]
    frm[:, :, 2] = op[:, :, 2]

    # frame the image on the top of the canvas
    frm[:max_y, ml:max_x] = cv2.addWeighted(
        tools, 0.7, frm[:max_y, ml:max_x], 0.3, 0)
    # writing the name of the tool at the right of the image
    cv2.putText(frm, curr_tool, (270+ml, 30),
                cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 0, 255), 2)
    # title of the canvas
    cv2.imshow("CS PROJECT - VIRTUAL PAINTBOARD", frm)

    # for quiting the writing pad
    if cv2.waitKey(1) & 0xFF == ord('q'):
        cv2.destroyAllWindows()
        cap.release()
        break





























