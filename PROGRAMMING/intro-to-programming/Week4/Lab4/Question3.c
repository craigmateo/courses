// Please write down the output generated upon execution of this program.

#include <stdio.h>

static int i = 5;

void f2()
{
    int j = i;
    for (; i < j + 5; ++i)
        ;
}

void f1()
{
    int j = i;
    for (; i < j + 2; ++i)
        f2();
}

int main()
{
    printf("%d\n", i);
    f1();
    printf("%d\n", i);
}