// Include all the necessary libraries.
/*#include <fstream>
#include <iostream>
#include <stdio.h>
#include <string.h>
#include <iomanip>*/
#include<bits/stdc++.h>
void WelcomeScreen(void)//function for welcome screen
{
printf("\n\n\n\n\n\n\n\t\t\t\t#########################################");
printf("\n\t\t\t\t#\t\t WELCOME  TO\t\t#");
printf("\n\t\t\t\t\t      #  PSIT Portal  #");
printf("\n\t\t\t\t#########################################");
printf("\n\n\n\n\n Press Enter key to continue......\n");
char temp;
fflush(stdin);
scanf("%c",&temp);
system("cls");//Use to clear screen
}
using namespace std;

int main()
{
// Considering the max length of data entered (name) to
// be 15.
WelcomeScreen();
system("color E2");
char regNo[15],name[15],data[15];
int n = 0, option = 0, count_n = 0;
// This is the initial mark alloted to a subject.
string empty = "00";
string proctor = "";
// Name of the file in which DB is stored.
ifstream f("Example.txt");
string line;

// The following for loop counts the total number of
// lines in the file.
for (int i = 0; std::getline(f, line); ++i) {
count_n++;
}

while (option != 6) {
// This prints out all the available options in the
// DB
system("cls");
cout<<setw(1030);
cout << "Available operations: "<<endl;
cout<<setw(67);
cout<<"1. Add New Students" <<endl;
cout<<setw(64);
cout<<"2. Student Login"<<endl;
cout<<setw(64);
cout<<"3. Faculty Login"<<endl;
cout<<setw(64);
cout<<"4. Proctor Login"<<endl;
cout<<setw(61);
cout<<"5. Admin View"<<endl;
cout<<setw(55);
cout<<"6. Exit"<<endl<<endl;
cout<<setw(61);
cout<<"Enter option: ";
cin >> option;

if (option == 1) {
system("cls");
cout << "Enter the number of students: ";
cin >> n;

count_n = count_n + n;

for (int i = 0; i < n; i++) {
FILE *fp;
fp=fopen("Example.txt","a");

cout << "Enter your registration number: ";
cin >> regNo;

cout << "Enter your name: ";
cin >> name;
int len = strlen(name);

while (len < 15) {
name[len] = ' ';
len = len + 1;
}

cout << "Enter your proctor ID: ";
cin >> proctor;
fprintf(fp,"%s %s %s %s %s\n",regNo,name,empty.c_str(),empty.c_str(),proctor.c_str() );
    printf("\n\n\t\t\t.... Information Record Successful ...");
    fclose(fp);
/*ofstream outfile;
outfile.open("Example.txt", ios::app);
// The entire data of a single student is
// stored line-by-line.
cout << "Enter your registration number: ";
cin >> data;
outfile << data <<"\t";

cout << "Enter your name: ";
cin >> data;
int len = strlen(data);

while (len < 15) {
data[len] = ' ';
len = len + 1;
}
outfile << data << "\t";
// Inserting empty data initially into the
// file
outfile << empty << "\t";
outfile << empty << "\t";

cout << "Enter your proctor ID: ";
cin >> proctor;

outfile << proctor <<"\n";*/
cout<<"Press Enter key to continue..!";
char temp;
fflush(stdin);
scanf("%C",&temp);
}
}

else if (option == 2) {
system("cls");
char regno[9];
cout << "Enter your registration number: ";
cin >> regno;
ifstream infile;
int check = 0;
infile.open("Example.txt", ios::in);

// This loop prints out the data according to
// the registration number specified.
while (infile >> data) {
if (strcmp(data, regno) == 0) {
cout
<< "\nRegistration Number: " << data
<< endl;
infile >> data;
cout << "Name: " << data << endl;

infile >> data;
cout << "KCS301 mark: " << data
<< endl;

infile >> data;
cout << "KCS302 mark: " << data
<< endl;

infile >> data;
cout << "Proctor ID: " << data << endl;

infile.close();
check = 1;
}
}

if (check == 0) {
//system("color 47");
cout << "No such registration number found!"
<< endl;
}
cout<<"Press Enter key to continue..!";
char temp;
fflush(stdin);
scanf("%C",&temp);
}

// This loop is used to view and add marks to the
// database of a student.
else if (option == 3) {
system("Cls");
char subcode[7];
cout << "Enter your subject code: ";
cin >> subcode;
string code1 = "KCS301", code2 = "KCS302",
mark = "";
ifstream infile;
int check = 0;

cout << "\nAvailable operations: \n1. Add data "
"about marks\n"
<< "2. View data\nEnter option: ";
cin >> option;

if (option == 1) {
cout
<< "Warning! You would need to add mark"
<< "details for all the students!"
<< endl;
for (int i = 0; i < count_n; i++) {
fstream file("Example.txt");
/*FILE *fp;
fp=fopen("Example.txt","a");*/
// The seek in file has been done
// according to the length
// of the data being inserted. It needs
// to adjusted accordingly for diffferent
// lengths of data.

if (strcmp(subcode, code1.c_str())
== 0) {
file.seekp(26 + (37 * i)+i,
std::ios_base::beg);
// fseek(fp,26 + (37 * i),SEEK_SET);
cout << "Enter the mark of student#"
<< (i + 1) << " : ";
cin >> mark;
//fputs(mark.c_str(),fp);
file.write(mark.c_str(), 2);
}

if (strcmp(subcode, code2.c_str())
== 0) {
//fseek(fp,29 + (37 * i),SEEK_SET);
file.seekp(29 + (37 * i)+i,
std::ios_base::beg);
cout << "Enter the mark of student#"
<< (i + 1) << " : ";
cin >> mark;
//fputs(mark.c_str(),fp);
file.write(mark.c_str(), 2);
}
}

cout<<"Press Enter key to continue..!";
char temp;
fflush(stdin);
scanf("%C",&temp);
//fclose(fp);
}

// This loop is used to view marks of a student.
// The extra infile commands have been used to
// get a specific mark only since the data has
// been seperated by a tabspace.

else if (option == 2) {
infile.open("Example.txt", ios::in);
if (strcmp(subcode, code1.c_str()) == 0) {
cout << "Registration number - Marks\n"
<< endl;
while (infile >> data) {
cout << data;
infile >> data;
infile >> data;
cout << " - " << data << endl;
infile >> data;
infile >> data;
check = 1;
}
}
//fclose(fp);
infile.close();
infile.open("Example.txt", ios::in);

if (strcmp(subcode, code2.c_str()) == 0) {
cout << "Registration number - Marks\n"
<< endl;
while (infile >> data) {
cout << data;
infile >> data;
infile >> data;
infile >> data;
cout << " - " << data << endl;
infile >> data;
check = 1;
}
}

}

infile.close();

if (check == 0) {

cout << "No such subject code found!"
<< endl;
cout<<"Press Enter key to continue..!";
char temp;
fflush(stdin);
scanf("%C",&temp);
}
}

// This loop displays all the details of students
// under the same proctor ID.

else if (option == 4) {
system("cls");
char procid[7];
cout << "Enter your proctor ID: ";
cin >> procid;
int check = 0;
char temp1[100], temp2[100], temp3[100];
char temp4[100], id[100];
ifstream infile;
infile.open("Example.txt", ios::in);

while (infile >> temp1) {
infile >> temp2;
infile >> temp3;
infile >> temp4;
infile >> id;

if (strcmp(id, procid) == 0) {
cout << "\nRegistration Number: "
<< temp1 << endl;
cout << "Name: " << temp2 << endl;
cout << "KCS301 Mark: " << temp3
<< endl;
cout << "KCS302 Mark: " << temp4
<< endl;
check = 1;
}
}

if (check == 0) {
cout << "No such proctor ID found!" << endl;
}
cout<<"Press Enter key to continue..!";
char temp;
fflush(stdin);
scanf("%C",&temp);
}

// This loop acts as an admin view to see all the
// data in the file.

else if (option == 5) {
system("cls");
char password[25];
cout << "Enter the admin password: ";
cin >> password;

// This variable value can be changed according
// to your requirement of the administrator
// password.

string admin_pass = "admin";

if (strcmp(password, admin_pass.c_str()) == 0) {
cout << "Reg No. "
"\tName\tKCS301\tKCS302\tProctor "
"ID"
<< endl;
ifstream infile;
infile.open("Example.txt", ios::in);
char data[20];

while (infile >> data) {
cout << data << "\t";
infile >> data;
cout << data << "\t";
infile >> data;
cout << data << "\t";
infile >> data;
cout << data << "\t";
infile >> data;
cout << data << endl;
}
}
cout<<"Press Enter key to continue..!";
char temp;
fflush(stdin);
scanf("%C",&temp);
}
}
}
