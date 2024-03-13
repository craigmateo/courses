#include <stdio.h>

int main(void)
{
    int i;
    int n;
    printf("Enter the number of values: ");
    scanf("%d", &n);

    if (n < 2) // AND is a binary operation. If there aren't at least two elements in the array, then we cannot perform this operation.
    {
        printf("Invalid number of elements");
        return 0;
    }

    int arr[n];
    printf("Enter the values: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    int ans = arr[0];

    for (int j = 1; j < sizeof(arr)/sizeof(arr[0]); j++)
        ans = ans & arr[j];

    printf("The bitwise AND of all the elements in the array is %d", ans);
    return 0;
}