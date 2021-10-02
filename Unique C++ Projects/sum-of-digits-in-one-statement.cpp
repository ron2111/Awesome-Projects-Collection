#include <iostream>
using namespace std;

class gfg {
public:
    int getSum(int n)
    {
        int sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }
};

int main()
{
    gfg g;
    int n = 687;
    cout << g.getSum(n);
    return 0;
}
