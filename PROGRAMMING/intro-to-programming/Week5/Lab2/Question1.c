#include <stdio.h>

int main(void)
{
    int n;
    printf("Enter the number of values: ");
    scanf("%d", &n);

    int array[n];
    printf("Enter the values: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &array[i]);

    int count;

    for (int j = 0; j < sizeof(array)/sizeof(array[0]); j++)
        if (array[j] > 0) {
            count+=1;
        }

    printf("The number of positive values is %d", count);
}