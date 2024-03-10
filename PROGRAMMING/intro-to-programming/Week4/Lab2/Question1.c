// To check if the number is an armstrong number and a perfect number.
#include <stdio.h>

// Write function declarations here
/*blank*/

int main()
{
    int num;
    printf("Input a number to check: ");
    scanf("%d", &num);

    if (isArmstrongNumber(num))
    {
        printf("%d is an Armstrong number.\n", num);
    }
    else
    {
        printf("%d is NOT an Armstrong number.\n", num);
    }

    if (isPerfectNumber(num))
    {
        printf("%d is a Perfect number.\n", num);
    }
    else
    {
        printf("%d is NOT a Perfect number.\n", num);
    }

    return 0;
}

int isArmstrongNumber(int num)
{
    int lastDigit, sum = 0, n = num;
    while (n != 0)
    {
        lastDigit = n % 10;                       // find the last digit of the number
        sum += lastDigit * lastDigit * lastDigit; //calculate the cube of the last digit and adds to sum
        n = n / 10;                               // remove the last digit if the number
    }
    return (num == sum); // returns 1, i.e. True, if it is Armstrong
}

int isPerfectNumber(int num)
{
    int i, sum = 0;
    // there can not be any divisor of n greater than n/2, exlcuding n itself.
    for (i = 1; i <= num / 2; i++)
    {
        // if the number i is divisor of num
        if (num % i == 0)
        {
            sum += i;
        }
    }
    return (num == sum);
}
