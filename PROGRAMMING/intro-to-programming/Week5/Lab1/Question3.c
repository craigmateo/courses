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

    int odd;
    int even;

    for (int j = 0; j < sizeof(array)/sizeof(array[0]); j++)
        if (array[j] % 2 == 0) {
            even+=1;
        } else {
            odd+=1;
        }

    printf("The number of odd values is %d\n", odd);
    printf("The number of even values is %d\n", even);
    return 0;
}