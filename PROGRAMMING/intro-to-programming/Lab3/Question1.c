#include <stdio.h>

main()
{

    int N;
    printf("Enter the value of N - ");
    scanf(" %llu", &N);

    int sum = 0;
    int sumc = 0;

    for (int i = 0; i < N; ++i)
    {
        sum += i * i;
    }
    
    for (int j = 0; j < N; ++j)
    {
        sumc += j * j * j;
    }

    printf("Sum of squares from 1 to %d is %d\n", N, sum);
    printf("Sum of cubes from 1 to %d is %d\n", N, sumc);

    return 0;
}