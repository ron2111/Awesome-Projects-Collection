/*====================  "BOOK MY SHOW" =========================================
  STUDENTS:- ANISH and SHUBHAM
  CLASS:- 12th B
			FINAL PROJECT
==============================================================================  */
#include<conio.h>
#include<dos.h>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<fstream.h>
#include<ctype.h>
#include<iomanip.h>
void del_mov();
void tick();
int auto_inc();
void welcome()
{
clrscr();
gotoxy(33,12);
cout<<" Welcome ";
delay(1000);
for(int i=0;i<14;i++)
	{
	delay(200);
	gotoxy(i+32,12);
	cout<<" ";
	}
}
void load()
{
clrscr();
int i;
gotoxy(35,12);
cout<<"Loading";
for(i=0;i<8;i++)
	{
	delay(80);
	cout<<".";
	}
}
class offer
	{
	char ocode[10];
	float odis;
	public:
	offer()
		{
		ocode[0]='\0';
		odis=0.0;
		 }
       ~ offer()
	      {
	      }
	void gen_off() //Generating Offers
		{
		clrscr();
		char ch;
		cout<<"\t\t\t\t OFFER";
		cout<<"\n\n\t GENERATE OFFER CODE FOR \"FREE\" !!";
		cout<<"\n\n Do you want to generate offer code?? (Y/N): ";
		cin>>ch;
		ch=toupper(ch);
		if(ch=='Y')
			{
			int x;
			randomize();
			odis=random(6)+5.0;
			x=random(4)+1;
			switch(x)
				{
				case 1: strcpy(ocode,"MOV50");
					break;
				case 2: strcpy(ocode,"DIS10");
					break;
				case 3: strcpy(ocode,"POP20");
					break;
				case 4: strcpy(ocode,"NEW30");
					break;
				}
				cout<<"\n Code: ";
				puts(ocode);
				cout<<" Discount: "<<odis<<"%"<<endl;
				cout<<"\n\n\n Please note: The generated code is OTO (One Time Offer), means this will not be valid after use or after you exit the program";
			}
		}
	int com_code(char ch[])
		{
		return strcmpi(ch,ocode);
		}
       float ret_dis()
		{
		return odis/100;
		}
	}o;

class movies
	{
	int movid;
	char movn[40];
	int ticno;
	public:
	void movdata()  //To Enter Movies data
		{
		cout<<"\nEnter Movie Name: ";
		gets(movn);
		cout<<"Enter Movie No. of Tickets: ";
		cin>>ticno;
		}
	void inc_movid()
		{
		movid=auto_inc();
		}
	void showmovdata() //To show Movies data
		{
		cout<<endl;
		cout<<movid;
		cout<<setw(30)<<movn;
		cout<<setw(30)<<ticno;
		}
	int ret_movid()
		{
		return movid;
		}
	int ret_ticno()
		{
		return ticno;
		}
	void give_ticno(int n)
		{
		ticno=n;
		}
	}m;
int auto_inc() //This function will auto-increment movie code
{
int m_id=100;
fstream file;
file.open("movie.dat",ios::binary|ios::in);
while(file.read((char*)&m,sizeof(m)));
m_id=m.ret_movid()+1;
file.close();
return m_id;
}
void mov()//for movies menu
{
int x;
fstream file;
do
	{
	load();
	clrscr();
	gotoxy(5,2);
	cout<<"\t \t \t \t MOVIES";
	cout<<"\n\t \t \t \t------------";
	gotoxy(1,4);
	cout<<"\n1. Enter New Movie";
	cout<<"\n2. View/Book Movie";
	cout<<"\n3. Delete Movie";
	cout<<"\n0. Back";
	cout<<"\n\nEnter your choice please: ";
	cin>>x;
	switch(x)
		{
		case 1: file.open("movie.dat",ios::binary|ios::app);
			m.inc_movid();
			m.movdata();
			file.write((char*)&m,sizeof(m));
			file.close();
			break;
		case 2: cout<<"\nMovie ID ";
			cout<<setw(30)<<"Movie Name ";
			cout<<setw(35)<<"Movie No. of Tickets ";
			file.open("movie.dat",ios::binary| ios::in);
			while(file.read((char*)&m,sizeof(m)))
				{
				  m.showmovdata();
				}
			file.close();
			char ch;
			cout<<"\n\nBook? (Y/N): ";
			cin>>ch;
			ch=toupper(ch);
			if(ch=='Y')
			tick();
			getch();
			break;
		case 3:del_mov();
			break;
		default :cout<<"INVALID INPUT!!!\n Please try again";
			break;
		}
       }while(x!=0);
}
int apply_off(float tp)   //input and comparing of discount
	{
	 char ch[10];
	 cout<<"Enter code: ";
	 gets(ch);
	 if(o.com_code(ch)==0)
		tp=tp-(o.ret_dis()*tp);
	 else
		cout<<"Invalid Code"<<endl;
	 return tp;
	}
