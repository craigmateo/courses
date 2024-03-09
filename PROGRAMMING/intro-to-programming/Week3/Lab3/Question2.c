
#include <stdio.h>
int main()
{
    int start;
    printf("Enter a positive number - ");
    scanf(" %d", &start);

    for (int i = start;; ++i)
    {
        if (i % 5 != 0)
            continue;

        if (i >= 79)
            break;

        printf("%d, ", i);
    }
    printf("\n");

    return 0;
}