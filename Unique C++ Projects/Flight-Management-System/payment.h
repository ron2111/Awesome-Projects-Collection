#include<iostream>
#include<string.h>
using namespace std;

int payment;

int lpayment(char origin[30], char destination[30]){
	
if((strcmp(origin,"KARACHI")==0)||(strcmp(origin,"LAHORE")==0)&&(strcmp(destination,"KARACHI")==0)||(strcmp(destination,"LAHORE")==0))
	return payment=20000;
else if((strcmp(origin,"KARACHI")==0)||(strcmp(origin,"ISLAMABAD")==0)&&(strcmp(destination,"KARACHI")==0)||(strcmp(destination,"ISLAMABAD")==0))
	return payment=23927;
else if((strcmp(origin,"KARACHI")==0)||(strcmp(origin,"PESHAWAR")==0)&&(strcmp(destination,"KARACHI")==0)||(strcmp(destination,"PESHAWAR")==0))
	return payment=10101;
else if((strcmp(origin,"KARACHI")==0)||(strcmp(origin,"QUETTA")==0)&&(strcmp(destination,"KARACHI")==0)||(strcmp(destination,"QUETTA")==0))
	return payment=10101;
else if((strcmp(origin,"LAHORE")==0)||(strcmp(origin,"ISLAMABAD")==0)&&(strcmp(destination,"LAHORE")==0)||(strcmp(destination,"ISLAMABAD")==0))
	payment=33930;
else if((strcmp(origin,"LAHORE")==0)||(strcmp(origin,"PESHAWAR")==0)&&(strcmp(destination,"LAHORE")==0)||(strcmp(destination,"PESHAWAR")==0))
	return payment=60000;
else if((strcmp(origin,"LAHORE")==0)||(strcmp(origin,"QUETTA")==0)&&(strcmp(destination,"LAHORE")==0)||(strcmp(destination,"QUETTA")==0))
	return payment=93798;
else if((strcmp(origin,"ISLAMABAD")==0)||(strcmp(origin,"PESHAWAR")==0)&&(strcmp(destination,"ISLAMABAD")==0)||(strcmp(destination,"PESHAWAR")==0))
	return payment=73702;
else if((strcmp(origin,"ISLAMABAD")==0)||(strcmp(origin,"QUETTA")==0)&&(strcmp(destination,"ISLAMABAD")==0)||(strcmp(destination,"QUETTA")==0))
	return payment=22542;
}

