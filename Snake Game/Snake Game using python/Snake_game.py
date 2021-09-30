import turtle
import time
import random
from turtle import *

bg_color=["#1C2833" , "#1B1212"]
head_color=["#FFFFFF","#FFF0F5"]
num=random.choice([0,1])


#first screen to print "game begins now"
screen0=turtle.Screen()
screen0.title("Snake Game")
screen0.bgcolor("#000000")
screen0.bgpic("snake.png")
pen=turtle.Turtle()
pen.goto(-185,0)
pen.speed(0)
pen.color("white")
pen.shape("turtle")
pen.write("Game starts now!")
pen.speed(1.35)
pen.goto(185,0)
pen.clear()
pen.hideturtle()
screen0.clear()



#second screen to show the game
# Creating a window screen 

screen = turtle.Screen() 
screen.title("Snake Game") 
screen.bgcolor(bg_color[num]) 
screen.tracer(0) 

names = []
scores = []
bodies = []
def GameLoop():
	screen = turtle.Screen()
	screen.title("Snake Game")
	screen.bgcolor(bg_color[num])
	screen.tracer(0)

	#head of the snake
	score = 0
	Flag = True
	name = turtle.textinput("Player" , "Enter Name")
	names.append(name)

	head = turtle.Turtle()
	head.shape("square")
	head.color("green")
	head.goto(0,0)

	pens = turtle.Turtle()
	pens.color("White")
	pens.penup()
	pens.setpos(-150,230)
	pens.write("Score {0} \t Player  {1}".format(score , name) , align="center" , font = ("Candara" , 24 , "bold"))
	pens.speed(0)
	pens.hideturtle()

      #Food creation
	Food = turtle.Turtle()
	Food.color("yellow")
	Food.shape("circle")
	Food.penup()
	Food.setpos(random.randint(-270,270) , random.randint(-240,240))
	Food.speed(0)

	def R1():
		head.right(90)
	def R2():
		head.right(90)

	screen.onkeypress(R1 , "Up")
	screen.onkeypress(R2 , "Down")
	
	
	#This part/method of code is having issues
	def move():
		if head.direction == "up":
			y = head.ycor()
			head.sety(y - 20)
		if head.direction == "down":
			y = head.ycor()
			head.sety(y + 20)
		if head.direction == "left":
			x = head.xcor()
			head.setx(x-20)
		if head.direction == "right":
			x = head.xcor()
			head.setx(x+20)
	screen.listen()
	i = 0.02

	#Border collision
	while (Flag==True):
		screen.update()

		head.penup()
		head.forward(i)

		if head.xcor()>300 or head.xcor()<-300 or head.ycor()>260 or head.ycor()<-260:
			screen.bgcolor("red")
			time.sleep(1)
			head.goto(0,0)
			head.direction = "Stop"
			scores.append(score)
			Flag = False



		#Code for food and Head Collision.

		if head.distance(Food) < 20:
			Food.goto(random.randint(-270,270) , random.randint(-240,240))
			score+=5
			pens.clear()
			pens.write("Score {0} \t Player  {1}".format(score , name) , align="center" , font = ("Candara" , 24 , "bold"))
			#To increase the speed after every food eaten
			i+=0.02


			#Adding body
			new_body = turtle.Turtle()
			new_body.speed(0)
			new_body.shape("square")
			new_body.color("orange")
			new_body.penup()
			bodies.append(new_body)

		#increasing size
		if len(bodies)>0:
			x = head.xcor() 
			y = head.ycor() 
			bodies[0].goto(x, y)
		move()



GameLoop()

high_score = max(scores)
for i in range(len(scores)):
	if scores[i]==high_score:
		winner = names[i]

screen.clear()
