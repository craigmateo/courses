#include <stdio.h>
int main()
{
    /*
    Intended Output, part a:
        54321
        4321
        321
        21
        1
    */
    int N, K;
    printf("Enter a Number N: ");
    scanf(" %d", &N);
    K = N;
    int i = 1; // outer loop control variable
    int j;     // inner loop control variable
    while (i <= N)
    {
        j = N;
        while (j > 0)
        {
            printf("%d", j);
            j--;
        }
        N--;
        printf("\n");
    }

    /*
    part b
    Intended Output:
        54321
        5432
        543
        54
        5
    */

    int n = 1; // outer loop control variable
    int m;     // inner loop control variable
    int h = 0;
    while (n <= K)
    {
        m = K;
        while (m > 0)
        {
            printf("%d", m+h);
            m--;
        }
        h++;
        K--;
        printf("\n");
    }
}
