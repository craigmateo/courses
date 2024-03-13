#include <stdio.h>
#include <ctype.h>

int main(void)
{
    char str[100];
    int i, avg;
    printf("Enter a string: ");
    
    while(str[i]!='\n')
    {
        i++;
        str[i]=getchar();
    }
    
    // The average ASCII value should be stored in the variable avg.
    int sum = 0;
    for (int j = 0; j < i; j++) {
        sum+=str[j];

    }
    printf("%d\n",sum);
    avg = sum/i;
    
    printf("Average ASCII value: %d\n", avg);
    printf("Character equivalent of the average ASCII value: %c\n", avg); // This printf implicitly type casts the integer stored in avg into a character through the %c specifier
}