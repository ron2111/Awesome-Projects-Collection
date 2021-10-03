#include<iostream>
#include <iomanip>
#include<math.h>
#include<stdlib.h>
#include<time.h>
#include <conio.h> //To read the direction keys
#include<windows.h>
using namespace std;  
//srand( (unsigned)time( NULL ) ); // Random number seed   It can't be used here 
int pane[4][4]; //The board
int N=1; //Two to the n
void showpane() // According to The board
{
 cout<<setw(46)<<"X2048 by Reason"<<endl;
 cout<<setw(50)<<" |-----------------------|"<<endl;
 for(int i=0;i<=3;i++) 
 {
  cout<<setw(24)<<"";
  for(int j=0;j<=3;j++)
  {
   //SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),FOREGROUND_RED); 
   if(pane[i][j]==0)
    cout<<setw(2)<<"|"<<setw(4)<<" ";
   else
    cout<<setw(2)<<"|"<<setw(4)<<pane[i][j];

   if(j==3)
    {
     cout<<setw(2)<<"|"<<endl;
     cout<<setw(50)<<" |-----------------------|"<<endl;
    }
  }
 }
}
void newgame() //Start the game
{
 N=1;
 for(int i=0;i<=3;i++) // Initialize the The board
  for(int j=0;j<=3;j++)
   pane[i][j]=0;
 srand( (unsigned)time( NULL ) );
 int m=rand()%4;
 int n=rand()%4;
 int p=rand()%4;
 int q=rand()%4;
 pane[m][n]=pane[p][q]=2;
 showpane();
}
int if2n(int x) // judge x Whether it is Two to the n
{
 int flag=0;
 for(int n=1;n<=11;n++)
 {
  if(x==pow(2,n))
  {
   flag=1;
   if(n>N)
    N=n;
   return flag;
  }
 }
 return flag;
}
int upmove() //Move up
{
 int flag=0;
 for(int j=0;j<=3;j++)
  for(int i=0;i<3;i++)
  {
   if(if2n(pane[i][j]+pane[i+1][j])==1)
   {
    pane[i][j]=pane[i][j]+pane[i+1][j];
    pane[i+1][j]=0;
    flag=1;
   }
  }
 return flag;
}
int downmove() //Move down
{
 int flag=0;
 for(int j=0;j<=3;j++)
  for(int i=3;i>0;i--)
  {
   if(if2n(pane[i][j]+pane[i-1][j])==1)
   {
    pane[i][j]=pane[i][j]+pane[i-1][j];
    pane[i-1][j]=0;
    flag=1;
   }
  }
 return flag;
}
int leftmove() //Shift to the left
{
 int flag=0;
 for(int i=0;i<=3;i++)
  for(int j=0;j<3;j++)
  {
   if(if2n(pane[i][j]+pane[i][j+1])==1)
   {
    pane[i][j]=pane[i][j]+pane[i][j+1];
    pane[i][j+1]=0;
    flag=1;
   }
  }
 return flag;
}
int rightmove() //Moves to the right
{
 int flag=0;
 for(int i=0;i<=3;i++)
  for(int j=3;j>0;j--)
  {
   if(if2n(pane[i][j]+pane[i][j-1])==1)
   {
    pane[i][j]=pane[i][j]+pane[i][j-1];
    pane[i][j-1]=0;
    flag=1;
   }
  }
 return flag;
}
int testup() // whether Move up test 
{
 int flag=0;
 for(int j=0;j<=3;j++)
  for(int i=0;i<3;i++)
  {
   if((if2n(pane[i][j]+pane[i+1][j])==1)&&pane[i+1][j])
   {
    flag=1;
   }
  }
 return flag;
}
int testdown() // To test whether Move down
{
 int flag=0;
 for(int j=0;j<=3;j++)
  for(int i=3;i>0;i--)
  {
   if((if2n(pane[i][j]+pane[i-1][j])==1)&&pane[i-1][j])
   {
    flag=1;
   }
  }
 return flag;
}
int testleft() // To test whether Shift to the left
{
 int flag=0;
 for(int i=0;i<=3;i++)
  for(int j=0;j<3;j++)
  {
   if((if2n(pane[i][j]+pane[i][j+1])==1)&&pane[i][j+1])
   {
    flag=1;
   }
  }
 return flag;
}
int testright() // To test whether Moves to the right
{
 int flag=0;
 for(int i=0;i<=3;i++)
  for(int j=3;j>0;j--)
  {
   if((if2n(pane[i][j]+pane[i][j-1])==1)&&pane[i][j-1])
   {
    flag=1;
   }
  }
 return flag;
}
int panemax() //The board Maximum number 
{
 int max=pane[0][0];
 for(int i=0;i<=3;i++)
  for(int j=0;j<=3;j++)
   if(pane[i][j]>max)
    max=pane[i][j];
 return max;
}
int ifwin() //Judge victory
{
 int flag=0;
 if(panemax()==2048)
 {
  cout<<setw(45)<<"You Win!"<<endl;
  flag=1;
 }
 return flag;
}
int ifGameOver()  //Determine if the game is over
{
 int flag=0;
 if(testup()+ testdown() + testleft() + testright() == 0)
 {
  cout<<setw(43)<<"Game Over!"<<endl;
  flag=1;
 }
 return flag;
}
void addnewnumberup() //Move up Add a new number after 
{
 srand( (unsigned)time( NULL ) );
 int n;
 if(N==1)
  n=1;
 else
  n=(rand()%(N)+1); 
 int newnumber=pow(2,n);
 for(int i=3;i>=0;i--)
  for(int j=0;j<=3;j++)
   if(pane[i][j]==0)
   {
    pane[i][j]=newnumber;
    return;
   }
}
void addnewnumberdown() //Move down Add a new number after 
{
 srand( (unsigned)time( NULL ) );
 int n;
 if(N==1)
  n=1;
 else
  n=(rand()%(N)+1);
 int newnumber=pow(2,n);
 for(int i=0;i<=3;i++)
  for(int j=0;j<=3;j++)
   if(pane[i][j]==0)
   {
    pane[i][j]=newnumber;
    return;
   }
}
void addnewnumberleft() //Shift to the left Add a new number after 
{
 srand( (unsigned)time( NULL ) );
 int n;
 if(N==1)
  n=1;
 else
  n=(rand()%(N)+1); 
 int newnumber=pow(2,n);
 for(int j=3;j>=0;j--)
  for(int i=0;i<=3;i++)
   if(pane[i][j]==0)
   {
    pane[i][j]=newnumber;
    return;
   }
}
void addnewnumberright() //Moves to the right Add a new number after 
{
 srand( (unsigned)time( NULL ) );
 int n;
 if(N==1)
  n=1;
 else
  n=(rand()%(N)+1); 
 int newnumber=pow(2,n);
 for(int j=0;j<=3;j++)
  for(int i=0;i<=3;i++)
   if(pane[i][j]==0)
   {
    pane[i][j]=newnumber;
    return;
   }
}
int GetDirection() //Read the directions
{
    int ret = 0;
    do 
    {
        int ch = _getch();
        if(isascii(ch))
            continue;
        ch = _getch();
        switch(ch)
        {
        case 72:   
            ret = 2; // top
            break;
        case 75:   
            ret = 1; // left 
            break;
        case 77:   
            ret = 3; // right
            break;
        case 80:   
            ret = 4; // down
            break;
        default:   
            break;
        }
    } while (ret == 0);
    return ret;
}
int main() //The main function
{
 system("color f9");
 int makesure=1;
 while(makesure)
 { 
  system("cls");
  newgame();
  while(ifwin()+ifGameOver()==0)
  {
   int c=GetDirection();
   switch(c)
   {
   case 2:
    if(testup()==1)
    { upmove();
     addnewnumberup();
     system("cls");
     showpane();
    }
    break;
   case 4:
    if(testdown()==1)
    {
     downmove();
     addnewnumberdown();
     system("cls");
     showpane();
    }
    break;
   case 1:
    if(testleft()==1)
    {
     leftmove();
     addnewnumberleft();
     system("cls");
     showpane();
    }
    break;
   case 3:
    if(testright()==1)
    {
     rightmove();
     addnewnumberright();
     system("cls");
     showpane();
    }
    break;
   default:   
    break;
   }
  }
  cout<<setw(43)<<" Your final score is: "<<panemax()<<endl;
  cout<<setw(60)<<" If want to Start the game Please enter the 1 , please enter to end 0 . "<<endl;
  cin>>makesure;
  while(makesure!=1&&makesure!=0)
  {
   cout<<" Incorrect input, please re-enter !"<<endl;
   cin>>makesure;
  }
 }
  cout<<" Good bye! "<<endl;
  system("pause");
  return 0;
}
