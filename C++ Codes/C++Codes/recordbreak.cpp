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
        int a[n+1];
        for(int i =0; i<n ; i++)
        {
            cin >>a[i];
        }
        
        int recordBreaksCount = 0;
        int previousRecord = 0;
        for(int i = 0; i < n; i++) 
        {
            bool greaterThanPreviousDays = i == 0 || a[i] > previousRecord;
            bool greaterThanFollowingDay = i == n-1 || a[i] > a[i+1];
            if(greaterThanPreviousDays && greaterThanFollowingDay) 
            {
                recordBreaksCount++;
            }
            previousRecord = max(previousRecord, a[i]);
        }

        ans = recordBreaksCount;

        cout << "Case #" << tc << ": "<<ans<<endl;
    }

}