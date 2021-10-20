/*
Program Description:
Write a program in C++ to create a class named TIME that stores two time values in hours (float) and minutes (integer). Perform the following operations by using a function add():- 

Add T1+T2 where , T1 and T2 are time objects.

Add T1+x where T1 is a TIME object and x is any integer. 

Return time objects from the member function to main() and display.

Author: Nilay Gupta

Algorithm: 
    Step 1: Start
    Step 2: Declare the necessary header files
    Step 3: Create the class TIME
    Step 4: Declare the function to take user input
    Step 5: Declare the function to display output
    Step 6: Declare the function ADD using the public access specifier
            which adds the integer to the minute of the time variable
            inputted by the user and returns the time object
    Step 7: Declare the function ADD using the public access specifier
            which adds the two time variables inputted by the user and 
	        returns the time object
    Step 8: Create a main function to create an object of the class, input
            the required variables and objects and then call the respective 
            functions as required
    Step 9: End
*/

#include<iostream>          //incllusion of header file
using namespace std;

class TIME          //class TIME which contains the overloaded function ADD
{

    public:         //public access specifier
        
        //public data members
        int min;
        float hr;
        
        //public member functions
        void ENTER_TIME()               //takes input from user
        {
            cout<<"\nEnter hours for the time object: ";
            cin>>hr;
            cout<<"\nEnter minutes for the time object: ";
            cin>>min;
        }
        
        void DISPLAY_TIME()             //displays output
        {
            cout<<"\nThe time is: "<<hr<<" hours "<<min<<" minutes"<<endl;
        }
};

TIME ADD(TIME T1,int x)         //ADD function adding a time object and an integer
{
    if(x >= 60)
    {
        TIME s;
        s.hr = (x / 60) + T1.hr;
        s.min = (x % 60) + T1.min;
        if(s.min >= 60)
        {
            s.hr += (s.min / 60);
            s.min = (s.min % 60);
        }
        return s;
    }
    else if(x < 60)
    {
        TIME s;
        s.hr = T1.hr;
        s.min = x + T1.min;
        return s;
    }

}

TIME ADD(TIME T1,TIME T2)       //ADD function adding two time objects
{
    TIME t;
    t.hr = T1.hr + T2.hr;
    t.min = T1.min + T2.min;
    if(t.min >= 60)
    {
        t.hr += (t.min / 60);
        t.min = (t.min % 60);
    }
    return t;
}
        
//main function which invokes all the necessary objects and functions
int main()
{
    TIME T1,T2,T3,T4; 
    int x;
    cout<<"\nEnter time for first time object:";
    T1.ENTER_TIME();
    cout<<"\nEnter an integer (in minutes): ";
    cin>>x;
    cout<<"\nEnter time for second time object:";
    T2.ENTER_TIME();
    T3 = ADD(T1,x);
    cout<<"\nSum of an integer and a time object:";
    T3.DISPLAY_TIME();
    T4 = ADD(T1,T2);
    cout<<"\nSum of the two time objects: ";
    T4.DISPLAY_TIME();
}