// #include<bits/stdc++.h>

// int main() {
// 	using namespace std;
	
// 	map<int , vector<int>> cmap;

// 	vector<int> test;
// 	for (int i = 1; i <= 5; i++)
//         test.push_back(i);
// 	vector<int> test1;
// 	for (int i = 6; i <= 10; i++)
//         test1.push_back(i);
// 	vector<int> test2;
// 	for (int i = 11; i <= 15; i++)
//         test2.push_back(i);

// 	cmap[1] = test;
// 	cmap[9] = test1;
// 	cmap[3] = test2;

// 	vector<int> result = cmap.at(9);
// 	for (auto i = result.begin(); i != result.end(); ++i)
//         cout << *i << " ";

// 	return 0;
// }

#include <bits/stdc++.h>
using namespace std;
 
#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define endl "\n"
#define int long long

int32_t main()
{

    IOS;
	int t;
	cin >> t;
	int tc = 0; 
	while(t--)
	{
        tc++;
        int r, c;
        cin>>r>>c;


        map<int , vector<int*>> ij;

        int** m = new int*[r+2];
        for(int i =0 ; i<r+2 ;i++)
        {
            m[i] = new int[c+2];
        }
        bool** boolArr = new bool*[r+2];
        for(int i =0 ; i<r+2 ;i++)
        {
            boolArr[i] = new bool[c+2];
        }

        for (int i = 1 ; i<=r ; i++)
        {
            for (int j = 1 ; j<=c ; j++)
            {
                cin >> m[i][j];
                boolArr[i][j] = false;
            }
        }

        // Mapping the number of the matrix

        for(int i =1 ; i<=r; i++)
        {
            for (int j =1 ; j<=c ; j++)
                {
                    int* tmp = new int[2];
                        tmp[0] = i;
                        tmp[1] = j;
                    if (ij.find(m[i][j]) == ij.end())       // this says that the key is not present in the map
                    {
                        vector<int*> tempij;
                        tempij.push_back(tmp);
                        ij[m[i][j]] = tempij;
                    }
                    else
                    {
                        ij.at(m[i][j]).push_back(tmp);
                    }

                }
        }


        


        int max =0 ; 
        for (int i = 1 ; i<=r ; i++)
        {
            for (int j = 1 ; j<=c ; j++)
            {
                if(max <  m[i][j])
                {
                    max =  m[i][j];
                }
            }
        }
        
        
        
        int ans = 0;
        
        for(auto a= ij.rbegin(); a != ij.rend(); a++)
        {
            vector<int*> currMaxArr = a->second;
            int currMax = a->first;

                for(int v =0 ; v< currMaxArr.size() ; v++)
                {
                    int i = currMaxArr.at(v)[0] ;
                    int j = currMaxArr.at(v)[1] ;
                   // cout << "i "<< i<< " j " << j<<endl;

                if(!boolArr[i][j])
                {
                    boolArr[i][j] = true;
                    if(i >= 1)
                    {
                        if(((m[i][j] - m[i-1][j]) > 1) && (i>1))
                        {
                            ans = ans + (m[i][j] - m[i-1][j])-1;
                            m[i-1][j] = m[i][j]-1;
                            int* tmp = new int[2];
                            tmp[0] = i-1;
                            tmp[1] = j;
                            ij[m[i][j]-1].push_back(tmp);
                            //cout <<"ans1 " <<ans<<endl;
                        }
                        if(i < r)
                        {
                            if((m[i][j] - m[i+1][j]) > 1)
                            {
                                ans = ans + (m[i][j] - m[i+1][j])-1 ;
                                m[i+1][j] = m[i][j]-1;
                                int* tmp = new int[2];
                                tmp[0] = i+1;
                                tmp[1] = j;
                                ij[m[i][j]-1].push_back(tmp);
                               // cout <<"ans2 " <<ans<<endl;
                            }
                        }

                        
                    }

                    if(j >= 1)
                    {
                        if((m[i][j] - m[i][j-1]) > 1 && (j>1))
                        {
                            ans = ans + (m[i][j] - m[i][j-1])-1 ;
                            m[i][j-1] = m[i][j]-1;
                            int* tmp = new int[2];
                            tmp[0] = i;
                            tmp[1] = j-1;
                            ij[m[i][j]-1].push_back(tmp);
                           // cout <<"ans3 " <<ans<<endl;
                        }
                        if(j < c)
                        {
                            if((m[i][j] - m[i][j+1]) > 1)
                            {
                                ans = ans + (m[i][j] - m[i][j+1])-1 ;
                                m[i][j+1] = m[i][j]-1;
                                int* tmp = new int[2];
                                tmp[0] = i;
                                tmp[1] = j+1;
                                ij[m[i][j]-1].push_back(tmp);
                               // cout <<"ans4 " <<ans<<endl;
                            }
                        }

                        
                    }

                }
            
            }
        }

        


        cout << "Case #" << tc << ": " << ans << endl;
    }

return 0;
}















