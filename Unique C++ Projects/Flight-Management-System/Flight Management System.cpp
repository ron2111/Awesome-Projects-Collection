#include<conio.h>
#include<iostream>
#include<string.h>
#include<fstream>
#include<unistd.h>
#include<time.h>
#include<cmath>
#include<ctime>
#include<stdlib.h>
#include"payment.h"
#include<stdio.h>
using namespace std;

bool datecheck(int, int, int, int);
const char l_destination[5][20]={"LAHORE","ISLAMABAD","KARACHI","PESHAWAR","QUETTA"};	//local Destination
const char i_destination[11][20]={"LONDON","BERLIN","DUBAI","RIYADH","BEIJING","PARIS","CANBERRA","TOKYO","WASHINGTON","DELHI","ISLAMABAD" }; //International Destination

class passenger{
	private:
		const int bseats;
		const int eseats;
	protected:
		string firstname,lastname, phone, mealtype, passport, Address;
		int bus, eco, datedep, payment;
		char origin[30];
		char destination[30];
	public:		
		passenger(string f_name, string l_name, string phone_no, string add="N/A", string pass_no="N/A", int dd=000000): bseats(50), eseats(250)
		{
			datedep=dd;
			firstname=f_name;
			lastname=l_name;
			Address=add;
			phone=phone_no;
			passport=pass_no;
			bus = bseats;
			eco = eseats;
		}
		
		virtual bool ldest()=0;
		virtual bool idest(string pass)=0;
		virtual void seats()=0;
		virtual void Meals()=0;
		virtual void Registration()=0;
		virtual bool display()=0;
		virtual void drive()=0;
		
};

class booking:public passenger
{
	protected:
		int i,j,n,m,k,NoOfSeats,choice;
	public:
		
		booking(string f,string l,string num,string add,string pass,int dd):passenger(f,l,add,num,pass,dd)
		{
			n=0;
			m=0;
		}
		
	bool ldest()
	{
		
		cout<<endl<<"These are the local destinations where we are flying: \n";
		for(i=0;i<5;i++)
		{
			for(j=0;j<20;j++)
			{
				cout<<l_destination[i][j];
			}
			cout<<"\n";
		}

		again:
		cout<<endl<<"Enter your origin(using BLOCK letters): ";
		cin>>origin;
		cout<<endl<<"Enter your destination(using BLOCK letters): ";
		cin>>destination;
		if(strcmp(origin,destination)==0)
		{
			cout<<"Invalid Origin and Destination Enter again\n";
			goto again;
		}
		else
		{
			for(i=0;i<5;i++)
			{
				if(strcmp(l_destination[i],origin)==0)
					n++;
			}
			for(j=0;j<5;j++)
			{
				if(strcmp(l_destination[j],destination)==0)
					m++;
			}
			if(m==1&&n==1)
			{
				payment = lpayment(origin, destination);
				cout<<endl<<"Price: "<<payment<<" Pkr/seat"<<endl;
				return true;
			}
			else 
				return false;
			
		}
	}
	
