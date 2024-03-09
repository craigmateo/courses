// Calls a function that prints an inverted triangle of height N, where N is asked from user and supplied to the function.

#include <stdio.h>

printInvertedTriangle(int);

int main(void)
{
    int n;
    printf("Enter the height N: ");
    scanf("%d", &n);

    printInvertedTriangle(n);

    return 0;
}

printInvertedTriangle(n)
{
    // get number of stars for top row
    int toprow = 1;
    int row = n;
    for (int i = 2; i <= n; i++) {
        toprow+=2;
    }
    //printf("%d", toprow);
    
    while(toprow > 0) {
        // print leading blank spaces
        
        for (int k = 1; k<=n-row; k++) {
            printf(" ");
        }

        row=row-1;
    
        // print stars
        for (int j = 1; j<=toprow; j++) {
            printf("*");
        }
        printf("\n");
        toprow=toprow-2;
        
    }
    
    
}
