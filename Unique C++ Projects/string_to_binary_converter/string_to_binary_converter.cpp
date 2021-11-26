#include<iostream>
#include<cstring>
#include<cmath>
using namespace std;

void binary(int a)
{
    int two[8];

    for(int i=7; i>=0; i--)
    {
        two[i] = a / int(pow(2,i));
        a = a % int(pow(2,i));
    }

    for(int i=7; i>=0 ; i--)
    {
        cout<<two[i];
    }
}

int main(){
    string s;
    cout<<"Enter string :- "<<endl;
    cin>>s;

    for(int i = 0; i< s.length(); i++)
    {
        binary(int(s[i]));
    }
    return 0;
}
