#include <bits/stdc++.h>
using namespace std;
 
#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define endl "\n"
#define int long long

const int N = 1e5 + 5;

int n, k;
int sessions[N];


int32_t main()
{
	//IOS;
	//cout << "Enter Test Cases"<<endl;
	int t;
	cin >> t;
	int tc = 0; 
	while(t--)
	{
		tc++;
		//cout << "Enter sessions and additional sessions "<<endl;
		cin >> n >>k;
		for(int i = 1; i <=n; i++ )
		{
			cin >> sessions[i];
		}
		
		int ksum = 0 ; 
		int low = 1 ; 
		int high = 1e9;
		int mid = (high + low)/2;
		
		while(low < high)
		{
			mid = (high + low)/2;
			int tdoptimal = mid;
			ksum =0 ;
			for(int i = 1 ; i<n ; i++)
			{
			    int diff = sessions[k+1] - sessions[k];
				ksum = ksum + (diff-1)/tdoptimal;
				if(ksum > i)
				{
					low= mid +1;
					break;	
				}
			}
			if(ksum <= k)
			{
				high = mid;
			}
		}
		cout << "Case #" << tc << ": " << low <<  endl;
 	}	
	return 0;
}
