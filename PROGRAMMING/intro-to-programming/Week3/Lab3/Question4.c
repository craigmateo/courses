#include <stdio.h>
int main()
{

    unsigned long long int a, b, ans = 1;
    // Variables are declared as unsigned long long int so that they can store big integers also

    printf("Enter two positive integers a and b - ");
    scanf("%d %d", &a, &b);

    if (a<=0 || b<=0) {
        return 0;
    } else {

        for (int i=1; i <= b; i++) {
            ans = a*ans;
        }
    
        printf("%llu^%llu = %llu\n", a, b, ans);
        return 0;
    }
    
}