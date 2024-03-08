#include <stdio.h>
int main()
{
   int a, b, c;
   printf("Enter three integers a, b, and c - \n");
   scanf(" %d %d %d", &a, &b, &c);

   if (a==b) {
      if (b==c) {
         printf("True\n");
      }
      else {
         printf("False\n");
      }
   } else {
      printf("False\n");
   }

   return 0;
}