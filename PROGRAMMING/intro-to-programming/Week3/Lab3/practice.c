/*
This program prints the following pattern based on number of rows entered:

    1    
   232   
  34543  
 4567654 
567898765

If the number is greater than 5 the rows include numbers >= 10, so the rows should be 5 or fewer.
*/

#include <stdio.h>

int main()
{
    int num_rows;
    printf("Enter the number of rows for which the pattern should be printed - ");
    scanf(" %d", &num_rows);
    
    while (num_rows>5 || num_rows < 1) {
        printf("The number should be between 1 and 5 \n");
        printf("Enter the number of rows for which the pattern should be printed - ");
        scanf(" %d", &num_rows);
    }
    
    // loop through rows 1-num_rows

    for (int i = num_rows; i>0; i--)
    {
        // print leading blank spaces based on row number 
        int j = 1;
        while (j<=i - 1)
        {
            printf(" ");
            j++;
        }
        // compute "middle" number 1,3,5,7,9,... 
        int n = ((num_rows - i + 1)*2)-1;
        // iterate and print up to n
        for (int m = num_rows-i-1; m<n; m++) {
            if(m>num_rows-i) {
                printf("%d", m);
            }
        }
        // print middle number n
        printf("%d",n);
        // interate and print down from n
        for (int p = n-1; p>num_rows-i; p--) {
                printf("%d", p);
        }
        // print trailing blank spaces based on row number
        int k = 1;
        while (k<=i - 1)
        {
            printf(" ");
            k++;
        }
        // new row
        printf("\n");
    }

    return 0;
}