int ipayment(char origin[30], char destination[30]){
	
if((strcmp(origin,"LONDON")==0)||(strcmp(origin,"BERLIN")==0)&&(strcmp(destination,"LONDON")==0)||(strcmp(destination,"BERLIN")==0))
	        return payment=17049;
else if((strcmp(origin,"LONDON")==0)||(strcmp(origin,"DUBAI")==0)&&(strcmp(destination,"LONDON")==0)||(strcmp(destination,"DUBAI")==0))
	        return payment=24112;
else if((strcmp(origin,"LONDON")==0)||(strcmp(origin,"RIYADH")==0)&&(strcmp(destination,"LONDON")==0)||(strcmp(destination,"RIYADH")==0))
	        return payment=48345;
else if((strcmp(origin,"LONDON")==0)||(strcmp(origin,"BEIJING")==0)&&(strcmp(destination,"LONDON")==0)||(strcmp(destination,"BEIJING")==0))
	        return payment=70568;
else if((strcmp(origin,"LONDON")==0)||(strcmp(origin,"PARIS")==0)&&(strcmp(destination,"LONDON")==0)||(strcmp(destination,"PARIS")==0))
	        return payment=11645;
else if((strcmp(origin,"LONDON")==0)||(strcmp(origin,"CANBERRA")==0)&&(strcmp(destination,"LONDON")==0)||(strcmp(destination,"CANBERRA")==0))
	        return payment=100931;
else if((strcmp(origin,"LONDON")==0)||(strcmp(origin,"TOKYO")==0)&&(strcmp(destination,"LONDON")==0)||(strcmp(destination,"TOKYO")==0))
	        return payment=47831;
else if((strcmp(origin,"LONDON")==0)||(strcmp(origin,"WASHINGTON")==0)&&(strcmp(destination,"LONDON")==0)||(strcmp(destination,"WASHINGTON")==0))
	        return payment=39271;
else if((strcmp(origin,"LONDON")==0)||(strcmp(origin,"DELHI")==0)&&(strcmp(destination,"LONDON")==0)||(strcmp(destination,"DELHI")==0))
	        return payment=47692;
else if((strcmp(origin,"LONDON")==0)||(strcmp(origin,"ISLAMABAD")==0)&&(strcmp(destination,"LONDON")==0)||(strcmp(destination,"ISLAMABAD")==0))
	        return payment=29530;
else if((strcmp(origin,"BERLIN")==0)||(strcmp(origin,"DUBAI")==0)&&(strcmp(destination,"BERLIN")==0)||(strcmp(destination,"DUBAI")==0))
	        return payment=35067;
else if((strcmp(origin,"BERLIN")==0)||(strcmp(origin,"RIYADH")==0)&&(strcmp(destination,"BERLIN")==0)||(strcmp(destination,"RIYADH")==0))
	        return payment=66964;
else if((strcmp(origin,"BERLIN")==0)||(strcmp(origin,"BEIJING")==0)&&(strcmp(destination,"BERLIN")==0)||(strcmp(destination,"BEIJING")==0))
	        return payment=62527;
else if((strcmp(origin,"BERLIN")==0)||(strcmp(origin,"PARIS")==0)&&(strcmp(destination,"BERLIN")==0)||(strcmp(destination,"PARIS")==0))
	        return payment=4436;
else if((strcmp(origin,"BERLIN")==0)||(strcmp(origin,"CANBERRA")==0)&&(strcmp(destination,"BERLIN")==0)||(strcmp(destination,"CANBERRA")==0))
	        return payment=157902;
else if((strcmp(origin,"BERLIN")==0)||(strcmp(origin,"TOKYO")==0)&&(strcmp(destination,"BERLIN")==0)||(strcmp(destination,"TOKYO")==0))
	        return payment=66270;
else if((strcmp(origin,"BERLIN")==0)||(strcmp(origin,"WASHINGTON")==0)&&(strcmp(destination,"BERLIN")==0)||(strcmp(destination,"WASHINGTON")==0))
	        return payment=131334;
else if((strcmp(origin,"BERLIN")==0)||(strcmp(origin,"DELHI")==0)&&(strcmp(destination,"BERLIN")==0)||(strcmp(destination,"DELHI")==0))
	        return payment=36307;
else if((strcmp(origin,"BERLIN")==0)||(strcmp(origin,"ISLAMABAD")==0)&&(strcmp(destination,"BERLIN")==0)||(strcmp(destination,"ISLAMABAD")==0))
	        return payment=32996;
else if((strcmp(origin,"DUBAI")==0)||(strcmp(origin,"RIYADH")==0)&&(strcmp(destination,"DUBAI")==0)||(strcmp(destination,"RIYADH")==0))
	        return payment=16354;
else if((strcmp(origin,"DUBAI")==0)||(strcmp(origin,"BEIJING")==0)&&(strcmp(destination,"DUBAI")==0)||(strcmp(destination,"BEIJING")==0))
	        return payment=40225;
else if((strcmp(origin,"DUBAI")==0)||(strcmp(origin,"PARIS")==0)&&(strcmp(destination,"DUBAI")==0)||(strcmp(destination,"PARIS")==0))
	        return payment=26104;
else if((strcmp(origin,"DUBAI")==0)||(strcmp(origin,"CANBERRA")==0)&&(strcmp(destination,"DUBAI")==0)||(strcmp(destination,"CANBERRA")==0))
	        return payment=187259;
else if((strcmp(origin,"DUBAI")==0)||(strcmp(origin,"TOKYO")==0)&&(strcmp(destination,"DUBAI")==0)||(strcmp(destination,"TOKYO")==0))
	        return payment=67242;
else if((strcmp(origin,"DUBAI")==0)||(strcmp(origin,"WASHINGTON")==0)&&(strcmp(destination,"DUBAI")==0)||(strcmp(destination,"WASHINGTON")==0))
	        return payment=208149;
else if((strcmp(origin,"DUBAI")==0)||(strcmp(origin,"DELHI")==0)&&(strcmp(destination,"DUBAI")==0)||(strcmp(destination,"DELHI")==0))
	        return payment=527;
else if((strcmp(origin,"DUBAI")==0)||(strcmp(origin,"ISLAMABAD")==0)&&(strcmp(destination,"DUBAI")==0)||(strcmp(destination,"ISLAMABAD")==0))
	        return payment=14939;
else if((strcmp(origin,"RIYADH")==0)||(strcmp(origin,"BEIJING")==0)&&(strcmp(destination,"RIYADH")==0)||(strcmp(destination,"BEIJING")==0))
	        return payment=92061;
else if((strcmp(origin,"RIYADH")==0)||(strcmp(origin,"PARIS")==0)&&(strcmp(destination,"RIYADH")==0)||(strcmp(destination,"PARIS")==0))
	        return payment=51282;
else if((strcmp(origin,"RIYADH")==0)||(strcmp(origin,"CANBERRA")==0)&&(strcmp(destination,"RIYADH")==0)||(strcmp(destination,"CANBERRA")==0))
	        return payment=156525;
else if((strcmp(origin,"RIYADH")==0)||(strcmp(origin,"TOKYO")==0)&&(strcmp(destination,"RIYADH")==0)||(strcmp(destination,"TOKYO")==0))
	        return payment=110079;
else if((strcmp(origin,"RIYADH")==0)||(strcmp(origin,"WASHINGTON")==0)&&(strcmp(destination,"RIYADH")==0)||(strcmp(destination,"WASHINGTON")==0))
	        return payment=86516;
else if((strcmp(origin,"RIYADH")==0)||(strcmp(origin,"DELHI")==0)&&(strcmp(destination,"RIYADH")==0)||(strcmp(destination,"DELHI")==0))
	        return payment=723;
else if((strcmp(origin,"RIYADH")==0)||(strcmp(origin,"ISLAMABAD")==0)&&(strcmp(destination,"RIYADH")==0)||(strcmp(destination,"ISLAMABAD")==0))
	        return payment=40312;
else if((strcmp(origin,"BEIJING")==0)||(strcmp(origin,"PARIS")==0)&&(strcmp(destination,"BEIJING")==0)||(strcmp(destination,"PARIS")==0))
	        return payment=31748;
else if((strcmp(origin,"BEIJING")==0)||(strcmp(origin,"CANBERRA")==0)&&(strcmp(destination,"BEIJING")==0)||(strcmp(destination,"CANBERRA")==0))
	        return payment=86516;
else if((strcmp(origin,"BEIJING")==0)||(strcmp(origin,"TOKYO")==0)&&(strcmp(destination,"BEIJING")==0)||(strcmp(destination,"TOKYO")==0))
	        return payment=32342;
else if((strcmp(origin,"BEIJING")==0)||(strcmp(origin,"WASHINGTON")==0)&&(strcmp(destination,"BEIJING")==0)||(strcmp(destination,"WASHINGTON")==0))
	        return payment=82127;
else if((strcmp(origin,"BEIJING")==0)||(strcmp(origin,"DELHI")==0)&&(strcmp(destination,"BEIJING")==0)||(strcmp(destination,"DELHI")==0))
	        return payment=46897;
else if((strcmp(origin,"BEIJING")==0)||(strcmp(origin,"ISLAMABAD")==0)&&(strcmp(destination,"BEIJING")==0)||(strcmp(destination,"ISLAMABAD")==0))
	        return payment=73810;
else if((strcmp(origin,"PARIS")==0)||(strcmp(origin,"CANBERRA")==0)&&(strcmp(destination,"PARIS")==0)||(strcmp(destination,"CANBERRA")==0))
	        return payment=151674;
else if((strcmp(origin,"PARIS")==0)||(strcmp(origin,"TOKYO")==0)&&(strcmp(destination,"PARIS")==0)||(strcmp(destination,"TOKYO")==0))
	        return payment=39790;
else if((strcmp(origin,"PARIS")==0)||(strcmp(origin,"WASHINGTON")==0)&&(strcmp(destination,"PARIS")==0)||(strcmp(destination,"WASHINGTON")==0))
	        return payment=53712;
else if((strcmp(origin,"PARIS")==0)||(strcmp(origin,"DELHI")==0)&&(strcmp(destination,"PARIS")==0)||(strcmp(destination,"DELHI")==0))
	        return payment=35492;
else if((strcmp(origin,"PARIS")==0)||(strcmp(origin,"ISLAMABAD")==0)&&(strcmp(destination,"PARIS")==0)||(strcmp(destination,"ISLAMABAD")==0))
	        return payment=64964;
else if((strcmp(origin,"CANBERRA")==0)||(strcmp(origin,"TOKYO")==0)&&(strcmp(destination,"CANBERRA")==0)||(strcmp(destination,"TOKYO")==0))
	        return payment=91714;
else if((strcmp(origin,"CANBERRA")==0)||(strcmp(origin,"WASHINGTON")==0)&&(strcmp(destination,"CANBERRA")==0)||(strcmp(destination,"WASHINGTON")==0))
	        return payment=159865;
else if((strcmp(origin,"CANBERRA")==0)||(strcmp(origin,"DELHI")==0)&&(strcmp(destination,"CANBERRA")==0)||(strcmp(destination,"DELHI")==0))
	        return payment=113777;
else if((strcmp(origin,"CANBERRA")==0)||(strcmp(origin,"ISLAMABAD")==0)&&(strcmp(destination,"CANBERRA")==0)||(strcmp(destination,"ISLAMABAD")==0))
	        return payment=140229;
else if((strcmp(origin,"TOKYO")==0)||(strcmp(origin,"WASHINGTON")==0)&&(strcmp(destination,"TOKYO")==0)||(strcmp(destination,"WASHINGTON")==0))
	        return payment=74734;
else if((strcmp(origin,"TOKYO")==0)||(strcmp(origin,"DELHI")==0)&&(strcmp(destination,"TOKYO")==0)||(strcmp(destination,"DELHI")==0))
	        return payment=30199;
else if((strcmp(origin,"TOKYO")==0)||(strcmp(origin,"ISLAMABAD")==0)&&(strcmp(destination,"TOKYO")==0)||(strcmp(destination,"ISLAMABAD")==0))
	        return payment=124022;
else if((strcmp(origin,"WASHINGTON")==0)||(strcmp(origin,"DELHI")==0)&&(strcmp(destination,"WASHINGTON")==0)||(strcmp(destination,"DELHI")==0))
	        return payment=63761;
else if((strcmp(origin,"WASHINGTON")==0)||(strcmp(origin,"ISLAMABAD")==0)&&(strcmp(destination,"WASHINGTON")==0)||(strcmp(destination,"ISLAMABAD")==0))
	        return payment=103989;
else if((strcmp(origin,"DELHI")==0)||(strcmp(origin,"ISLAMABAD")==0)&&(strcmp(destination,"DELHI")==0)||(strcmp(destination,"ISLAMABAD")==0))
	        return payment=36096;
}
