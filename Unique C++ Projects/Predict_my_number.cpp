#include <iostream>

using namespace std;

//It wil print the sets
void print(int array[4][4], string set) {
    cout<<"**********************************************\n";
    cout << set << "set:\n";
    for(int i = 0; i < 4; i++) {
        for(int j = 0; j < 4; j++) {
            cout << array[i][j] << " ";
        }
        cout << endl;
    }
    cout<<"**********************************************\n";
}

void predict_my_number() {
    char one, two, three, four, five;
    int answer = 0;

    //Creating Sets based on the set bits, EG: in first sets all the numbers are present whose 1st bit is set and so on...
    //till 5th bit as 2^5 = 32
    int firstSet[4][4] = {{1, 3, 5, 7}, {9, 11, 13, 15}, {17, 19, 21, 23}, {25, 27, 29, 31}};
    int secondSet[4][4] = {{2, 3, 6, 7}, {10, 11, 14, 15}, {18, 19, 22, 23}, {26, 27, 30, 31}};
    int thirdSet[4][4] = {{4, 5, 6, 7}, {12, 13, 14, 15}, {20, 21, 22, 23}, {28, 29, 30, 31}};
    int fourthSet[4][4] = {{8, 9, 10, 11}, {12, 13, 14, 15}, {24, 25, 26, 27}, {28, 29, 30, 31}};
    int fifthSet[4][4] = {{16, 17, 18, 19}, {20, 21, 22, 23}, {24, 25, 26, 27}, {28, 29, 30, 31}};


    //If number is present press Y or y else press N or n.

    //checking 1st set
    print(firstSet, "First");
    cin >> one;
    if(one == 'y' || one == 'Y')
        answer += firstSet[0][0];

    //checking 2nd set
    print(secondSet, "Second");
    cin >> two;
    if(two == 'y' || two == 'Y')
        answer += secondSet[0][0];

    //checking 3rd set
    print(thirdSet, "Third");
    cin >> three;
    if(three == 'y' || three == 'Y')
        answer += thirdSet[0][0];
    
    //checking 4th set
    print(fourthSet, "Fourth");
    cin >> four;
    if(four == 'y' || four == 'Y')
        answer += fourthSet[0][0];
    
    //checking 5th set
    print(fifthSet, "Fifth");
    cin >> five;
    if(five == 'y' || five == 'Y')
        answer += fifthSet[0][0];

    //printing result
    cout << "**********************************************\n";
    cout << "Your choosen number is:\n";
    cout << answer << endl;
    cout << "**********************************************\n";
}

int main() {
    cout << "**********************************************\n";

    //instructions for user...
    cout << "Think of a number from 1 to 31 and remember it.\n";
    cout << "Now i will show you some numbers, press y/n \n";
    cout << "if the number is present or not in the given set of numbers respectively.\n";

    cout << "**********************************************\n";

    //calling function
    predict_my_number();

    return 0;
}