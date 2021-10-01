import turtle 
a=turtle.Turtle()
screen=turtle.Screen()
screen.bgcolor('black') 
col=('white','red','orange', 'yellow', 'green', 'blue','cyan')
a.speed(0)


for i in range (200): 
 a.forward(i*4) 
 a.right(91) 
 a.color(col[i%7]) 
for b in range (3): 
 a.forward(i*4) 
 a.right(91) 
for c in range (2): 
 a.forward(i*4) 
 a.right(91)
