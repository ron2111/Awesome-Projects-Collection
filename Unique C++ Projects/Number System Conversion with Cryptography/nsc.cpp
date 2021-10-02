#include <iostream>
#include <iomanip>
#include <windows.h>
#include <conio.h>
#include <math.h>
#include <string>
#include <stdlib.h>
using namespace std;
void clrscr()
{
    system("cls");

}
void gotoxy(int x, int y)
{
    COORD coord;
    coord.X = x;
    coord.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}
int ansbox()
{
    int rows,cols;
    for(rows=15;rows<=19;rows++)
    {
        gotoxy(50,rows);
        cout<<"*";
    }
   for(cols=50;cols<=69;cols++)
    {
        gotoxy(cols,15);
        cout<<"*";
    }
    for(rows=15;rows<=19;rows++)
    {
        gotoxy(69,rows);
        cout<<"*";
    }
     for(cols=50;cols<=69;cols++)
    {
        gotoxy(cols,19);
        cout<<"*";
    }

}
int design()
{
     int rows,cols;

    for(rows=0;rows<=29;rows++)
    {
        gotoxy(0,rows);
        cout<<"*";
    }
   for(cols=0;cols<=118;cols++)
    {
        gotoxy(cols,0);
        cout<<"*";
    }
    for(rows=0;rows<=29;rows++)
    {
        gotoxy(118,rows);
        cout<<"*";
    }
     for(cols=0;cols<=118;cols++)
    {
        gotoxy(cols,29);
        cout<<"*";
    }
}


int checkbin(int n)
{
    int i,c;
    for(i=1;i<20;i++)
    {
        c=n%10;
        if(c!=0 || c!=1)
        {
            gotoxy(45,17);
            cout<<"Please enter a VALID INPUT ! "<<endl;
            gotoxy(5,26);
            exit(0);
        }

    }


}
int checkoct(int n)
{
    int i,c;
    for(i=1;i<20;i++)
    {
        c=n%10;
        if(c==8 || c==9)
        {
            gotoxy(45,17);
            cout<<"Please enter a VALID INPUT ! "<<endl;
            gotoxy(5,26);
            exit(0);
        }

    }
}

