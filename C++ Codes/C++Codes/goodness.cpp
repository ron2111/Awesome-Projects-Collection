#include <bits/stdc++.h>
using namespace std;
 
#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define endl "\n"
#define int long long

const int N = 2*1e5 + 5;

int n, k;
char s[N];
int t=0;
int32_t main()
{
    //IOS;
	cin >> t;
    int tc = 0 ; 
	while(t--)
	{
		tc++;
        cin >> n >> k;
        cin >> s ;
        int ans = 0 ;
        int goodness= 0 ;
        for(int i = 0 ; i<=(n-1)/2 ;i++)
        {
            if(s[i] != s[n-i-1])
            {
                goodness++;
            }
        }
        if(goodness == k)
        {
            ans = 0 ;
        }
        else if(goodness > k)
        {
            ans = goodness -k;
        }
        else
        {
            ans = k-goodness;
        }
		
		cout << "Case #" << tc << ": " <<ans<<  endl;
 	}	
	return 0;
}
