/*
    Please tell what is the output of the below program
*/

#include <stdio.h>
char b = 'A';
int main()
{
    printf("b = %d\n", b);
    int b = 15;
    printf("b = %d\n", b);
    for (int b = 1; b < 3; ++b)
    {
        printf("b = %d\n", b);
        short int b = 7;
        printf("b = %d\n", b);
    }

    return 0;
}