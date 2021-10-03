//#############################-HEADER FILES-###############################
#include<fstream.h>
#include<conio.h>
#include<graphics.h>
#include<ctype.h>
#include<stdlib.h>
#include<stdio.h>
#include<time.h>
#include<dos.h>
#include<string.h>
//#############################-USER DEFINED FUNCTIONS-#######################
void fsnake();
void controls();
void addition();
void display();
void search();
void deletion();
void modification();
void highsnake();
int idgen();
//##############################-GLOBAL VARIABLES-#############################
fstream file;
fstream file2;
fstream file3;
fstream snk_file; 

//###############################-EMPLOYEE-##################################
struct tade
{
	int dd;
	int mm;
	int yy;
};
class employee
{
	public:
	char name[40];
	tade d1;
	int idno;
	void display_str();
	void dateval();

}e1;
//.........................class employee's functions..........................
void employee::display_str()
{
		cout<<idno<<"\t"<<name<<"\t\t"<<d1.dd<<"/"<<d1.mm<<"/"<<d1.yy<<endl;
}
void employee::dateval()
{
	while(1)
	{
		cout<<"Enter your joining date dd/mm/yy"<<endl;
		cin>>d1.dd;
		cin>>d1.mm;
		cin>>d1.yy;
		if(d1.yy>1940 && d1.yy<2040)
		{
			if(d1.mm<=12)
			{
				if(d1.mm==4||d1.mm==6||d1.mm==9||d1.mm==11) //months with 30 days
 				{
					if(d1.dd>0&&d1.dd<=30)
						break;
					else
					{
						cout<<"invalid date try again"<<endl;
						getch();
						continue;
					}

				}
				if(d1.mm==2) //FEB
				{
				    if( (d1.yy%4==0 && d1.yy%100!=0) || (d1.yy%400==0) ){
                        
						if(d1.dd>0&&d1.dd<=29)
							break;
						else
						{
							cout<<"invalid date try again"<<endl;
							getch();
							continue;
						}
                    }
					else
					{
						if(d1.dd>0&&d1.dd<=28)
							break;
						else
						{
							cout<<"invalid date try again"<<endl;
							getch();
							continue;
						}
					}
				}
				if(d1.mm==1||d1.mm==3||d1.mm==5||d1.mm==7||d1.mm==8||d1.mm==10||d1.mm==12) //months with 31 days
				{
					if(d1.dd>0&&d1.dd<=31)
						break;
					else
					{
						cout<<"invalid date try again"<<endl;
						getch();
						continue;
					}
				}
				else
				{
					cout<<"invalid date try again"<<endl;
					getch();
					continue;
				}
			}
			else
			{
				cout<<"invalid date try again"<<endl;
				getch();
				continue;
			}
		}
		else
		{
			cout<<"invalid date try again"<<endl;
			getch();
			continue;
		}
	}
}
//############################-MAIN FRAME OF PROJECT-##############################
class mf
{
	private:
		char a; //1 w s ' ' option chosen
		int chosen;  //2 which box is currently chosen  (1,2,3)
		int writeup;  //3 which writeup is displayed  (1,2,3,4,5)
	public:
		mf()
		{
			a='w';
			chosen=1;
			writeup=1;
		}
		int make(int,int);
		int menu();
		void ent();
		void storage();
		void data();
		void modify();
		void body();
		void typemaster();
		void snakemenu();
		~mf()
		{}
};
//........................class mf's functions..........................................................
int mf::make(int x=1,int y=0)   // x for which box is chosen of the 3,  y for which writeup is displayed
{
    settextstyle(1,0,1);
	char box1[20],box2[20],box3[20];
	cleardevice();
	setbkcolor(BLACK);
	setcolor(WHITE);
	if(y==1)
	{
		strcpy(box1,"Storage");
		strcpy(box2,"Entertaiment");
		strcpy(box3,"Exit");
	}
	if(y==2)
	{
		strcpy(box1,"Enter a new employee");
		strcpy(box2,"Stored data");
		strcpy(box3,"Back to menu");
	}
	if(y==3)
	{
		strcpy(box1,"Snake the game");
		strcpy(box2,"Typemaster");
		strcpy(box3,"Back to menu");
	}
	if(y==4)
	{
		strcpy(box1,"Read stored data");
		strcpy(box2,"Change a employee");
		strcpy(box3,"Back");
	}
	if(y==5)
	{
		strcpy(box1,"Delete a employee");
		strcpy(box2,"Modify a employee");
		strcpy(box3,"Back");
	}
	if(y==6)
	{
		strcpy(box1,"Play");
		strcpy(box2,"Scores");
		strcpy(box3,"Back");
	}
	outtextxy(120,120,box1);
	rectangle(100,100,400,150);
	outtextxy(120,270,box2);
	rectangle(100,250,400,300);
	outtextxy(120,420,box3);
	rectangle(100,400,400,450);
	setfillstyle(1,RED);
	if(x==1)
	{
		floodfill(250,129,WHITE);
	}
	if(x==2)
	{
		floodfill(250,279,WHITE);
	}
	if(x==3)
	{
		floodfill(250,429,WHITE);
	}
	return 0;
}
//...............................MENU.FOR.SNAKE......................................................
void mf::snakemenu()
{
	cleardevice();
	chosen=1;
	writeup=6;
	int value4=1;
	make(chosen,writeup);
	while(1)
	{
		a=getch();
		if(a=='w')
		{
			if(chosen>1)
				chosen--;
			make(chosen,writeup);
			value4=1;
		}
		if(a=='s')
		{
			if(chosen<3)
				chosen++;
			make(chosen,writeup);
			value4=1;
		}
		if(a==' ')
		{
			if(chosen==1)
			{
				cleardevice();
				fsnake();
				chosen=1;
				writeup=6;
			      //	break;
			      value4=1;
			}
			if(chosen==2)
			{
				cleardevice();
				cout<<"scores"<<endl;
				highsnake();
				chosen=2;
				writeup=6;
			      //	break;
			      value4=1;
			}
			if(chosen==3)
			{
				value4=0;
			}
		}
		if(value4==1)
			continue;
		if(value4==0)
			break;
	}
}
//..................................................................................
void mf::data() //***password
{
	cleardevice();
	chosen=1;
	writeup=4;
	
	int value2=1;
	make(chosen,writeup);
	while(1)
	{
		make(chosen,writeup);
		a=getch();
		if(a=='w')
		{
			if(chosen>1)
				chosen--;
			make(chosen,writeup);
			value2=1;
		}
		if(a=='s')
		{
			if(chosen<3)
				chosen++;
			make(chosen,writeup);
			value2=1;
		}
		
		if(a==' ')
		{
			if(chosen==1)
			{
				cleardevice();
				display();
			      //	break;
			      value2=1;
			}
			if(chosen==2)
			{   //password interface for opening 
				cleardevice();
				char pas[5];
				int pl=3;
				while(1)
				{
					clrscr();
					if(pl>0)
					{
						cleardevice();
						if(pl==3)
							setcolor(GREEN);
						if(pl==2)
							setcolor(YELLOW);
						if(pl==1)
							setcolor(RED);
						outtextxy(0,80,"enter password");
						cout<<"\n\n\n\n\n\n\n";
						for(int i=0;i<5;i++){
							if(i==0){
								cout<<" ";
								setcolor(WHITE);
								rectangle(0,100,300,130);
							}
							pas[i]=getch();
							cout<<'*';
						}
					}
					outtextxy(0,140,"loading");
					sleep(1);
					outtextxy(60,140,".");
					sleep(1);
					outtextxy(67,140,".");
					sleep(1);
					outtextxy(74,140,".");
					sleep(1);
					outtextxy(81,140,".");
					sleep(1);
					
					if(pas[0]=='1' && pas[1]=='2' && pas[2]=='3' && pas[3]=='4' && pas[4]=='5'){
						modify();
						pl=3;
					}
					else{
					    pl-=1;
					}
					
					if(pl<3 && pl>0)
					{
						clrscr();
						cleardevice();
						cout<<endl<<"\t\twrong password"<<endl;
						cout<<endl<<"you have "<<pl<<"chances remaining"<<endl;
						getch();
					}
					else if(pl==0)
					{
						clrscr();
						cleardevice();
						cout<<endl<<"no chances remaining"<<endl;
						getch();
						break;
					}
                    else if(pl==3)
						break;
				}
				chosen=1;
				writeup=4;
				value2=1;
			}
			if(chosen==3)
			{
				value2=0;
			}
		}
		if(value2==1)
			continue;
		if(value2==0)
			break;
	}
}
//................................MODIFICATION...........................................................
void mf::modify()
{
	cleardevice();
	chosen=1;
	writeup=5;
	int value3=1;
	make(chosen,writeup);
	while(1)
	{
		make(chosen,writeup);
		a=getch();
		if(a=='w')
		{
			if(chosen>1)
				chosen--;
			make(chosen,writeup);
			value3=1;
		}
		if(a=='s')
		{
			if(chosen<3)
				chosen++;
			make(chosen,writeup);
			value3=1;
		}
		if(a==' ')
		{
			if(chosen==1)
			{
				cleardevice();
				deletion();
			      //	break;
			      value3=1;
				getch();
			}
			if(chosen==2)
			{
				cleardevice();
				modification();
			      //	break;
			      value3=1;
				 getch();
			}
			if(chosen==3)
			{
				value3=0;
			}
		}
		if(value3==0)
			break;
		if(value3==1)
			continue;
	}
}
//.................................STORAGE.....................................................
void mf::storage()
{
	cleardevice();
	chosen=1;
	writeup=2;
	int value1=1;
	make(chosen,writeup);
	while(1)
	{
		make(chosen,writeup);
		a=getch();
		if(a=='w')
		{
			if(chosen>1)
				chosen--;
			make(chosen, writeup);
			value1=1;
		}
		if(a=='s')
		{
			if(chosen<3)
				chosen++;
			make(chosen,writeup);
			value1=1;
		}
		if(a==' ')
		{
			if(chosen==1)
			{
				cleardevice();
				addition();
				value1=1;
			      //	break;
			}
			if(chosen==2)
			{
				cleardevice();
				data();
				chosen=1;
				writeup=2;
				value1=1;
			      //	break;
			}
			if(chosen==3)
			{
				value1=0;
			}
		}
		if(value1==0)
			break;
		if(value1==1)
			continue;
	}
}
//.................................ENTERTAINMENT...................................................
void mf::ent()
{
	cleardevice();
	chosen=1;
	writeup=3;
	cout<<"welcome to ent.."<<endl;
	make(chosen,writeup);
	while(1)
	{
		make(chosen,writeup);
		a=getch();
		if(a=='w')
		{
			if(chosen>1)
				chosen--;
			make(chosen,writeup);
		}
		if(a=='s')
		{
			if(chosen<3)
				chosen++;
			make(chosen,writeup);
		}
		if(a==' ')
		{
			if(chosen==1)
			{
				cleardevice();
				snakemenu();
			      //	break;
			}
			if(chosen==2)
			{
				cleardevice();
				typemaster();
			      //	break;
			}
			if(chosen==3)
			{
				return;
			}
		}
	}
}
//.................................TYPEMASTER.......................................................
void mf::typemaster()
{
	closegraph();
	clrscr();
	int le=0;
	clock_t start,end;
	char wl[38],cl[38];
	strcpy(cl,"the quick fox jumped over the lazy dog");
	cout<<"\t\t\twelcome to the type master";
	cout<<endl<<endl<<"start writting the given paragraph right after pressing any key"<<endl;
	getch();
	cout<<"\n\n\n"<<cl<<"\n\n";
	start=clock();
	gets(wl);
	end=clock();
	cout<<endl<<"\t\t\t\tloading";
	for(int i=0;i<3;i++)
	{
		sleep(1);
		cout<<'.';
	}
	for(int j=0;j<38;j++)
	{
		if(wl[j]!=cl[j])
			le++;
	}
	clreol();
	cout<<endl<<"your time was "<<(end-start)/CLK_TCK<<" seconds"<<endl;
	cout<<"no. of incorrect words are "<<le;
	getch();
	int gdriver=DETECT, gmode;
	initgraph(&gdriver, &gmode, "C:\\TC\\BGI");
}
//...................................MENU.....................................................
int mf::menu()
{
	int flag=1;  // if 0 then we exit out of the loop
	make(chosen, writeup);
	a=getch();
	if(a=='w')
	{
		if(chosen>1){
			chosen--;
		}
		make(chosen, writeup);
	}
	else if(a=='s')
	{
		if(chosen<3){
			chosen++;
		}
		make(chosen, writeup);
	}
	else if(a==' ')
	{
		if(chosen==1)
		{
			storage();
			
			chosen=1;
			writeup=1;
		}
		else if(chosen==2)
		{
			ent();
			
			chosen=1;
			writeup=1;
		}
		else if(chosen==3)
		{
			cleardevice();
			setcolor(LIGHTBLUE);
			settextstyle(1,0,1);
			outtextxy(100,100,"thankyou");
			flag=0;
			getch();
		}
	}
	if(flag==0)
		return 0;
	else
		return 1;
}
//..................................................................................
void mf::body()   // ****imp func****
{
	chosen=1;
	writeup=1;
	
	int flag=0; // 4. to exit out of the menu 
	controls();
	while(1)
	{
	       flag=menu();
	       if(flag==0)
			break;
	}
}