		bool idest(string pass)
	{
		passport = pass;
		cout<<endl<<"These are the international destinations where we are flying: \n";
		for(i=0;i<11;i++)
		{
			for(j=0;j<20;j++)
			{
				cout<<i_destination[i][j];
			}
			cout<<"\n";
		}
		again:
		cout<<endl<<"Enter your origin(using BLOCK letters): ";
		cin>>origin;
		cout<<endl<<"Enter your destination(using BLOCK letters): ";
		cin>>destination;
		if(strcmp(origin,destination)==0)
		{
			cout<<"Invalid Origin and Destination Enter again\n";
			goto again;
		}
		else
		{
			for(i=0;i<11;i++)
			{
				if(strcmp(i_destination[i],origin)==0)
					n++;
			}
			for(j=0;j<11;j++)
			{
				if(strcmp(i_destination[j],destination)==0)
					m++;
			}
			if(m==1&&n==1)
			{
				payment = ipayment(origin, destination);
				cout<<endl<<"Price: "<<payment<<" Pkr/seat"<<endl;
				return true;
			}
			else 
				return false;
		}
	}

		
		void seats()
		{
			bus_eco:
				if(bus>0&&eco>0)
				{
					cout<<endl<<"1.Business Class\n2.Economy Class\n";
					k = getch();
					switch(k)
					{
						case 49:
						{
							cout<<endl<<"Business Class";
							cout<<endl<<"Enter the number of seats: ";
							cin>>NoOfSeats;
							payment=(payment*NoOfSeats)+5000;
							if(NoOfSeats<=bus)
							{
								cout<<endl<<"Seats are available.\n\n";
								bus=bus-NoOfSeats;
							}
							else
							{
								cout<<endl<<"Seats are not available.\n\n";
								cout<<"we have only "<<bus<<" seats available.\n"<<endl;
								cout<<"Do you wish to book remaining seats\nPress 1 for YES\nPress 2 for NO\n";
								k = getch();
								if(k==49)
								{
									NoOfSeats = bus;
									payment=(payment*NoOfSeats)+5000;
								 	cout<<"Seats are booked\n\n";
								 	bus=0;
								}
								else
								{
									cout<<endl<<"See you again.\n";
									exit(0);
								}
							}
							break;
						}
						
					case 50:
						{
							cout<<endl<<"Economy Class";
							cout<<endl<<"Enter the number of seats: ";
							cin>>NoOfSeats;
							payment=(payment*NoOfSeats);
							if(NoOfSeats<=eco)
							{
								cout<<endl<<"Seats are available.\n\n";
								eco=eco-NoOfSeats;
							}
							else
							{
								cout<<endl<<"Seats are not available.\n\n";
								cout<<"we have only "<<eco<<" seats available.\n"<<endl;
								cout<<"Do you wish to book remaining seats\nPress 1 for YES\nPress 2 for NO\n";
								k = getch();
								if(k==49)
								{
									NoOfSeats = eco;
									payment=(payment*NoOfSeats);
									cout<<endl<<"Seats are booked\n\n";
									eco=0;
								}
								else
								{
									cout<<endl<<"See you again.\n";
									exit(0);
								}
							}
							break;
						}
					
					default:
						{
							cout<<"Error!\n";
							goto bus_eco;
						}
				}
			}
			else
			{
				cout<<endl<<"Sorry no seats available\nHave a nice day!";
				exit(0);
			}
		}
	
		
		void Meals()
		{
			meal:
			int n;
			cout<<endl<<"Available meal types:\n1.Vegetarian\n2.Non-Vegetarian\n";
			n = getch();
			if(n==49)
				mealtype="Vegetarian";
			else if(n==50)
				mealtype="Non Vegetarian";
			else
			{
				cout<<"ERROR!!!"<<endl;
				goto meal;
			}
		}
		
		void Registration()
		{
			int tkt;
			srand (time(NULL));
			tkt = rand()%1000;
			if(k==49)
			{
				ofstream outfile;
				outfile.open("flight.txt");
				outfile<<"|TICKET INFORMATION:"<<endl<<endl
				<<"Name: "<<firstname<<" "<<lastname<<endl
				<<"Phone: "<<Address<<endl
				<<"Address: "<<phone<<endl
				<<"Passport Number: "<<passport<<endl
				<<"Origin: "<<origin
				<<endl<<"Destination: "<<destination
				<<endl<<"Food: "<<mealtype
				<<endl<<"Number of Seats: "<<NoOfSeats
				<<endl<<"Class: Business"
				<<endl<<"Date of departure: "<<datedep
				<<endl<<"Time: 4.00 PM"
				<<endl<<"Ticket: HF"<<tkt
				<<endl<<"Bill(in pakistani rupees): "<<payment<<"/-"<<endl;				
				outfile.close();
			}
			else if(k==50)
			{
				ofstream outfile;
				outfile.open("flight.txt");
				outfile<<"|TICKET INFORMATION:"<<endl<<endl
				<<"Name: "<<firstname<<" "<<lastname<<endl
				<<"Phone: "<<Address<<endl
				<<"Address: "<<phone<<endl
				<<"Passport Number: "<<passport<<endl
				<<"Origin: "<<origin
				<<endl<<"Destination: "<<destination
				<<endl<<"Food: "<<mealtype
				<<endl<<"Number of Seats: "<<NoOfSeats
				<<endl<<"Class: Economy"
				<<endl<<"Date of departure: "<<datedep
				<<endl<<"Time: 4.00 PM"
				<<endl<<"Ticket: HF"<<tkt
				<<endl<<"Bill(in pakistani rupees): "<<payment<<"/-"<<endl;
				outfile.close();
			}
		}
		
		bool display()
		{
			bool ans;
			system("cls");
			string temp;
			ifstream infile;
			infile.open("flight.txt");
			while(!infile.eof())
			{
				getline(infile,temp);
				cout<<temp<<endl;
			}
			ans = confirm();
			return ans;
		}
		
