#include <bits/stdc++.h>
using namespace std;

/*************************************************************************************************/
bool divCheck(string &n, int k)
{
    int rem = 0;
    for (auto i : n)
        rem = ((rem * 10) + i - '0') % k;
    return rem == 0;
}
signed main()
{
    string str;
    int k;
    cin>>str>>k;
    cout <<divCheck(str,k);
    return 0;
}