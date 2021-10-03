import pygame
import random
from pygame.constants import WINDOWHITTEST
pygame.init()
#colors
white=(255,255,255)#rgb values-->(x,y,z)
red=(255,0,0)
black=(0,0,0)
screen_width=1200
screen_height=600
pygame.display.set_caption('snake game')
#creating window
gamewindow=pygame.display.set_mode((screen_width,screen_height))
pygame.display.update()
#game specific variables
font=pygame.font.SysFont(None,55)



def text_screen(text,color, x,y):
    screen_text=font.render(text,True,color)
    gamewindow.blit(screen_text,[x,y])
def plot_snake(gamewindow,color,snk_list,snake_size):
    for x,y in snk_list:
        pygame.draw.rect(gamewindow,color,[x,y,snake_size,snake_size])

#all these things from pygame documentation
#game loop
clock=pygame.time.Clock()
#to apply changes you have to update everytime
def gameloop():
    exit_game=False
    game_over=False
    snake_x=45
    snake_y=55
    snake_size=10
    velocity_x=0
    velocity_y=0
    food_x=random.randint(0,screen_width/2)
    food_y=random.randint(0,screen_height/2)
    score=0
    init_velocity=4
    fps=60#frames per second
    snk_list=[]
    snk_length=1
    with open('highscore.txt','r') as f:
        hiscore=f.read()
    while not exit_game:
        if game_over:
            with open('highscore.txt','w') as f:
                f.write(str(hiscore))
            gamewindow.fill(white)
            text_screen('Game Over! Press Enter To continue',red, 200,200)

            for event in pygame.event.get():
                if event.type==pygame.QUIT:
                    exit_game=True
                if event.type==pygame.KEYDOWN:
                    if event.key==pygame.K_RETURN:
                        gameloop()
        else:

            for event in pygame.event.get():
                if event.type==pygame.QUIT:
                    exit_game=True
                if event.type==pygame.KEYDOWN:
                    if event.key==pygame.K_RIGHT:
                        velocity_x=init_velocity
                        velocity_y=0
                    if event.key==pygame.K_LEFT:
                        velocity_x=-init_velocity
                        velocity_y=0
                    if event.key==pygame.K_UP:
                        velocity_y=-init_velocity
                        velocity_x=0
                    if event.key==pygame.K_DOWN:
                        velocity_y=init_velocity
                        velocity_x=0
                    #we have to press arrow everytime to move it will not move if it is kept pressed
            snake_x=snake_x+velocity_x
            snake_y=snake_y+velocity_y
            if abs(snake_x-food_x)<10 and abs(snake_y-food_y)<10:
                score+=10
                snk_length+=5
                food_x=random.randint(0,screen_width/2)
                food_y=random.randint(0,screen_height/2)
                if score>int(hiscore):
                    hiscore=score
            gamewindow.fill(white)
            text_screen("Score: "+str(score)+" Hiscore: "+str(hiscore),red,5,5)
            pygame.draw.rect(gamewindow,red,[food_x,food_y,snake_size,snake_size])
            head=[]
            head.append(snake_x)
            head.append(snake_y)
            snk_list.append(head)
            if len(snk_list)>snk_length:
                del snk_list[0]
            if head in snk_list[:-1]:
                game_over=True
            #pygame.draw.rect(gamewindow,black,[snake_x,snake_y,snake_size,snake_size])arguments contain(window,color,[x_coordinate,y_coordinate,length,width])
            if snake_x<0 or snake_x>screen_width or snake_y<0 or snake_y>screen_height:
                game_over=True
                print('Game Over')
            plot_snake(gamewindow,black,snk_list,snake_size)
        pygame.display.update()
        clock.tick(fps)
            #in one second it will have 30 frames


    pygame.quit()
    quit()

gameloop()