		bool confirm()
		{
			char ch;
			confirm:
			cout<<endl<<endl<<"Do you wish to confirm your ticket?(y/n): ";
			ch=getch();
			if(ch=='Y'||ch=='y')
			{
				cout<<endl<<endl<<"|STATUS CONFIRMED";
				ofstream outfile;
				outfile.open("flight.txt",ios::app);
				outfile<<endl<<"|STATUS CONFIRMED";
				outfile.close();
				return true;
			}
			else if(ch=='N'||ch=='n')
			{
				ofstream outfile;
				outfile.open("flight.txt",ios::app);
				outfile<<endl<<"|BOOKING CANCELLED";
				cout<<endl<<endl<<"|BOOKING CANCELLED"
				<<endl<<"Going back to main page";
				sleep(3);
				outfile.close();
				return false;
			}
			else
			{
				cout<<endl<<"ERROR!!!";
				goto confirm;
			}
		}
		
		inline void drive()
		{
			string pick;
			cout<<endl<<"Please enter your pickup point: ";
			cin.ignore();
			getline(cin,pick);
			cout<<endl<<endl<<"Pickup Location: "<<pick;
			cout<<endl<<"Drop Off: "<<origin<<" Airport"
			<<endl<<"Fare: 300/-";
			cout<<endl<<endl<<"You will be contacted by our driver shortly\nHave a nice day!";
			fstream ofile;
			ofile.open("flight.txt",ios::app);
			ofile<<endl<<endl<<"Pick'n Drop: YES"<<endl<<endl
			<<"Pickup Location: "<<pick
			<<endl<<"Drop Off: "<<origin<<" Airport"
			<<endl<<"Fare: 300/-";
			ofile.close();
		}
};

class Manage
{
	private:
		string temp,y,c2;
		int option;
	public:
		int change()
		{	
			int i=0;
			
			ifstream file("flight.txt");
			if(file.is_open())
			{
			cout<<endl<<"Enter your Ticket Number or Press 0 to exit\nTicket Number: ";
			cin>>temp;
			if(temp=="0")
				return 1;
			string v("Ticket: "+temp);
			
			while(!file.eof())
			{
				getline(file,y);
				if(y==v)
				{
					file.seekg(0,ios::beg);
					while(!file.eof())
					{
						getline(file,temp);
						cout<<temp<<endl;
					}
					cout<<endl<<endl<<"1.Change date\n2.Cancel the flight\n3.Go Back\n";
					option = getch();
					switch(option)
					{
						case 49:
						{
							file.seekg(0,ios::beg);
							ofstream ofile("temp.txt");
							cout<<endl<<"Enter the new date of departure(DDMMYYYY): ";
							cin>>c2;
							string c1("Date of departure: "+c2);
							while(!file.eof())
							{
								getline(file,y);
								if(i==11)
								{
									i++;
									ofile<<c1<<endl;
								}
								else
								{
									i++;
									ofile<<y<<endl;
								}
							}
							file.close();
							ofile.close();
							ofstream outfile;
							outfile.open("flight.txt");
							ifstream readfile("temp.txt");
							while(!readfile.eof())
							{
								getline(readfile,y);
								outfile<<y<<endl;
							}
							outfile.close();
							readfile.close();
							remove("temp.txt");
							cout<<endl<<"Date Changed!";
							return 1;
							break;
						}
					
						case 50:
						{
							file.close();
							ofstream ofli;
							ofli.open("flight.txt",ios::trunc);
							ofli.close();
							remove("flight.txt");
							system("cls");
							cout<<endl<<"Booking cancelled!\n\n";
							return 1;
							break;
						}
						case 51:
							system("cls");
							return 1;
					}
				}
			}
		}
		else if(!file.is_open())
		{
			cout<<endl<<endl<<"unable to find any record"<<endl;
			cout<<endl<<"going back to main page\n\n";
			file.close();
			return 1;
		}
	}
};


class about
{
	public:
		void Aboutus()
		{
			cout<<"The height of skies was first touched by our airline in 1969. Since then,\nHigh Fly is the world's leading airline with 4 biggest airplanes.\nWe are at the customers high service in cuisine, comfort and care.\nSo make a plan and fly high with High Fly."<<endl<<endl;
			cout<<"Press any key to continue...";
		}
	
};

class complain
{
	private:
		string f_name, l_name, p_num;
		int choice;
		string sentence;
		string types;
		char ch;
	public:
		complain(string f,string l,string num)
		{
			f_name = f;
			l_name = l;
			p_num = num;
		}
		
