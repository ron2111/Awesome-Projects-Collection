#include <bits/stdc++.h>
using namespace std;
 
#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define endl "\n"


int main(int argc, char **argv)
{

    IOS;
	int t;
	cin >> t;
	int tc = 0; 
    int ans = 0 ;
	while(t--)
	{
        tc++;
        int n,k,s; 
        cin>>n>>k>>s;

        int diff1 = k-s;
        int diff2 = n-s;
        if(diff1 <=0 )
        {
            ans = n;
        }
        else if(diff1 > s)
        {
            ans = n+k;
        }
        else{
            ans = k + (diff1 + diff2);
        }
        cout << "Case #" << tc << ": " << ans << endl;
    }

}