#include <stdio.h>

int main(void)
{
    int n;
    printf("Enter number of elements in the array: ");
    scanf("%d", &n);

    if (n < 2) // No pair can exist in an array whose size is less than 2
    {
        printf("Invalid number of elements");
        return 0;
    }

    int array[n];
    printf("Enter the elements of the array: ");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &array[i]);
    }

    int found = 0;

    // found is a variable that acts like a flag.
    // If the pair is found, then found should be set to 1. Otherwise, found should be set to 0.
    
    for (int j = 0; j < sizeof(array)/sizeof(array[0]); j++)
        if (array[j] == 2) {
            if (array[j+1] == 3) {
                found = 1;
                break;
            }
        } 

    if (found == 1)
    {
        printf("The pair [2,3] exists consecutively in that sequence\n");
    }
    else
    {
        printf("The pair [2,3] does not exist consecutively in that sequence\n");
    }

    return 0;
}