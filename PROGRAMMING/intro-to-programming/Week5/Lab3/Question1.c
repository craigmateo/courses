#include <stdio.h>

int main()
{
    char str[100];
    int i = 0;
    int count = 0;
    printf("Enter a string: ");
    scanf("%s", str);

    // Count number of vowels
    // The result should be stored in the variable count (which has been initialised to zero).
    for (int j = 0; j < sizeof(str)/sizeof(str[0]); j++)
        if (str[j] == 'a' || str[j] == 'e' || str[j] == 'i' || str[j] == 'o' || str[j] == 'u') {
            count+=1;
        } 
    
    printf("Number of vowels in the string %s is %d", str, count);
    return 0;
}