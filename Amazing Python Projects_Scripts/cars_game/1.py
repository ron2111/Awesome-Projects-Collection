import pygame
import sys

pygame.init()

black=(128, 128, 128)
black_1= (0, 0, 0)
red=(255, 0, 0)
green=(0,200,0)
blue=(0,0,200)
bright_red=(255,0,0)
bright_green=(0,255,0)
bright_blue=(0,0,255)

display_width = 800
display_height = 600

import time
import random

gamedisplay = pygame.display.set_mode((display_width, display_height))
pygame.display.set_caption(" Car Game")
clock=pygame.time.Clock()
carimg=pygame.image.load('Untitled-1-01.png')
#green_car.jpg
backgroundpic = pygame.image.load("green_strip.jpg")
yellow_strip = pygame.image.load("yellow_strip.jpg")
strip= pygame.image.load("white.jpg")
intro_background= pygame.image.load("bc2.jpg")
instruction_background=pygame.image.load("bc2.jpg")
car_width=61
pause=False

def intro_loop():
    intro=True
    while intro:
        for event in pygame.event.get():
            if event.type==pygame.QUIT:
                pygame.quit()
                quit()
                sys.exit(0)
        gamedisplay.blit(intro_background ,(0,0))
        largetext = pygame.font.Font("freesansbold.ttf", 115)
        TextSurf, TextRect = text_object("CAR GAME", largetext)
        TextRect.center = (400,100)
        gamedisplay.blit(TextSurf, TextRect)
        button("START",150,520,100,50,green,bright_green,"play")
        button("QUIT", 550, 520, 100, 50, red, bright_red, "quit")
        button("INSTRUCTION", 300, 520, 200, 50, blue, bright_blue, "intro")
        pygame.display.update()
        clock.tick(50)


def button(msg,x,y,w,h,ic,ac,action=None):
    mouse= pygame.mouse.get_pos()
    click=pygame.mouse.get_pressed()
    if x+w> mouse[0]>x and y+h>mouse[1]>y:
        pygame.draw.rect(gamedisplay,ac,(x,y,w,h))
        if click[0]==1 and action!= None:
            if action=="play":
                countdown()
            elif action=="quit":
                pygame.quit()
                quit()
                sys.exit()
            elif action=="intro":
                introduction()
            elif action=="menu":
                intro_loop()
            elif action=="pause":
                paused()
            elif action=="unpause":
                unpaused()
    else:
        pygame.draw.rect(gamedisplay,ic,(x,y,w,h))
    smalltext = pygame.font.Font("freesansbold.ttf", 20)
    textsurf, textrect = text_object(msg, smalltext)
    textrect.center = ((x+(w/2)), (y+(h/2)))
    gamedisplay.blit(textsurf, textrect)



def introduction():
    introduction = True
    while introduction:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
                sys.exit()
        gamedisplay.blit(intro_background, (0, 0))
        largetext = pygame.font.Font("freesansbold.ttf", 80)
        smalltext = pygame.font.Font("freesansbold.ttf", 20)
        mediumtext = pygame.font.Font("freesansbold.ttf", 40)
        textsurf, textrect = text_object("This is a car game in which you need dodge the coming cars", smalltext)
        textrect.center = ((350), (200))
        Textsurf, Textrect = text_object("Instructuion", largetext)
        Textrect.center = ((400), (100))
        gamedisplay.blit(textsurf, textrect)
        gamedisplay.blit(Textsurf, Textrect)
        stextsurf, stextrect = text_object("ARROW LEFT : LEFT TURN", smalltext)
        stextrect.center = ((150), (400))
        htextsurf, htextrect = text_object("ARROW RIGHT : RIGHT TURN", smalltext)
        htextrect.center = ((150), (450))
        atextsurf, atextrect = text_object("A : ACCELERATOR", smalltext)
        atextrect.center = ((150), (500))
        rtextsurf, rtextrect = text_object("B : BREAK", smalltext)
        rtextrect.center = ((150), (550))
        Ptextsurf, Ptextrect = text_object("P : PAUSE", smalltext)
        Ptextrect.center = ((150), (580))
        Stextsurf, Stextrect = text_object("CONTROLS", mediumtext)
        Stextrect.center = ((400), (300))
        gamedisplay.blit(stextsurf, stextrect)
        gamedisplay.blit(htextsurf, htextrect)
        gamedisplay.blit(atextsurf, atextrect)
        gamedisplay.blit(rtextsurf, rtextrect)
        gamedisplay.blit(Ptextsurf, Ptextrect)
        gamedisplay.blit(Stextsurf, Stextrect)
        button("BACK", 600, 450, 100, 50, blue, bright_blue, "menu")
        pygame.display.update()
        clock.tick(30)