//#################################-SNAKE-#####################################//
//DONE :)
class snake
{
    private:
	    int xf[16];
	    int yf[16];
	    int f[16];

    public:
        
        int x;
	    int y;
	    int k;
        snake(){
		    x=100;
		    y=100;
		    k=0;
		    accfood();
	    }
	   
	    void snkcontrols();
	    void accfood();

	    void move(char);
	    int food(int,int);
    
};
//................................................................................
void snake:: accfood(){

	srand(time(0));
    int i=0;
	for (i=0 ;i<16 ;i++){
		xf[i]=(1+(rand()%18))*25;
		yf[i]=(1+(rand()%18))*25;
		f[i]=0;
	}
}
//................................................................................
int snake:: food(int x,int y){
	int flag=0;
	for(int i=0;i<16;i++){
		if(f[i]==0){
		    setcolor(RED);
		    setfillstyle(1,RED);
			circle( xf[i], yf[i], 3);
			floodfill(xf[i],yf[i],RED);
		}
	}
	setcolor(WHITE);
	
	for(i=0;i<16;i++){
		if(x==xf[i] && y==yf[i] && f[i]!=1){
			f[i]=1;
			flag++;
			k++;
		}
	}
	return flag;
}
//................................................................................
void snake::move(char dir){
    
	if(dir=='0'){
	    return;
	}
	
	if(dir=='w'){
		
		if(x>0&&y>0){
		    x=x;
			y=y-5;
		}
	}
	else if(dir=='s'){
		
		if(x<getmaxx()&&y<getmaxy()){
			x=x;
			y=y+5;
		}
	}
	else if(dir=='a'){
		if(x>0&&y>0){
			x=x-5;
			y=y;
		}
	}
	else if(dir=='d'){
		if(x<getmaxx()&&y<getmaxy()){
			x=x+5;
			y=y;
		}
	}
	
	setcolor(WHITE);
	rectangle(x-5,y-5,x+5,y+5);
	setfillstyle(1,GREEN);
	floodfill(x,y,WHITE);
	
	//delay(10);
	return;
}
//................................................................................
class snakeinfo{
    public:
	    char sname[20];
	    int stime;
	    