int decToBin(int n)
{
    int a[25],i;

    for(i=0;n>0;i++)
    {
        a[i]=n%2;
        n=n/2;
    }
    for(i=i-1;i>=0;i--)
    {
    cout<<a[i];
    }
    return a[25];
}
int decToOct(int n)
{
    int a[25],i;

    for(i=0;n>0;i++)
    {
        a[i]=n%8;
        n=n/8;
    }
    for(i=i-1;i>=0;i--)
    {
    cout<<a[i];
    }
    return a[25];
}
int decToHex(int n)
{
    char a[50];
    int i=1;
    int r;
      while (n!= 0)
    {
        r = n % 16;
        if (r < 10)
            a[i++] = r + 48;
        else
            a[i++] = r + 55;
        n = n / 16;
    }

    for (i = i-1; i > 0; i--)
    {
        cout << a[i];
    }

     return a[50];
}
int binToDec(int n)
{


    int dec_value = 0;
    int base = 1;

    int temp = n;
    while (temp) {
        int last_digit = temp % 10;
        temp = temp / 10;

        dec_value += last_digit * base;
        base = base * 2;
    }

 return dec_value;
}
int octToDec(int n)
{
    int dec_value = 0;
    int base = 1;

    int temp = n;
    while (temp) {
        int last_digit = temp % 10;
        temp = temp / 10;

        dec_value += last_digit * base;
        base = base * 8;
    }

 return dec_value;
}
int hexToDec(char val[])
{
	int len = strlen(val);


	int base = 1;

	int dec_val = 0;


	for (int i=len-1; i>=0; i--)
	{

		if ((val[i]>='0') && (val[i]<='9') )
		{
			dec_val += (val[i] - 48)*base;


			base = base * 16;
		}


		else if (val[i]>='A' && val[i]<='F')
		{
			dec_val += (val[i] - 55)*base;


			base = base*16;
		}
	}

	return dec_val;
}
int binToOct(int n)
{
    int dec,oct;
    dec=binToDec(n);
    oct=decToOct(dec);
    return oct;
}
int binToHex(int n)
{
    int dec,hex;
    dec=binToDec(n);
    hex=decToHex(dec);
    return hex;

}
int octToBin(int n)
{
    int dec,bin;
    dec=octToDec(n);
    bin=decToBin(dec);
    return bin;
}
int octToHex(int n)
{
    int dec,hex;
    dec=octToDec(n);
    hex=decToHex(dec);
    return hex;

}
int hexToBin(char val[])
{
    int dec,bin;
    dec=hexToDec(val);
    bin=decToBin(dec);
    return bin;
}
int hexToOct(char val[])
{
    int dec,oct;
    dec=hexToDec(val);
    oct=decToOct(dec);
    return oct;
}
int encrypt()
{
    char str[50];
    int i;
    design();
    gotoxy(41,0);
    cout<<" ENCRYPTION TOOL - NexAltar ";
    gotoxy(5,13);
    cout<<"Enter the string you want to ENCRYPT ===> ";
    cin>>str;
    for(i = 0; (i < 100 && str[i] != '\0'); i++)
    {
        str[i] = str[i] + 2;
    }
    gotoxy(5,17);
    cout<<" The Encryption is ===> ";
    ansbox();
    gotoxy(55,17);
    cout<<str;
}
int decrypt()
{
    char str[50];
    int i;
    design();
    gotoxy(41,0);
    cout<<" DECRYPTION TOOL - NexAltar ";
    gotoxy(5,13);
    cout<<"Enter the string you want to DECRYPT ===> ";
    cin>>str;
    for(i = 0; (i < 100 && str[i] != '\0'); i++)
    {
        str[i] = str[i] - 2;
    }
    gotoxy(5,17);
    cout<<" The Decryption is ===> ";
    ansbox();
    gotoxy(55,17);
    cout<<str;
}