class info
	{
	char fnam[20];
	char lnam[20];
	char user[40];
	char pass[20];
	char mob[12];
	char add[50];
	public:
	void data()			// for info/data of user
		{
		cout<<"\nEnter first name: ";
		gets(fnam);
		cout<<"  Enter last name: ";
		gets(lnam);
		cout<<"  Enter user name: ";
		gets(user);
		cout<<"  Enter password: ";
		gets(pass);
		cout<<"  Enter your mobile number: ";
		gets(mob);
		cout<<"  Enter your address: ";
		gets(add);
		}
	void showdata()        //for showing data/info of user
		{
		cout<<"\nFirst name: ";
		puts(fnam);
		cout<<"Last name: ";
		puts(lnam);
		cout<<"Your userid: ";
		puts(user);
		cout<<"Your password: ";
		puts(pass);
		cout<<"Your mobile no.: ";
		puts(mob);
		cout<<"Your address: ";
		puts(add);
		cout<<endl;
		getch();
		}
	void change()
		{
		cout<<"\nEnter new user name: ";
		gets(user);
		cout<<"Enter new password: ";
		gets(pass);
		}
	int com_user(char id[])
		{
		return strcmpi(user,id);
		}
	int com_pass(char pas[])
		{
		puts(pass);
		puts(pas);
		return strcmpi(pass,pas);
		}
	}inf;
void info()
{
int x;
fstream file;
file.open("info.dat",ios::binary|ios::out|ios::in);
do
	{
	load();
	clrscr();
	gotoxy(5,2);
	cout<<"\t \t \t \t INFO";
	cout<<"\n\t \t \t \t----------";
	gotoxy(1,4);
	cout<<"\n1. Renter Personal info";
	cout<<"\n2. View Personal Info";
	cout<<"\n3. Change User id/Password";
	cout<<"\n0. Back";
	cout<<"\n Enter your choice please: ";
	cin>>x;
	switch(x)
		{
		case 1: inf.data();
			file.write((char*)&inf,sizeof(inf));
			file.close();
			break;
		case 2: file.read((char*)&inf,sizeof(inf));
			inf.showdata();
			file.close();
			break;
		default :cout<<"INVALID INPUT!!!\n Please try again";
			  break;
		}
       }while(x!=0);
}
void tick()
{
int n=0,tp,id,pos;
char ch;
cout<<endl<<"Enter movie id: ";
cin>>id;
tp=300;
cout<<"\t Rs. "<<tp<<"/- Price per head";
cout<<"\n Tickets required: ";
cin>>n;
cout<<"Total amount: Rs. "<<n*tp<<endl;
cout<<"\n Do you have any offer code?? (Y/N): ";
cin>>ch;
ch=toupper(ch);
if(ch=='Y')
	{
	tp=apply_off(tp);
	cout<<"\t\nTotal amount: Rs. "<<n*tp;
	}
cout<<"\n Booking confirmed?(Y/N): ";
cin>>ch;
ch=toupper(ch);
if(ch=='Y')
{
	cout<<"\t\t\n BOOKING CONFIRMED ";
	cout<<"\t\t\n Thank you for a visit ";
	fstream file;
	file.open("movie.dat",ios::binary|ios::in);
	int rno=0;
	while(file.read((char*)&m,sizeof(m)))
	{
		if(m.ret_movid()==id)
		 {
			break;
		}
		 else
			rno++;
	}
	file.close();
	file.open("movie.dat",ios::binary|ios::in|ios::out);
	file.seekg(rno*sizeof(m),ios::beg);
	file.read((char*)&m,sizeof(m));
	int tn=m.ret_ticno();
	tn=tn-n;
	file.seekg(rno*sizeof(m),ios::beg);
	m.give_ticno(tn);
	file.write((char*)&m,sizeof(m));
	file.close();
	}
}
void del_mov()
{
int n;
cout<<"Movie code to be deleted: ";
cin>>n;
fstream file,tfile;
file.open("movie.dat",ios::binary|ios::in);
tfile.open("Temp.dat",ios::binary|ios::out);
while(file.read((char*)&m,sizeof(m)))
	{
	if(m.ret_movid()!=n)
		{
		m.showmovdata();
		tfile.write((char*)&m,sizeof(m));
		}
	}
tfile.close();
file.close();
remove("movie.dat");
rename("temp.dat","movie.dat");
}
void main()
{
clrscr();
//welcome();
int ch;
char id[20],pas[20];
gotoxy(25,12);
cout<<"Enter user name: ";
gets(id);
gotoxy(25,14);
cout<<"Enter Password: ";
for(int i=0;i<20;i++)
	{
	pas[i]=getch();
	if(pas[i]==13)
	      break;
	cout<<"*";
	}
pas[i]='\0';
fstream file;
file.open("info.dat",ios::binary|ios::in);
file.read((char*)&inf,sizeof(inf));
if(inf.com_user(id)==0)
     {
     if(inf.com_pass(pas)==0)
	{
	    do
		{
		clrscr();
		gotoxy(5,2);
		cout<<"\t \t \t \t BOOK YOUR SHOW";
		cout<<"\n\t \t \t \t----------------";
		gotoxy(1,4);
		cout<<"1. MOVIES\n";
		cout<<"2. INFO  \n";
		cout<<"3. OFFERS \n";
		cout<<"0. EXIT\n" ;
		cout<<"\n Enter your choice please: ";
		cin>>ch;
		switch(ch)
			{
			case 1: mov();
				break;
			case 2:	info();
				break;
			case 3: o.gen_off();
				getch();
				break;
			case 0: exit(0);
			default :cout<<"INVALID INPUT!!!\n Please try again";
				break;
			}
		}while(ch!=0);
	    }
	 }
else
	{
	gotoxy(26,18);
	cout<<"INCORRECT PASSWORD OR USER NAME!!";
	gotoxy(26,20);
	cout<<"Try Again";
	}
file.close();
getch();
}
