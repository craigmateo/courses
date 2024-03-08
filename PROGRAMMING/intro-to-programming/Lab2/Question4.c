#include <stdio.h>
/*
sample inputs and outputs
input: 3
output: March

input: 11
output: November

input: 13
input: -1
input: 16
input: 2
output: February

*/
int main()
{

    int month_number; // 1 to 12

    /* 1. ask a number input from user and Ensure it is between 
          1 and 12 */
    
    printf("Enter a number between 1 and 12: ");
    scanf("%d", &month_number);
    
    while (month_number < 1 | month_number > 12) {
        printf("Enter a number between 1 and 12: ");
        scanf("%d", &month_number);  
    }
    
    switch (month_number)
    {
    case 1:
        printf("January\n");
    case 2:
        printf("February\n");
    case 3:
        printf("March\n");
    case 4:
        printf("April\n");
    case 5:
        printf("May\n");
    case 6:
        printf("June\n");
    case 7:
        printf("July\n");
    case 8:
        printf("August\n");
    case 9:
        printf("September\n");
    case 10:
        printf("October\n");
    case 11:
        printf("November\n");
    case 12:
        printf("December\n");
        break;

    }

    return 0;
}
