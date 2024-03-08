#include <stdio.h>
int main()
{
    int num_rows;
    printf("Enter the number of rows for which the pattern should be printed - ");
    scanf(" %d", &num_rows);

    for (int i = num_rows; i>0; i--)
    {
        int j = 1;
        while (j<=num_rows-i + 1)
        {
            printf("%d", (i + j + 1) % 2);
            j++;
        }
        printf("\n");
    }
    printf("\n");

    return 0;
}