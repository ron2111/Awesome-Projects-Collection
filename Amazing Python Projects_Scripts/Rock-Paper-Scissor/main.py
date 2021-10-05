import random
def play():
    choice=input('Enter a choice..."r" for Rock,"p" for Paper,"s" for Scissors')
    user_choice=choice.lower()
    computer_choice=random.choice(['r','p','s'])
    winner=None
    if(user_choice==computer_choice):
        print('You are tied with the computer...')
    elif(user_choice=='r' and computer_choice=='p'):
        winner='So, the user chooses {} and the computer chooses {}, SO, Computer wins...'.format(user_choice, computer_choice)
    elif(user_choice=='r' and computer_choice=='s'):
        winner='So, the user chooses {} and the computer chooses {}, SO, User wins'.format(user_choice, computer_choice)
    elif(user_choice=='p' and computer_choice=='r'):
        winner='So, the user chooses {} and the computer chooses {}, SO, User wins'.format(user_choice, computer_choice)
    elif(user_choice=='p' and computer_choice=='s'):
        winner='So, the user chooses {} and the computer chooses {}, SO, Computer wins'.format(user_choice, computer_choice)
    elif(user_choice=='s' and computer_choice=='p'):
        winner='So, the user chooses {} and the computer chooses {}, SO, User wins'.format(user_choice, computer_choice)
    elif(user_choice=='s' and computer_choice=='r'):
        winner='So, the user chooses {} and the computer chooses {}, SO, Computer wins'.format(user_choice, computer_choice)
    else:
        print('Something is wrong')
    return winner  
def main():
    print(play())
if __name__=='__main__':
    main()