/*
    Please tell in which memory segment will each of the following functions and variables be stored in the RAM. Also for variables inside a function, please tell in which function's frame will they be stored in the RAM
*/

#include <stdio.h>

double pi = 3.14;  //data
char A = 'A'; //data

double f1()
{
    return pi;
}

char a_char()
{
    int j = 5; // stack
    short int k = 10; // stack
    return A;
}

int main()
{
    char b = a_char(); // stack
    double constant = f1();
}