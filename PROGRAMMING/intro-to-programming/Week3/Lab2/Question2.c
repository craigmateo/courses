#include <stdio.h>
int main()
{

    int N;
    printf("Please Enter a number greater than 0: ");
    scanf(" %d", &N);

    while (N<=0)
    {
        printf("Please Enter a number greater than 0: ");
        scanf(" %d", &N);
    }

    int M;
    printf("Please Enter a number lesser than 0: ");
    scanf(" %d", &M);

    while (M>=0)
    {
        printf("Please Enter a number lesser than 0: ");
        scanf(" %d", &M);
    }

    int P;
    printf("Please Enter a number greater than 5 OR less than -5: ");
    scanf(" %d", &P);

    while (P>-5)
    {
        if (P<5) {
        printf("Please Enter a number greater than 5 OR less than -5: ");
        scanf(" %d", &P);
        }
    }

    int Q;
    printf("Please Enter a number greater than 20 OR less than 100: ");
    scanf(" %d", &Q);

    while (20>Q>100)
    {
        printf("Please Enter a number greater than 20 OR less than 100: ");
        scanf(" %d", &Q);
    }

    return 0;
}