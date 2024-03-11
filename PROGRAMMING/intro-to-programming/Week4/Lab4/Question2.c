// The C program given below contains some error. It is intended to print a dot for five times and then terminate, but somehow it is giving different output each time it is executed. The output is also unexplainable. Figure out what is the error, and fix it.

#include <stdio.h>
int main()
{
    int i = 0;
    for (int i; i < 5; i++)
    {
        printf(".");
    }
    return 0;
}