def paused():
    global pause

    while pause:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
                sys.exit()
        gamedisplay.blit(instruction_background, (0, 0)) #load image for background
        largetext = pygame.font.Font("freesansbold.ttf", 115)
        TextSurf, TextRect = text_object("PAUSED", largetext)
        TextRect.center = ((display_width/2),(display_height/2))
        gamedisplay.blit(TextSurf, TextRect)
        button("CONTINUE", 150, 450, 150, 50, green, bright_green, "unpause")
        button("RESTART", 350, 450, 150, 50, red, bright_red, "play")
        button("MAIN MENU", 550, 450, 200, 50, blue, bright_blue, "menu")
        pygame.display.update()
        clock.tick(30)

def unpaused():
    global pause
    pause=False

def countdown_background():
    font=pygame.font.SysFont(None,25)
    x = (display_width * 0.5)
    y = (display_height * 0.75)
    gamedisplay.blit(backgroundpic, (0, 0))
    gamedisplay.blit(backgroundpic, (0, 200))
    gamedisplay.blit(backgroundpic, (0, 400))
    gamedisplay.blit(backgroundpic, (700, 0))
    gamedisplay.blit(backgroundpic, (700, 200))
    gamedisplay.blit(backgroundpic, (700, 400))
    gamedisplay.blit(yellow_strip, (400, 0))
    gamedisplay.blit(yellow_strip, (400, 200))
    gamedisplay.blit(yellow_strip, (400, 400))
    gamedisplay.blit(yellow_strip, (400, 600))
    gamedisplay.blit(yellow_strip, (400, 800))
    gamedisplay.blit(strip, (120, 0))
    gamedisplay.blit(strip, (120, 34))
    gamedisplay.blit(strip, (120, 68))
    gamedisplay.blit(strip, (120, 102))
    gamedisplay.blit(strip, (120, 136))
    gamedisplay.blit(strip, (120, 170))
    gamedisplay.blit(strip, (120, 204))
    gamedisplay.blit(strip, (120, 238))
    gamedisplay.blit(strip, (120, 272))
    gamedisplay.blit(strip, (120, 306))
    gamedisplay.blit(strip, (120, 340))
    gamedisplay.blit(strip, (120, 374))
    gamedisplay.blit(strip, (120, 408))
    gamedisplay.blit(strip, (120, 442))
    gamedisplay.blit(strip, (120, 476))
    gamedisplay.blit(strip, (120, 510))
    gamedisplay.blit(strip, (120, 544))
    gamedisplay.blit(strip, (120, 578))
    gamedisplay.blit(strip, (120, 612))

    gamedisplay.blit(strip, (675, 0))
    gamedisplay.blit(strip, (675, 34))
    gamedisplay.blit(strip, (675, 68))
    gamedisplay.blit(strip, (675, 102))
    gamedisplay.blit(strip, (675, 136))
    gamedisplay.blit(strip, (675, 170))
    gamedisplay.blit(strip, (675, 204))
    gamedisplay.blit(strip, (675, 238))
    gamedisplay.blit(strip, (675, 272))
    gamedisplay.blit(strip, (675, 306))
    gamedisplay.blit(strip, (675, 340))
    gamedisplay.blit(strip, (675, 374))
    gamedisplay.blit(strip, (675, 408))
    gamedisplay.blit(strip, (675, 442))
    gamedisplay.blit(strip, (675, 476))
    gamedisplay.blit(strip, (675, 510))
    gamedisplay.blit(strip, (675, 544))
    gamedisplay.blit(strip, (675, 578))
    gamedisplay.blit(strip, (675, 612))
    gamedisplay.blit(carimg,(x,y))
    text = font.render("DODGED  " , True, black_1)
    score = font.render("SCORE  " , True, red)
    gamedisplay.blit(text, (0, 50))
    gamedisplay.blit(score, (0, 30))
    button("PAUSE", 650, 150, 150, 50, blue, bright_blue, "pause")