int NSC()
{
    design();
    int oper;
    int num;
    int ans;
    int j,b,o,h,encry;
    char val[100];
    gotoxy(41,0);
    cout<<" NUMBER SYSTEM CONVERTER - NexAltar ";
    gotoxy(5,3);
    cout<<" What conversion would you like to perform ? \n"<<endl;
    gotoxy(5,5);
    cout<<" 1. Decimal to Binary"<<setw(27)<<"4. Binary To Decimal"<<setw(27)<<"7. Binary to Octal"<<setw(28)<<"10. Octal to Hexa\n"<<endl;
    gotoxy(5,7);
    cout<<" 2. Decimal to Octal"<<setw(27)<<"5. Octal to Decimal"<<setw(27)<<"8. Binary to Hexa"<<setw(32)<<"11. Hexa to Decimal \n"<<endl;
    gotoxy(5,9);
    cout<<" 3. Decimal to Hexa "<<setw(26)<<"6. Hexa to Decimal"<<setw(29)<<"9. Octal to Binary"<<setw(29)<<"12. Hexa to Octal\n"<<endl;
    gotoxy(5,13);
    cout<<" Enter your Choice ===>  ";
    cin>>oper;
    gotoxy(5,15);
    cout<<" Enter the Value ===>   ";

    if(oper==5 || oper==11 || oper==12)
    {
        cin>>val;
    }
    else
    {
        cin>>num;
    }

    b=binToDec(num);
    o=octToDec(num);
    h=hexToDec(val);
    switch(oper)
    {
         case 1 :
             gotoxy(5,17);
    cout<<" The Conversion is ===> "<<endl;
             ansbox();
            gotoxy(55,17);
             decToBin(num);
         cout<<endl;
         break;

        case 2 :
            gotoxy(5,17);
    cout<<" The Conversion is ===> "<<endl;
            ansbox();
            gotoxy(55,17);
            decToOct(num);
        cout<<endl;
        break;

        case 3 :
            gotoxy(5,17);
    cout<<" The Conversion is ===> "<<endl;
            ansbox();
            gotoxy(55,17);
            decToHex(num);
        cout<<endl;
        break;

        case 4 :
            checkbin(num);
            gotoxy(5,17);
    cout<<" The Conversion is ===> "<<endl;
            ansbox();
            gotoxy(55,17);
            cout<<b<<endl;
        break;

        case 5 :
            checkoct(num);
            gotoxy(5,17);
    cout<<" The Conversion is ===> "<<endl;
            ansbox();
            gotoxy(55,17);
             cout<<o<<endl;
        break;

        case 6 :
            gotoxy(5,17);
    cout<<" The Conversion is ===> "<<endl;
            ansbox();
            gotoxy(55,17);
             cout<<h<<endl;
        break;

        case 7:
            checkbin(num);
            gotoxy(5,17);
    cout<<" The Conversion is ===> "<<endl;
            ansbox();
            gotoxy(55,17);
            binToOct(num);
            cout<<endl;
            break;

        case 8 :
            checkbin(num);
            gotoxy(5,17);
    cout<<" The Conversion is ===> "<<endl;
            ansbox();
            gotoxy(58,17);
            binToHex(num);
        cout<<endl;
        break;

        case 9 :
            checkoct(num);
            gotoxy(5,17);
    cout<<" The Conversion is ===> "<<endl;
            ansbox();
            gotoxy(55,17);
            octToBin(num);
        cout<<endl;
        break;

        case 10 :
            checkoct(num);
            gotoxy(5,17);
    cout<<" The Conversion is ===> "<<endl;
            ansbox();
            gotoxy(55,17);
            octToHex(num);
        cout<<endl;
        break;

        case 11 :
            gotoxy(5,17);
    cout<<" The Conversion is ===> "<<endl;
            ansbox();
            gotoxy(55,17);
            hexToBin(val);
        cout<<endl;
        break;

        case 12 :
            gotoxy(5,17);
    cout<<" The Conversion is ===> "<<endl;
            ansbox();
            gotoxy(55,17);
            hexToOct(val);
        cout<<endl;
        break;
        }
        gotoxy(7,23);
    cout<<"Do you want to encrypt the conversion ? (y[1]/n[0])"<<endl;
    gotoxy(7,25);
    cin>>encry;
    if(encry==1)
    {
        clrscr();
     encrypt();
    }
}


int sel()
{
    design();
    int i;
    gotoxy(54,0);
    cout<<" NEXALTAR ";
    gotoxy(44,10);
    cout<<"What do you want to perform ?"<<endl;
    gotoxy(44,12);
    cout<<"1. Number System Conversion ";
    gotoxy(44,14);
    cout<<"2. Encryption ";
    gotoxy(44,16);
    cout<<"3. Decryption ";
    gotoxy(18,20);
    cout<<"Enter your selection==> ";
    cin>>i;
    switch(i)
    {
        case 1 :
            clrscr();
            NSC();
            return 0;

       case 2 :
           clrscr();
            encrypt();
            return 0;

       case 3 :
           clrscr();
           decrypt();
           return 0;
    }
}
int identifyuser(char user[20],int pass)
{
    if(pass==123)
    {
        clrscr();
        sel();
    }
    else
    {
        design();
        gotoxy(35,15);
        cout<<"Please Enter Valid Credentials !"<<endl;
        return 0;
    }
}


int main()
{
     char user[20];
     int pass;
    design();
    gotoxy(54,0);
    cout<<" NEXALTAR ";
    gotoxy(48,27);
    cout<<"Developed By NexAltar";
    gotoxy(54,10);
    cout<<"LOGIN USER";
    gotoxy(42,13);
    cout<<"UserName : ";
    cin>>user;
    gotoxy(42,15);
    cout<<"Password : ";
    cin>>pass;
    clrscr();
    identifyuser(user,pass);
    gotoxy(5,26);
    return 0;
}
