#include <bits/stdc++.h>
using namespace std;
 
 int main()
 {
 
 int packSize;
 int maxWeight = 0 ;
  cout<< "Enter the max weight to carry \n";
 cin>> maxWeight;
 cout<< "Enter the packSize"<< "\n";
 cin>> packSize;

 int *weights = new int[packSize];
 int *values = new int[packSize];
  

 cout << "Enter weights\n";

  for(int i =0 ; i< packSize ; i++)
  {
      cin >> weights[i];
  } 
   cout << "Enter values\n";
  for(int i =0 ; i< packSize ; i++)
  {
      cin >> values[i];
  } 
  int** dp = new int*[packSize+1];
  
    for (int i = 0; i <=packSize; i++) { 
  
        // Declare a memory block 
        // of size n 
        dp[i] = new int[maxWeight+1]; 
    } 

 for(int i =0 ; i<=packSize;i++)
 {
     for(int j =0 ; j<=maxWeight ; j++)
     {
         dp[i][j] = 0 ;
     }
 }

 for(int i =1 ; i<=packSize ; i++)
 {
     for(int j =0 ; j<=maxWeight ; j++)
     {
         dp[i][j] = dp[i-1][j];
         if(weights[i] <= j)
         {
            dp[i][j] = max(dp[i][j] , values[i]+dp[i - 1][j - weights[i]]);
         }
         
     }
     
 }
  for(int i =0 ; i<=packSize;i++)
 {
     for(int j =0 ; j<=maxWeight ; j++)
     {
         cout << dp[i][j]<<" ";
     }
     cout<<"\n";
 }
 
 
 return 0;
 }