	void type()
	{
		back:
		cout<<endl<<endl<<"Enter the type of complain you want to register:\n1.Airport Handling\n2.Baggage Delivery\n3.Booking and ticketing\n4.Other\n";
		choice = getch();
		cin.ignore();
		cout<<"Enter your complain:\n";
		if(choice==49)
		{
			cout<<"Airport Handling: ";
			types = "Aiprort Handling: ";
		}
		else if(choice==50)
		{
			cout<<"Baggage Delivery: ";
			types = "Baggage Delivery: ";
		}
		else if(choice==51)
		{
			cout<<"Booking and Ticketing: ";
			types = "Booking and Ticketing: ";
		}
		else if(choice==52)
		{
			cout<<"Other: ";
			types = "Other: ";
		}
		getline(cin,sentence);
		cout<<endl<<"Do you want to edit your complain(y/n): ";
		ch=getch();
		if(ch=='Y'||ch=='y')
			goto back;
		else
		{
			cout<<endl<<"Complain noted!\n";
			ofstream outfile;
			outfile.open("complain.txt");
			outfile<<"Name: "<<f_name<<" "<<l_name<<endl
			<<"Phone: "<<p_num<<endl
			<<"Complain:\n"<<types<<sentence;
			outfile.close();
			sleep(3);		
		}
	}
};



class routes{
	public:
		bool print()
		{
			int i,j;
			char ch;
			cout<<"\n\n\n\n\tFollowing are the international flights available"<<endl;
			for(i=0;i<11;i++)
			{
				cout<<endl;
				for(j=0;j<11;j++)
				{
					if(i==j)
					{
						continue;
					}
					else
					{
						cout<<"Flight from "<<i_destination[i]<<" to "<<i_destination[j]<<endl;
					}
					
				}
			}
			cout<<"\n\n\n\n\tFollowing are the local flights available"<<endl;
			for(i=0;i<5;i++)
			{
				cout<<endl;
				for(j=0;j<5;j++)
				{
						if(i==j)
					{
						continue;
					}
					else
					{
						cout<<"Flight from "<<l_destination[i]<<" to "<<l_destination[j]<<endl;
					}
				}
			}
			cout<<endl<<"Do you want to book a flight(y/n) ";
			ch=getch();
			if(ch=='Y'||ch=='y')
			{
				cout<<endl<<endl;
				return true;
			}
			else
				return false;
		}
		
};