	    void display()
	    {
		    cout<<" * "<<sname<<"\t"<<stime<<" sec"<<endl;
	    }
};
//.................................................................................
void highsnake()
{
    snakeinfo snk_info;
    
	snk_file.open("snk.dat",ios::in|ios::binary);
	cout<<" NAMES            TIME          "<<endl;
	while(snk_file.read((char*)&snk_info,sizeof(snk_info)))
	{
		snk_info.display();
	}
	snk_file.close();
}
//..................................................................................
void snake::snkcontrols()
{
	cleardevice();
	setbkcolor(DARKGRAY);
	settextstyle(6,0,0);
	setcolor(YELLOW);
	outtextxy(50,50,"1. use W to move up");
	outtextxy(50,100,"2. use s to move down");
	outtextxy(50,150,"3. use A to move left");
	outtextxy(50,200,"4. use D to move right");
	outtextxy(50,250,"5. EAT ALL the apples to finish");
	outtextxy(50,300,"6. the time starts just after the controls");
	settextstyle(0,0,1);
	outtextxy(400,400,"press any key to continue...");
	getch();
}


//##################################-MAIN FUNCTION-############################//
void main()
{       //small main func.//
	int gdriver=DETECT, gmode;
	initgraph(&gdriver, &gmode, "C:\\TC\\BGI");
	mf m1;
	m1.body();
	closegraph();
}
//#######################-USER DEFINED FUNCTIONS_###############################
void modification()
{
	closegraph();
	char ch2;
	int tempid1;
	int modidno;
	tempid1=idgen();
	file.open("employee.dat",ios::in|ios::binary);
	file3.open("temp.dat",ios::out|ios::binary);
	cout<<"enter the employee no. to modify"<<endl;
	cin>>modidno;
	while(file.read((char*)&e1,sizeof(e1)))
	{
		file.read((char*)&e1,sizeof(e1));
		if(modidno!=e1.idno)
		{
			file3.write((char*)&e1,sizeof(e1));
		}
		if(modidno==e1.idno)
		{
			e1.display_str();
			cout<<"is this the employee you want to modify"<<endl;
			cin>>ch2;
			ch2=tolower(ch2);
			if(ch2=='n')
			{
				file3.write((char*)&e1,sizeof(e1));
			}
			if(ch2=='y')
			{
				cout<<"enter changed data"<<endl;
				e1.idno=tempid1;
				cout<<"id no. of new employee is"<<e1.idno<<endl;
				e1.dateval();
				cout<<"Enter your name"<<endl;
				gets(e1.name);
			}
		}
	}
	file.close();
	file3.close();
	remove("employee.dat");
	rename("temp.dat","employee.dat");
	file.open("employee.dat",ios::in|ios::binary);
	cout<<"IDNO"<<"\tNAME"<<"\t\tDATE OF JOINING"<<endl;
	while(file.read((char*)&e1,sizeof(e1)))
	{
		e1.display_str();
	}
	file.close();
	int gdriver=DETECT, gmode;
	initgraph(&gdriver, &gmode,"C:\\TC\\BGI");
}
//..............................................................................
void search()
{
	closegraph();
	int f=1;
	int seaidno;
	clrscr();
	file.open("employee.dat",ios::in|ios::binary);
	cout<<"Enter the idno of the record to be searched"<<endl;
	cin>>seaidno;
	while(file.read((char*)&e1,sizeof(e1)))
	{
		file.read((char*)&e1,sizeof(e1));
		if(seaidno==e1.idno)
		{
			f=0;
			cout<<"The record is present "<<endl;
			getch();							clrscr();
			cout<<"IDNO"<<"\tNAME"<<"\t\tDATE OF JOINING"<<endl;
			e1.display_str();
		}
	}
	if(f==1)
	{
		cout<<"record not found"<<endl;
	}
	int gdriver=DETECT, gmode;
	initgraph(&gdriver, &gmode, "C:\\TC\\BGI");
}
//....................................................................................
void deletion()
{
	closegraph();
	char ch1;
	int delidno;
	cout<<"enter the employee no. of the employee to be deleted"<<endl;
	cin>>delidno;
	file.open("employee.dat",ios::in|ios::binary);
	file2.open("temp.dat",ios::out);
	while(!file.eof())
	{
		file.read((char*)&e1,sizeof(e1));
		if(delidno==e1.idno)
		{
			e1.display_str();
			cout<<"is this the employee you want to delete"<<endl;
			cin>>ch1;
			tolower(ch1);
			if(ch1=='y')
			{
				cout<<"employee deleted"<<endl;
			}
			if(ch1=='n')
			{
				file2.write((char*)&e1,sizeof(e1));
			}
		}
		if(delidno!=e1.idno)
		{
			file2.write((char*)&e1,sizeof(e1));
		}
	}
	file.close();
	file2.close();
	remove("employee.dat");
	rename("temp.dat","employee.dat");
	file.open("employee.dat",ios::in);
	cout<<"displaying data"<<endl;
	cout<<"IDNO"<<"\tNAME"<<"\t\tDATE OF JOINING"<<endl;
	while(file.read((char*)&e1,sizeof(e1)))
	{
		file.read((char*)&e1,sizeof(e1));
		e1.display_str();
	}
	file.close();
	getch();
	int gdriver=DETECT, gmode;
	initgraph(&gdriver, &gmode, "C:\\TC\\BGI");
}
//..................................................................................
void display()
{
	closegraph();
	clrscr();
	file.open("employee.dat",ios::in|ios::binary);
	cout<<"IDNO"<<"\tNAME"<<"\t\tDATE OF JOINING"<<endl;
	while(file.read((char*)&e1,sizeof(e1)))
	{
		e1.display_str();
	}
	file.close();
	getch();
	int gdriver=DETECT, gmode;
	initgraph(&gdriver, &gmode, "C:\\TC\\BGI");
}
//.........................................................................................
void addition()
{
	closegraph();
	int tempid;
	tempid=idgen();
	file.open("employee.dat",ios::app|ios::binary);
	e1.idno=tempid;
	cout<<"your id number is"<<e1.idno<<endl;
	e1.dateval();
	cout<<"Enter your name"<<endl;
	gets(e1.name);
	file.write((char*)&e1,sizeof(e1));
	cout<<"record added"<<endl;
	file.close();
	int gdriver=DETECT, gmode;
	initgraph(&gdriver, &gmode, "C:\\TC\\BGI");
}
//..................................................................................
int idgen()
{
	int g;
	file.open("employee.dat",ios::in||ios::binary);
	while(file.read((char*)&e1,sizeof(e1)))
	{
		file.read((char*)&e1,sizeof(e1));

		g=e1.idno+1;
	}
	file.close();
	return g;
}
//.................................................................................
void controls()
{
	setbkcolor(DARKGRAY);
	settextstyle(6,0,0);
	setcolor(YELLOW);
	outtextxy(50,100,"1. use W to switch to option given above");
	outtextxy(50,200,"2. use S to switch to option given below");
	outtextxy(50,300,"3. use spacebar to choose given option");
	settextstyle(0,0,1);
	outtextxy(400,400,"press any key to continue...");
	getch();
}
//.....................................................................................
void fsnake() //:)
{
    snake s1;
    snakeinfo snk_info;
    
	s1.snkcontrols();
	cleardevice();
	
	setbkcolor(BLACK);
	setcolor(GREEN);
	circle(s1.x, s1.y,3);
	setfillstyle(1,GREEN);
	floodfill(s1.x,s1.y,GREEN);
	
	int time=0;
	
	clock_t start,end;
	start=clock();
	char ch;
	
	int steps=0;
	int px[21],py[21];
	while(1)
	{
	    
		ch=getch();
		
		cleardevice();
		px[steps%(5+s1.k)]=s1.x;
        py[steps%(5+s1.k)]=s1.y;
        steps++;
		s1.move(ch);
 		s1.food(s1.x, s1.y);
		
		setcolor(GREEN);
		for(int j=0; j<(5+s1.k);j++){
	        circle(px[j],py[j],3);
	        setfillstyle(1,GREEN);
	        floodfill(px[j],py[j],GREEN);
		}
		
		if(s1.k==16)
			break;
	}
	end=clock();
	cleardevice();
	
	time=(end-start)/CLK_TCK;
	cout<<endl<<"your time was "<<time<<" seconds"<<endl;
	
	snk_file.open("snk.dat",ios::app|ios::binary);
	snk_info.stime=time;
	
	cout<<"enter your name"<<endl;
	gets(snk_info.sname);
	snk_file.write( (char*)&snk_info, sizeof(snk_info) );
	snk_file.close();
	
	snk_file.open("snk.dat",ios::in|ios::binary);
	while( snk_file.read( (char*)&snk_info, sizeof(snk_info) )){
		snk_file.read((char*)&snk_info,sizeof(snk_info));
		snk_info.display();
	}
	snk_file.close();
}

//#############################-END OF PROGRAM-#####################################







