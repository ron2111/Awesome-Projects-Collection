#include <bits/stdc++.h>
using namespace std;
 
#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define endl "\n"



int n =0; 
int k =0; 

int check (int *a)
{
    int c = k ;
    for(int i =0 ; i< k ; i++)
    {
        if(a[i] != c)
        {
            return -1;
        }
        c--;
    }
    return 1;
}
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
        cin >> n >>k; 
        int a[n];
        for(int i =0; i<n ; i++)
        {
            cin >>a[i];
        }
        
        for (int i =0 ; i< n ; i++)
        {
            if (a[i]== k)
            {
                int ct= check(a+i);
                if(ct == 1)
                {
                    ans = ans +1;
                    i = i + k-1;
                }

            }
        }
        cout << "Case #" << tc << ": " << ans << endl;
    }

}