#include <stdio.h>
#include <conio.h>
#include <math.h>

int main()
{
	int A[50],n,i;
	printf("Enter The Size of Set\n");
	scanf("%d",&n);
	printf("Enter The Elements of Set\n");
	for(i=0;i<n;i++)
	{
		scanf("%d",&A[i]);
	}
    printf("Power Set is:\n\t{ (");
	for(i=0;i<pow(2,n);i++)
	{
        printf("(");
		for(int j=0;j<n;j++)
		{
			if(i & (1<<j)) //Bitmasking Approach
			{
				printf("%d,", A[j]);
            }
		}
		printf("\b),");
	}
    printf("\b }");
	return 0;
}