int main()
{
	
	
	system("COLOR 5f");
	cout<<"\n\t\t\t\tCOMPUTER PROGRAMMING LAB PROJECT\n\t\t  FLIGHT MANAGEMENT SYSTEM";
	cout<<"\nPress Enter to continue: ";
	getch();

	cout<<endl<<"\n\n\n\tWelcome to HIGH FLY Airline"<<endl;
	string f_name, l_name, add, pass_no,phone_no;
	int choice, datedep, date, month, year;
	bool ans;
	char ch;
	time_t t= time(NULL);
	tm* timePtr=localtime(&t);
	date=(timePtr->tm_mday);
	month=(timePtr->tm_mon)+1;
	year=(timePtr->tm_year)+1900;

	back2:
	cout<<endl<<"Press 1 for Booking"
	<<endl<<"Press 2 for Routes"
	<<endl<<"Press 3 for Complaint"
	<<endl<<"Press 4 for About"
	<<endl<<"Press 5 for Manage"
	<<endl<<"Press 0 for Exit\n";
	choice = getch();
	system("cls");
	switch(choice)
	{
		case 49:
			{
				my:
				cout<<">>>>>>>>>>BOOKING<<<<<<<<<<<\n";
				passenger *ptr;
				cout<<"Enter Your First Name: ";
				cin>>f_name;
				cin.ignore();
				cout<<"Enter Your Last Name: ";
				getline(cin,l_name);
				cout<<"Enter Your Address(Using Commas only): ";
				getline(cin,add);
				cout<<"Enter Your Phone Num(Without -): ";
				cin>>phone_no;
				date:
				cout<<"Enter date of departure(DDMMYYYY): ";
				cin>>datedep;
				
//				ans = datecheck(datedep, date, month, year);
//				if(ans==false)
//				{
//					cout<<"WRONG DATE"<<endl<<endl;
//					goto date;
//				}
				booking obj1(f_name,l_name,phone_no,add,pass_no,datedep);
				ptr = &obj1;
				back:
				cout<<endl<<"1.Local Destination\n2.International Destination\n3.Back\n4.Exit\n";
				choice = getch();
				
				if(choice==49)
				{
					
					if(ptr->ldest()==false)
					{
						cout<<endl<<"We donot fly to this place\nPlease Choose again\n";
						goto back;
					}
					else
					{
						cout<<endl<<"Yes we do fly\n";
						ptr->seats();
						ptr->Meals();
						ptr->Registration();
						system("cls");
						ans = ptr->display();
						if(ans==false)
						{
							system("cls");
							goto back2;
						}
						else if(ans==true)
						{
							cout<<endl<<"Thanks for Flying With Us"<<endl<<endl
							<<"Would you like to avail our Pick'n Drop facility?(y/n)";
							ch = getch();
							if(ch=='y'||ch=='Y')
								ptr->drive();
							else if(ch=='n' || ch=='N')
							{
								ofstream ofile;
								ofile.open("flight.txt", ios::app);
								ofile<<endl<<endl<<"Pick'n Drop: NO";
								ofile.close();
							}
							getch();
							system("cls");
							goto back2;
						}
					}
				}
				else if(choice==50)
				{
					cout<<endl<<"Enter Your Passport Num(Without \"-\"): ";
					cin>>pass_no;
					ans = ptr->idest(pass_no);
					if(ans==false)
					{
						cout<<endl<<"We donot fly to this place\n";
						goto back;
					}
					else
					{
						cout<<endl<<"Yes we do fly\n";
						ptr->seats();
						ptr->Meals();
						ptr->Registration();
						system("cls");
						ans = ptr->display();
						if(ans==false)
						{
							system("cls");
							goto back2;
						}
						else if(ans==true)
						{
							cout<<endl<<"Thanks for Flying With Us"<<endl<<endl
							<<"Would you like to avail our Pick'n Drop facility?(y/n)";
							ch = getch();
							if(ch=='y'||ch=='Y')
								ptr->drive();
							else if(ch=='n' || ch=='N')
							{
								ofstream ofile;
								ofile.open("flight.txt", ios::app);
								ofile<<endl<<endl<<"Pick'n Drop: NO";
								ofile.close();
							}
							getch();
							system("cls");
							goto back2;
						}
					}
				}
				else if(choice==51)
				{
					system("cls");
					goto back2;
				}
				else
					exit(0);
				break;	
			}
			
			case 50:	//choice = 2
				{
					cout<<">>>>>>>>>>ROUTES<<<<<<<<<<<\n";
					routes obj;
					ans = obj.print();
					if(ans==true)
						goto my;
					else if(ans==false)
					{
						cout<<endl;
						system("cls");
						goto back2;
					}
					break;
				}
				
			case 51:	//choice = 3
				{
					cout<<">>>>>>>>>>COMPLAINT<<<<<<<<<<<\n";
					cout<<"Enter Your First Name: ";
					cin>>f_name;
					cin.ignore();
					cout<<"Enter Your Last Name: ";
					getline(cin,l_name);
					cout<<"Enter Your Phone Num(Without -): ";
					cin>>phone_no;
					complain obj(f_name,l_name,phone_no);
					obj.type();
					system("cls");
					goto back2;
					break;
				}
				
			case 52:	//choice = 4
				{
					cout<<"\t\t>>>>>>>>>>ABOUT US<<<<<<<<<<<\n";
					about obj;
					obj.Aboutus();
					getch();
					system("cls");
					goto back2;
					break;
				}
			case 53:
				{
					cout<<">>>>>>>>>>MANAGE<<<<<<<<<<<\n";
					Manage pass;
					chnge:
					choice= pass.change();
					if (choice==1)
					{
						sleep(2);
						system("cls");
						goto back2;
					}
					else
					{
						cout<<"No record found\n";
						goto chnge;
					}
						
					break;
				}
				
			case 48:	//choice = 0
				{
					exit(0);
				}
				
			default:
				cout<<endl<<endl<<"ERROR!!!";
				goto back2;
	}
        return 0;
}

bool datecheck(int datedep, int date, int month, int year)
{
	if((datedep%10000)>2017&&(datedep%10000)==year)
		if(((datedep/10000)%100)>0 && ((datedep/10000)%100)<13&&((datedep/10000)%100)==month)
			if((datedep/1000000)>0 && (datedep/1000000)<32&&(datedep/1000000)>date&&(datedep/1000000)<(date+20))
				return true;
	else
		return false;
}
