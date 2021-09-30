import random
n_l=int(input("no. of letters you want:- "))
n_s=int(input("no. of symbols you want:- "))
n_n=int(input("no. of numbers you want:- "))
letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
numbers = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
symbols = ['!', '#', '$', '%', '&', '(', ')', '*', '+']
password=[]
for i in range(0,n_l+n_s+n_n):
    if i<=n_l:
        password.append(letters[random.randint(0,51)])
    elif i<=n_l+n_s:
        password.append(symbols[random.randint(0,8)])
    else:
        password.append(numbers[random.randint(0,9)])
random.shuffle(password)
passw=""
for i in range(0,n_l+n_s+n_n):
     passw=passw+password[i]
print(passw)