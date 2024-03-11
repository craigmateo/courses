/*
    Give datatype, storage class and scope of each variable in the given program, and tell what will be the output of the given program?
*/

#include <stdio.h>

double i = 3.14;

void f1(int i)
{
    printf("i^3 = %d\n", i * i * i);
}

int main()
{
    int j = 2;
    for (int k = 3; k <= 9; ++k)
    {
        f1(k);
        k = 10;
        f1(k);
        {
            int k = 1;
            f1(k);
        }
    }
    return 0;
}