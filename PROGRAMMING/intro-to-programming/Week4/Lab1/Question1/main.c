#include <stdio.h>
#include "oddeven.c"

int main()
{
    int n;
    printf("Please enter a number : \n");
    scanf("%d", &n);
    // If check_odd_or_even() function returns 1 it means true.
    // True means, number is divided by 2, thus it is even
    if (odd_even(n) == 1)
        printf("%d is even.\n", n);
    else
        printf("%d is odd.\n", n);
    return 0;
}