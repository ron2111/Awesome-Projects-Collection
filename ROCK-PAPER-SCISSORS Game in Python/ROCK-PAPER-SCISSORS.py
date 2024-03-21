# Link for the game: http://www.codeskulptor.org/#user47_4ZJ4uZwfaL_1.py

"""
@ Clever Programmer
Rock paper scissors
"""
import random
import simplegui


# Global variables that all functions know about.
# DO NOT EDIT THESE GLOBAL VARIABLES
# OR YOUR GAME WILL BREAK.
COMPUTER_SCORE = 0
HUMAN_SCORE = 0
human_choice = ""
computer_choice = ""


def choice_to_number(choice):
    return {'rock':0,'paper':1,'scissors':2}[choice]
    """Convert choice to number."""
    # If choice is 'rock', give me 0
    # If choice is 'paper', give me 1
    # If choice is 'scissors', give me 2


def number_to_choice(number):
    return {0:'rock',1:'paper',2:'scissors'}[number]
    """Convert number to choice."""
    # If number is 0, give me 'rock'
    # If number is 1, give me 'paper'
    # If number is 2, give me 'scissors'


def random_computer_choice():
    return random.choice(['rock','paper','scissors'])
    

    """Choose randomly for computer."""
    
    # lookup random.choice()

def choice_result(human_choice, computer_choice):
    """Return the result of who wins."""
    
    # DO NOT REMOVE THESE GLOBAL VARIABLE LINES.
    global COMPUTER_SCORE
    global HUMAN_SCORE
    human_choice_number=choice_to_number(human_choice)
    computer_choice_number=choice_to_number(computer_choice)
    if (human_choice_number-computer_choice_number)%3==1 :
        COMPUTER_SCORE += 1
        print ("OOPS COMPUTER WON")
        
    elif (human_choice_number==computer_choice_number):
        print("TIE")
        
    else: 
        HUMAN_SCORE += 1
        print("HURRAY!! YOU WON")
    # based on the given human_choice and computer_choice
    # determine who won and increment their score by 1.
    # if tie, then don't increment anyone's score.
    
    # example code
    # if human_choice == 'rock' and computer_choice == 'paper':
    #    COMPUTER_SCORE = COMPUTER_SCORE + 1

    
# DO NOT REMOVE THESE TEST FUNCTIONS.
# They will test your code.
def test_choice_to_number():
    assert choice_to_number('rock') == 0
    assert choice_to_number('paper') == 1
    assert choice_to_number('scissors') == 2
    
def test_number_to_choice():
    assert number_to_choice(0) == 'rock'
    assert number_to_choice(1) == 'paper'
    assert number_to_choice(2) == 'scissors'
    
def test_all():
    test_choice_to_number()
    test_number_to_choice()

# Uncomment to test your functions.
test_all()


# Handler for mouse click on rock button.
# This code is for the GUI part of the game.
def rock():
    global human_choice, computer_choice
    global HUMAN_SCORE, COMPUTER_SCORE
    
    human_choice = 'rock'
    computer_choice = random_computer_choice()
    choice_result(computer_choice, human_choice)

def paper():
    global human_choice, computer_choice
    global HUMAN_SCORE, COMPUTER_SCORE
    
    human_choice = 'paper'
    computer_choice = random_computer_choice()
    choice_result(computer_choice, human_choice)
    
# Handler for mouse click on paper button.
def scissors():
    global human_choice, computer_choice
    global HUMAN_SCORE, COMPUTER_SCORE
    
    human_choice = 'scissors'
    computer_choice = random_computer_choice()
    choice_result(computer_choice, human_choice)

# Handler to draw on canvas
def draw(canvas):
    
    try:
        # Draw choices
        canvas.draw_text("You: " + human_choice, [10,40], 48, "Blue")
        canvas.draw_text("Comp: " + computer_choice, [10,80], 48, "Violet")
        canvas.draw_text("Play Rock-Paper-Scissors",[35,250],40,"Yellow")
        
        # Draw scores
        canvas.draw_text("Human Score: " + str(HUMAN_SCORE), [10,150], 30, "Green")
        canvas.draw_text("Comp Score: " + str(COMPUTER_SCORE), [10,190], 30, "Red")
        
    except TypeError:
        pass
    

# Create a frame and assign callbacks to event handlers
def play_rps():
    frame = simplegui.create_frame("Game", 500, 300)
    frame.add_button("Rock", rock)
    frame.add_button("Paper", paper)
    frame.add_button("Scissors", scissors)
    frame.set_draw_handler(draw)

    # Start the frame animation
    frame.start()
 
play_rps()

"""   
[0, 1, 2]
[r, p, s]

rock vs scissors
(rock - scissors) % 3 == 1
(0 - 2) % 3 == 1
(-2) % 3 == 1
1 == 1
rock wins

paper vs scissors
(paper - paper) % 3 == 1
(1 - 2) % 3 == 1
2 == 1
scissor wins

paper vs rocks
(paper - rocks) % 3 == 1
(1 - 0) % 3 == 1
1 % 3 == 1
1 == 1
paper wins
"""