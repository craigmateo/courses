// program to check if the provided number is palindrome or not
#include <stdio.h>

int reverseOfNumber(int);

int main()
{
    int n;
    printf("Please Enter a number: ");
    scanf("%d", &n);

    if (isPalindrome(n))
        printf("%d is a palindrome.", n);
    else
        printf("%d is NOT a palindrome.", n);

    return 0;
}

int reverseOfNumber(int n)
{
    int remainder, n_reverse = 0;
    while (n != 0)
    {
        remainder = n % 10;
        n_reverse = n_reverse * 10 + remainder;
        n /= 10;
    }
    return n_reverse;
}

int isPalindrome(int n)
{
    return (reverseOfNumber(n) == n);
}