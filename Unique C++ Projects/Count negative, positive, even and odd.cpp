#include<iostream>
#include<cstdio>
#include<cmath>
using namespace std;
int main(){
  int arr[10],i;
  int pos=0,neg=0,odd=0,even=0;
  for(i=0;i<10;i++){
    cin>>arr[i];
  }
  for(i=0;i<10;i++){
    if(arr[i]>=0){
      pos++;
    }
    if(arr[i]<0){
      neg++;
    }
    if(arr[i]%2==0){
      even++;
    }
    else{
      odd++;
    }
  }
  cout<<pos<<endl;
  cout<<neg<<endl;
  cout<<even<<endl;
  cout<<odd;
  return 0;
}
