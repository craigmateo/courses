#include <stdio.h>
/*
The C code has both syntactic and logical errors
*/
int main()
{

    int marks;
    printf("Please enter your marks: ");
    scanf(" %d", &marks);

    if (marks >= 90)
        printf("Your grade is Extraordinary");

    else if (marks >= 80)
    {
        printf("Your grade is Very Good");
    }
    else if (marks >= 65) {
        printf("Your grade is Good");
    }
    else if (marks >= 50) {
        printf("Your grade is Average");
    }
    else if (marks >= 40) {
        printf("Your grade is Below Average");
    }
    else {
        printf("Fail, but it is not the end of the world.");
    }
}