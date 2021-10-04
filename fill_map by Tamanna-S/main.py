import turtle
import pandas 


screen = turtle.Screen()
screen.setup(width=800, height=600)
screen.bgcolor("black")
screen.title("fill the map of India...")
image = "map2.gif"
screen.addshape(image)
turtle.shape(image)

data = pandas.read_csv("28_states.csv")
all_states = data.state.to_list()
guessed_states =[]


while len(guessed_states) < 50:
    
    user = screen.textinput(title="guess the states of India..", prompt="(if you entered a wrong state nothing happens you can enter exit or click cancel for exit and please give space between two words)\n\n            guess any state's name here..👇            ").title()
    if user == "Exit":
        missing_states = [state for state in all_states if state not in guessed_states ]
        new_data = pandas.DataFrame(missing_states)
        new_data.to_csv("states_to_learn.csv")
        break

        

    if user in all_states:
        guessed_states.append(user)
        tur = turtle.Turtle()
        tur.hideturtle()
        tur.penup()
        state_data = data[data.state == user]
        tur.goto( int(state_data.x), int(state_data.y) )
        tur.write(user) 
     








screen.mainloop()