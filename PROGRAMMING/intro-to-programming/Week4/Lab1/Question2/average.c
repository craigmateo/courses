float average()
{
    int p, q, r, s;
    float total;
    printf("Enter 4 numbers: \n");
    /*Read the numbers into variables, 
	find the total and calculate the average 
	and return the average value*/
	scanf("%d %d %d %d", &p, &q, &r, &s);
     return (p + q + r + s) / 4.0;
}