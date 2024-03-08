#include <stdio.h>
int main()
{

    int end = 100000; // 1. Try smaller number
    int start = 1;
    int i = start, j = 0; // 2. Should we use just int here if 'end' is too large ? Change datatype as mentioned in the ques

    while (i <= end)
    {

        j = i;

        // loop until the current number becomes 1
        while (j != 1)
        {
            if (j % 2 == 0)
            {
                j=j/2;
                printf("%d\n", j);
            }

            else
            {
                j = 3*j + 1;
                printf("%d\n", j);
            }
        }
        // %d id for int, explore %llu
        printf(" ", i);
        i++;
    }

    return 0;
}