def countdown():
    countdowm=True
    while countdown:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()

                quit()
        gamedisplay.fill((black))
        countdown_background()
        largetext = pygame.font.Font("freesansbold.ttf", 115)
        textsurf, textrect = text_object("3", largetext)
        textrect.center = ((display_width / 2), (display_height / 2))
        gamedisplay.blit(textsurf, textrect)
        pygame.display.update()
        clock.tick(1)
        gamedisplay.fill((black))
        countdown_background()
        largetext = pygame.font.Font("freesansbold.ttf", 115)
        textsurf, textrect = text_object("2", largetext)
        textrect.center = ((display_width / 2), (display_height / 2))
        gamedisplay.blit(textsurf, textrect)
        pygame.display.update()
        clock.tick(1)
        gamedisplay.fill((black))
        countdown_background()
        largetext = pygame.font.Font("freesansbold.ttf", 115)
        textsurf, textrect = text_object("1", largetext)
        textrect.center = ((display_width / 2), (display_height / 2))
        gamedisplay.blit(textsurf, textrect)
        pygame.display.update()
        clock.tick(1)
        gamedisplay.fill((black))
        countdown_background()
        largetext = pygame.font.Font("freesansbold.ttf", 115)
        textsurf, textrect = text_object("GO !!!", largetext)
        textrect.center = ((display_width / 2), (display_height / 2))
        gamedisplay.blit(textsurf, textrect)
        pygame.display.update()
        clock.tick(1)
        game_loop()



def obstacle(obs_startx,obs_starty,obs):
    if obs==0:
        obs_pic = pygame.image.load("Untitled-8-01.png") #Untitled-2-01.png
        #obs_pic.set_ColorKey(black_1)
    elif obs==1:
        obs_pic = pygame.image.load("Untitled-3-01.png") #car5-01
    elif obs == 2:
        obs_pic = pygame.image.load("Untitled-4-01.png")
    elif obs == 3:
        obs_pic = pygame.image.load("Untitled-6-01.png")
    elif obs == 4:
        obs_pic = pygame.image.load("Untitled-7-01.png")
    elif obs == 5:
        obs_pic = pygame.image.load("Untitled-5-01.png")
    elif obs == 6:
        obs_pic = pygame.image.load("Untitled-8-01.png")
    gamedisplay.blit(obs_pic,(obs_startx, obs_starty))

def score_system(passed,score):
    font=pygame.font.SysFont(None,25)
    text=font.render("DODGED  "+str(passed), True,black_1)
    score=font.render("SCORE  "+str(score), True,red)
    gamedisplay.blit(text, (0, 50))
    gamedisplay.blit(score, (0, 30))


def text_object(text,font):
    textsurface=font.render(text, True, black_1)
    return textsurface, textsurface.get_rect()

def message_display(text):
    largetext = pygame.font.Font("freesansbold.ttf", 80)
    textsurf, textrect= text_object(text,largetext)
    textrect.center=((display_width/2),(display_height/2))
    gamedisplay.blit(textsurf,textrect)
    pygame.display.update()
    time.sleep(3)
    game_loop()

def crash():
     message_display("YOU CRASHED")


