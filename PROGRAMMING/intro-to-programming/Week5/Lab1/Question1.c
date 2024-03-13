#include <stdio.h>

int main()
{
   int n;
   printf("Enter the number of values: ");
   scanf("%d", &n);

   if (n < 2) // There will be no "second last" element if there are fewer than two elements
   {
      printf("Invalid number of elements");
      return 0;
   }

   int arr[n];
   printf("Enter the values: ");
   for (int i = 0; i < n; i++)
      scanf("%d", &arr[i]);
   printf("%d", sizeof(arr)/sizeof(arr[0]) -1);
   return 0;
}