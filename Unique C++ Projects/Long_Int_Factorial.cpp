#include <bits/stdc++.h>
#define int long long
#define ll long long int
#define loop(i, x, n) for (int i = x; i < n; i++)
#define rloop(i, x, n) for (int i = n - 1; i >= x; i--)
#define vi vector<int>
using namespace std;

void multiply(int num, int &posi, vector<int> &v)
{
    // to multiply every index element by num and adding remaining carry to the next index....
    int carry=0;
    for(int i=0; i<posi; i++)
    {
        int product=v[i]*num+ carry;
        v[i]=product%10;
        carry=product/10;
    }

    //Code for the carry which is still remaining even after multiplying by all the numbers....
    while(carry)
    {
        v[posi]=carry%10;
        carry=carry/10;
        posi++;
    }
}

void code()
{
    int n;
    cin>>n;
    vector<int> v(1000);
    v[0]=1;


    int posi=1;
    for(int i=2; i<=n; i++)
        multiply(i, posi, v);

    //posi is the position till where an valid element is present at index....i.e the last element from starting of array...
    for(int i=posi-1; i>=0; i--)
        cout<<v[i];
    cout<<endl;
}

signed main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    int t;
    cin >> t;
    while (t--)
        code();
    return 0;
}