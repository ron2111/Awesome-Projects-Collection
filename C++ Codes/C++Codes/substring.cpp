#include <bits/stdc++.h>
using namespace std;
 
#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define endl "\n"



int n =0; 

int main()
{

    IOS;
	int t;
	cin >> t;
	int tc = 0; 
    
	while(t--)
	{
        tc++;
        int ans = 0 ;
        cin >> n;
        char a[n+1];
        for(int i =0; i<n ; i++)
        {
            cin >>a[i];
        }
        int d[n];
        int inc= 1 ;
        d[0]= 1;
        for(int i =1; i<n ; i++)
        {
            if(a[i-1]<a[i])
            {
                d[i] = inc+1;
                inc++;
            }
            else{
                d[i]= 1;
                inc = 1;
            }

        }
        cout << "Case #" << tc << ": ";
        for(int i : d)
        {
            cout << i<<" ";
        }
        cout<<endl;
    }

}