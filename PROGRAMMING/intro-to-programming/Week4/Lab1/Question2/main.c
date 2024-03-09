#include <stdio.h>
#include "average.c"

int main()
{
    float avg;
    avg = average();
    printf("Average is: %f\n", avg);
    return 0;
}