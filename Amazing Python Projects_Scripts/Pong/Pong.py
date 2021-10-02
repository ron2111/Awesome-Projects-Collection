import turtle
import time
import winsound

wn=turtle.Screen()
wn.title("Pong by @satvikDesktop")
wn.colormode(255)
wn.bgcolor( 48, 56, 56) 
wn.setup(width=800,height=600)
wn.tracer(0)
#Score
score_a=0
score_b=0
#Paddle A
paddle_a = turtle.Turtle()
paddle_a.speed(0)
paddle_a.shape("square") 
paddle_a.color(25, 172, 81)
paddle_a.shapesize(stretch_wid=5, stretch_len=1)
paddle_a.penup()
paddle_a.goto(-350,0)
#Paddle B
paddle_b = turtle.Turtle()
paddle_b.speed(0)
paddle_b.shape("square")
paddle_b.color(191, 51, 68 )
paddle_b.shapesize(stretch_wid=5, stretch_len=1)
paddle_b.penup()
paddle_b.goto(350,0)
#Ball
ball = turtle.Turtle()
ball.speed(0)
ball.shape("circle")
ball.color( 255, 255, 255) 
ball.penup()
ball.goto(0,0)
# change for speed
ball.dx=5  
ball.dy=-5
#Pen
pen=turtle.Turtle()
pen.speed(0)
pen.penup()
pen.hideturtle()
pen.goto(0,260)
pen.color(244, 244, 244)
pen.write("Player 1 - 0                       Player 2 - 0", align = "center" , font = ("Consolas",16))


# For paddle a
def paddle_a_up():
    y=paddle_a.ycor()
    y+=20
    paddle_a.sety(y)
    
def paddle_a_down():
    y=paddle_a.ycor()
    y-=20
    paddle_a.sety(y)
#For paddle b
def paddle_b_up():
    y=paddle_b.ycor()
    y+=20
    paddle_b.sety(y)   
def paddle_b_down():
    y=paddle_b.ycor()
    y-=20
    paddle_b.sety(y)
# Keyboard Binding
wn.listen()
wn.onkeypress(paddle_a_up,"w" )
wn.onkeypress(paddle_a_down,"s")
wn.onkeypress(paddle_b_up,"Up" )
wn.onkeypress(paddle_b_down,"Down")
# main game loop
while True:
    time.sleep(1 / 50)  # for time interval between frame update for consistent ball speed 
    wn.update()

    # Move the ball
    ball.setx(ball.xcor()+ball.dx)
    ball.sety(ball.ycor()+ball.dy)
    # Border checking
    if ball.ycor() > 290:
        ball.sety(290)
        ball.dy*=-1
        winsound.PlaySound("Pong/bounce.wav",winsound.SND_ASYNC)
    if ball.ycor() < -290:
        ball.sety(-290)
        ball.dy*=-1
        winsound.PlaySound("Pong/bounce.wav",winsound.SND_ASYNC)
    if ball.xcor() > 390:
        ball.goto(0,0)
        ball.dx*=-1
        score_a+=1
        pen.clear()
        pen.write("Player 1 - {}                       Player 2 - {}".format(score_a,score_b), align = "center" , font = ("Consolas",16))
    if ball.xcor() < -390:
        ball.goto(0,0)
        ball.dx*=-1
        score_b+=1
        pen.clear()
        pen.write("Player 1 - {}                       Player 2 - {}".format(score_a,score_b), align = "center" , font = ("Consolas",16))
    # Collision 
    if ball.xcor() >340 and ball.xcor()<350 and (ball.ycor() < paddle_b.ycor() + 40 and ball.ycor()>paddle_b.ycor()-40):
        ball.setx(340)
        ball.dx *= -1
        winsound.PlaySound("Pong/bounce.wav",winsound.SND_ASYNC)
    if ball.xcor() <-340 and ball.xcor()>-350 and (ball.ycor() < paddle_a.ycor() + 40 and ball.ycor()>paddle_a.ycor()-40):
        ball.setx(-340)
        ball.dx *= -1 
        winsound.PlaySound("Pong/bounce.wav",winsound.SND_ASYNC)
