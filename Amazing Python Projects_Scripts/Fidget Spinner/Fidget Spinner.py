# importing all the features of turtle library
from turtle import *
state = {'turn':0} # Turn is a single point, and the initial state of spinner is null (stable)

#spinner function
def spinner():
   clear()

   # Angle of the spinner determines rotation
   angle= state['turn']/10
   # left for ACW and right for CW movement
   left(angle)
   # moves the turtle forward by specfied distance  
   forward(100)
   # draws a dot with diameter 120 and color red
   dot(120,'red')
   # moves the turtle back by specified distance
   back(100)

   #Second dot
   left(120)
   forward(100)
   dot(120,'blue')
   back(100)

   #Third dot
   left(120)
   forward(100)
   dot(120,'green')
   back(100)
   left(120)

   update()

# Animating the spinner
def animate():
    if state['turn']>0:
        state['turn'] -=1
    spinner()

    # This will call the animate function after 20 milli seconds
    ontimer(animate,20)

# Flicking the spinner
def flick():
    # Acceleration of the spinner
    state['turn']+=50

# To bring back the spinner to initial state
tracer(False)
# Wing of spinner
width(10)
color("orange")

# keyboard ket to rotate
onkey(flick,'space')

# When space is clicked more than once, it will increase its speed by 50
listen()
animate()
done()