def background():
    gamedisplay.blit(backgroundpic,(0,0))
    gamedisplay.blit(backgroundpic, (0, 200))
    gamedisplay.blit(backgroundpic, (0, 400))
    gamedisplay.blit(backgroundpic, (700, 0))
    gamedisplay.blit(backgroundpic, (700, 200))
    gamedisplay.blit(backgroundpic, (700, 400))
    gamedisplay.blit(yellow_strip, (400, 0))
    gamedisplay.blit(yellow_strip, (400, 200))
    gamedisplay.blit(yellow_strip, (400, 400))
    gamedisplay.blit(yellow_strip, (400, 600))
    gamedisplay.blit(yellow_strip, (400, 800))

    gamedisplay.blit(strip, (120, 0))
    gamedisplay.blit(strip, (120, 178))
    gamedisplay.blit(strip, (120, 356))
    gamedisplay.blit(strip, (120, 534))
    gamedisplay.blit(strip, (120, 600))

    gamedisplay.blit(strip, (675, 0))
    gamedisplay.blit(strip, (675, 178))
    gamedisplay.blit(strip, (675, 356))
    gamedisplay.blit(strip, (675, 534))
    gamedisplay.blit(strip, (675, 600))


    '''
    gamedisplay.blit(strip, (120, 0))
    gamedisplay.blit(strip, (120, 34))
    gamedisplay.blit(strip, (120, 68))
    gamedisplay.blit(strip, (120, 102))
    gamedisplay.blit(strip, (120, 136))
    gamedisplay.blit(strip, (120, 170))
    gamedisplay.blit(strip, (120, 204))
    gamedisplay.blit(strip, (120, 238))
    gamedisplay.blit(strip, (120, 272))
    gamedisplay.blit(strip, (120, 306))
    gamedisplay.blit(strip, (120, 340))
    gamedisplay.blit(strip, (120, 374))
    gamedisplay.blit(strip, (120, 408))
    gamedisplay.blit(strip, (120, 442))
    gamedisplay.blit(strip, (120, 476))
    gamedisplay.blit(strip, (120, 510))
    gamedisplay.blit(strip, (120, 544))
    gamedisplay.blit(strip, (120, 578))
    gamedisplay.blit(strip, (120, 612))

    gamedisplay.blit(strip, (675, 0))
    gamedisplay.blit(strip, (675, 34))
    gamedisplay.blit(strip, (675, 68))
    gamedisplay.blit(strip, (675, 102))
    gamedisplay.blit(strip, (675, 136))
    gamedisplay.blit(strip, (675, 170))
    gamedisplay.blit(strip, (675, 204))
    gamedisplay.blit(strip, (675, 238))
    gamedisplay.blit(strip, (675, 272))
    gamedisplay.blit(strip, (675, 306))
    gamedisplay.blit(strip, (675, 340))
    gamedisplay.blit(strip, (675, 374))
    gamedisplay.blit(strip, (675, 408))
    gamedisplay.blit(strip, (675, 442))
    gamedisplay.blit(strip, (675, 476))
    gamedisplay.blit(strip, (675, 510))
    gamedisplay.blit(strip, (675, 544))
    gamedisplay.blit(strip, (675, 578))
    gamedisplay.blit(strip, (675, 612))
    '''
















def car(x, y):
    gamedisplay.blit(carimg,(x,y))




