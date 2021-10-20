/*
Program Description: A CPP program to overload a function POWER in different ways to raise a number m to the power of n
Author: Nilay Gupta

Algorithm: 
    Step 1: Start
    Step 2: Declare the necessary header files
    Step 3: Create the class C_POWER
    Step 4: Declare the function POWER using the public access specifier
           which raises a double value of m to the power n and if the
           value of n not specified, it takes a default value of 2 and then
           print the answer
    Step 5: Declare another function power using the public access specifier
           which raises an integer value of m to the power n and if the
           value of n not specified, it takes a default value of 2 and then
           print the answer
    Step 6: Create a main function to create an object of the class, input
           the required variables and objects and then call the respective 
           functions as required
    Step 7: End
*/

#include<iostream>
#include<math.h>
using namespace std;

class C_POWER       //class C_power which contains the overloaded function power
{
    public:
            void power(double m, int n=2)       //power function having data type of m as double
            {
                double res=0;
                res=pow(m,n);
                cout<<"\nResult when the data type of base number is double = "<<res<<"\n";
            }
           
            void power(int m, int n=2)      //power function having the data type of m is integer
            {
                int res=0;
                res=pow(m,n);
                cout<<"\nResult when the data type of base number is integer = "<<res<<"\n";
            }
};

int main()      //main function which invokes all the necessary objects and functions
{
    //variable declaration
    double m1;
    int n,m2;
   
    C_POWER obj;        //object declaration
   
    //inputting the values by the user as required
    cout<<"\nEnter a double value: ";
    cin>>m1;
    cout<<"\nEnter an integer value: ";
    cin>>m2;
    cout<<"\nEnter the integer power: ";
    cin>>n;
   
    //calling the respective function objects as required
    obj.power(m1,n);
    cout<<"\nUsing default power of 2: ";
    obj.power(m1);
    obj.power(m2,n);
    cout<<"\nUsing default power of 2: ";
    obj.power(m2);
   
    return 0;
}