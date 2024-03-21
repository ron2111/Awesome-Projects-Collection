#include <bits/stdc++.h>
using namespace std;
 
#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define endl "\n"
//#define int long long




int count(int x, int y)
{
    if(x == 1 || y == 1 || x==0|| y==0)
    {
        return 0;
    }
	return( min(x/2 , y) + min(y/2 , x) -2);
}

void topLeft(int** top, int** left , int r , int c , int** matrix)
{
	for(int i = 1 ; i<=r ; i++ )
	{
		for(int j = 1; j<= c;j++)
		{
			if(matrix[i][j] == 0)
			{
				continue;
			}
			top[i][j] = top[i -1][j] +1;
			left[i][j] = left[i][j-1] +1;
		}
	}
}

void bottomRight(int** bottom, int** right , int r , int c , int** matrix)
{
	for(int i = r ; i>=1 ; i-- )
	{
		for(int j = c; j>=1 ;j--)
		{
			if(matrix[i][j] == 0)
			{
				continue;
			}
			bottom[i][j] = bottom[i+1][j] +1;
			right[i][j] = right[i][j+1] +1;
		}
	}
}

int main(int argc, char **argv)
{

    IOS;
	int t;
	cin >> t;
	int tc = 0; 
	while(t--)
	{
    tc++;
	int r = 0 ;
    int c  = 0;
	cin >>r>>c;
    int row = r+5;
    int col = c+5; 
    int** matrix = new int*[row];
    int** top = new int*[row];
    int** bottom = new int*[row];
    int** right = new int*[row];
    int** left = new int*[row];
	for(int i =0 ; i<= row ; i++)
    {
        matrix[i] = new int[col];
        top[i] = new int[col];
        bottom[i] = new int[col];
        right[i] = new int[col];
        left[i] = new int[col];
    }
	for (int i = 1 ; i <=r ; i++)
	{
		for (int j=1 ; j<=c ; j++)
		{
			cin >> matrix[i][j];
		}
	}

    for(int i = 0 ; i<= c ;i++)
    {
        //cout<< "failed here"<<endl;
        top[1][i] = 0 ;
        bottom[r][i] = 0 ;
    }

    for(int i = 0 ; i<= r ;i++)
    {
        //cout<< "failed here1"<<endl;
        left[i][1] = 0 ;
        right[i][c] = 0 ;
    }


    topLeft( top ,  left ,  r ,  c , matrix);
    // cout<<"top \n";
    // for (int i = 1 ; i <=r ; i++)
	// {
	// 	for (int j=1 ; j<=c ; j++)
	// 	{
	// 		cout << top[i][j] <<"\t";
	// 	}
    //     cout <<endl;
	// }
    // cout<<"left \n";
    // for (int i = 1 ; i <=r ; i++)
	// {
	// 	for (int j=1 ; j<=c ; j++)
	// 	{
	// 		cout << left[i][j] <<"\t";
	// 	}
    //     cout <<endl;
	// }
     bottomRight(bottom ,  right ,  r ,  c , matrix);

    
    // cout<<"bottom \n";
    // for (int i = 1 ; i <=r ; i++)
	// {
	// 	for (int j=1 ; j<=c ; j++)
	// 	{
	// 		cout << bottom[i][j] <<"\t";
	// 	}
    //     cout <<endl;
	// }
    // cout<<"right \n";
    // for (int i = 1 ; i <=r ; i++)
	// {
	// 	for (int j=1 ; j<=c ; j++)
	// 	{
	// 		cout << right[i][j] <<"\t";
	// 	}
    //     cout <<endl;
	// }

    int ans = 0;
    for(int i = 1 ; i<=r ; i++ )
    {
        for (int j =1 ; j<=c ;j++ )
        {
            
            //cout<< "i"<< i << "j"<< i <<top[i][j]<< right[i][j] <<" "<<count(top[i][j],right[i][j])<<endl;
            ans =ans+ count(top[i][j],left[i][j]) + count(top[i][j],right[i][j]) +count(bottom[i][j],left[i][j]) +count(bottom[i][j],right[i][j]);
        }
    }
        cout << "Case #" << tc << ": " << ans << endl;
 	}	
	return 0 ; 
}
