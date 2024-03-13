#include <stdio.h>

void selectionSort(int arr[], int n) {  
    int i, j, min;  

    // run for the entire array
    for (i = 0; i < n-1; i++)
        {  
            // find minimum element from unsorted part
            min = i;
            for (j = i+1; j < n; j++)
            {
            	if (arr[j] < arr[min])
            	min = j;
            }
    
    
        // place it in sorted location (swap)
            int temp = arr[min];  
            arr[min] = arr[i];  
            arr[i] = temp;  
        }  
    }

int main(void)
{
    int n;
    printf("Enter the number of values: ");
    scanf("%d", &n);

    if (n < 3) // There is no third smallest element for an array that has fewer than three elements
    {
        printf("Invalid number of elements");
        return 0;
    }

    int arr[n];
    printf("Enter the values: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    // code that finds the third smallest element in the array and then also displays it.
    
    selectionSort(arr, n);
    
    // selection sort
    
    printf("%d",arr[sizeof(arr)/sizeof(arr[0]) - 3]);

    return 0;
}