def game_loop():
    global  pause
    x=(display_width*0.5)
    y=(display_height*0.75)
    x_change = 0
    
    obstacle_speed = 8
    obs = 0
    y_change = 0
    obs_startx = random.randrange(200,(display_width-200))
    obs_starty =-750
    obs_width=30
    obs_height=60
    passed=0
    level=0
    score=0
    y2=7
    fs=120




    turned= False
    while not turned:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
            if event.type== pygame.KEYDOWN:
                if event.key== pygame.K_LEFT:
                    x_change = -5
                if event.key== pygame.K_RIGHT:
                    x_change= 5

                if event.key==pygame.K_a:
                    obstacle_speed+=2
                if event.key== pygame.K_b:
                     obstacle_speed-= 2


            if event.type == pygame.KEYUP:
                if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT :
                    x_change = 0
        x+= x_change
        pause=True
        gamedisplay.fill(black)
        rel_y=y2%backgroundpic.get_rect().width
        gamedisplay.blit(backgroundpic,(0,rel_y-backgroundpic.get_rect().width))
        gamedisplay.blit(backgroundpic, (700, rel_y - backgroundpic.get_rect().width))
        if rel_y<800:
            gamedisplay.blit(backgroundpic, (0, rel_y))
            gamedisplay.blit(backgroundpic, (0, 200))
            gamedisplay.blit(backgroundpic, (0, 400))
            gamedisplay.blit(backgroundpic, (700, rel_y))
            gamedisplay.blit(backgroundpic, (700, rel_y+200))
            gamedisplay.blit(backgroundpic, (700, rel_y+400))
            gamedisplay.blit(yellow_strip, (400, rel_y+0))
            gamedisplay.blit(yellow_strip, (400, rel_y+200))
            gamedisplay.blit(yellow_strip, (400, rel_y+400))
            gamedisplay.blit(yellow_strip, (400, rel_y+600))
            gamedisplay.blit(yellow_strip, (400, rel_y+800))
            gamedisplay.blit(strip, (120, rel_y+0))
            gamedisplay.blit(strip, (120, rel_y+178))
            gamedisplay.blit(strip, (120, rel_y+356))
            gamedisplay.blit(strip, (120, rel_y+534))
            gamedisplay.blit(strip, (120, rel_y+600))
            '''
            gamedisplay.blit(strip, (120, rel_y+170))
            gamedisplay.blit(strip, (120, rel_y+204))
            gamedisplay.blit(strip, (120, rel_y+238))
            gamedisplay.blit(strip, (120, rel_y+272))
            gamedisplay.blit(strip, (120, rel_y+306))
            gamedisplay.blit(strip, (120, rel_y+340))
            gamedisplay.blit(strip, (120, rel_y+374))
            gamedisplay.blit(strip, (120, rel_y+408))
            gamedisplay.blit(strip, (120, rel_y+442))
            gamedisplay.blit(strip, (120, rel_y+476))
            gamedisplay.blit(strip, (120, rel_y+510))
            gamedisplay.blit(strip, (120, rel_y+544))
            gamedisplay.blit(strip, (120, rel_y+578))
            gamedisplay.blit(strip, (120, rel_y+612))
            
            '''

            gamedisplay.blit(strip, (675, rel_y+0))
            gamedisplay.blit(strip, (675, rel_y+178))
            gamedisplay.blit(strip, (675, rel_y+356))
            gamedisplay.blit(strip, (675, rel_y+534))
            gamedisplay.blit(strip, (675, rel_y+600))

            '''
            gamedisplay.blit(strip, (675, rel_y+170))
            gamedisplay.blit(strip, (675,rel_y+204))
            gamedisplay.blit(strip, (675, rel_y+238))
            gamedisplay.blit(strip, (675, rel_y+272))
            gamedisplay.blit(strip, (675, rel_y+306))
            gamedisplay.blit(strip, (675, rel_y+340))
            gamedisplay.blit(strip, (675, rel_y+374))
            gamedisplay.blit(strip, (675, rel_y+408))
            gamedisplay.blit(strip, (675, rel_y+442))
            gamedisplay.blit(strip, (675, rel_y+476))
            gamedisplay.blit(strip, (675, rel_y+510))
            gamedisplay.blit(strip, (675, rel_y+544))
            gamedisplay.blit(strip, (675, rel_y+578))
            gamedisplay.blit(strip, (675, rel_y+612))
            gamedisplay.blit(strip, (675, rel_y + 646))
            gamedisplay.blit(strip, (675, rel_y + 680))
            gamedisplay.blit(strip, (675, rel_y + 714))
            gamedisplay.blit(strip, (675, rel_y + 748))
            gamedisplay.blit(strip, (675, rel_y+782))
            gamedisplay.blit(strip, (675, rel_y + 816))
            '''


        y2+=obstacle_speed


        #background()
        obs_starty-= (obstacle_speed/4)
        obstacle(obs_startx, obs_starty,obs)
        obs_starty+= obstacle_speed
        car(x,y)
        score_system(passed, score)
        if x > 675-car_width or x < 70+car_width:
            crash()
        if x > display_width-(car_width+110) or x < 110:
            crash()
        if obs_starty > display_height:
            obs_starty = 0-obs_height
            obs_startx = random.randrange(170, (display_width-170))
            obs=random.randrange(0, 7)
            passed=passed+1
            score=passed*10
            if int(passed)%10==0:
                level=level+1
                obstacle_speed+=5
                largetext = pygame.font.Font("freesansbold.ttf", 80)
                textsurf, textrect = text_object("LEVEL "+str(level), largetext)
                textrect.center = ((display_width / 2), (display_height / 2))
                gamedisplay.blit(textsurf, textrect)
                pygame.display.update()
                time.sleep(0)

        if y < obs_starty+obs_height:
            if x > obs_startx and  x < obs_startx + obs_width or x+car_width > obs_startx and x+car_width < obs_startx + obs_width:
                crash()
        button("PAUSE",650,0,150,50,blue,bright_blue,"pause")
        pygame.display.update()
        clock.tick(60)
intro_loop()
game_loop()
pygame.quit()
quit()







