"""
Part C: Finding the right amount to save away
In Part B, you had a chance to explore how both the percentage of your salary that you save each month 
and your annual raise affect how long it takes you to save for a down payment.  This is nice, but
suppose you want to set a particular goal, e.g. to be able to afford the down payment in three years.
How much should you save each month to achieve this?  In this problem, you are going to write a 
program to answer that question.  To simplify things, assume:

1. Your semi­annual raise is .07 (7%)
2. Your investments have an annual return of 0.04 (4%)  
3. The down payment is 0.25 (25%) of the cost of the house 
4. The cost of the house that you are saving for is $1M.

You are now going to try to find the best rate of savings to achieve a down payment on a $1M house in 
36 months. Since hitting this exactly is a challenge, we simply want your savings to be within $100 of 
the required down payment. 

In ps1c.py, write a program to calculate the best savings rate, as a function of your starting salary.
You should use bisection search to help you do this efficiently. You should keep track of the number of 
steps it takes your bisections search to finish. You should be able to reuse some of the code you wrote
for part B in this problem.  

Because we are searching for a value that is in principle a float, we are going to limit ourselves to two
decimals of accuracy (i.e., we may want to save at 7.04% ­­ or 0.0704 in decimal – but we are not 
going to worry about the difference between 7.041% and 7.039%).  This means we can search for an
integer between 0 and 10000 (using integer division), and then convert it to a decimal percentage
(using float division) to use when we are calculating the current_savings after 36 months. By using
this range, there are only a finite number of numbers that we are searching over, as opposed to the
infinite number of decimals between 0 and 1. This range will help prevent infinite loops. The reason we
use 0 to 10000 is to account for two additional decimal places in the range 0% to 100%. Your code
should print out a decimal (e.g. 0.0704 for 7.04%).

Try different inputs for your starting salary, and see how the percentage you need to save changes to
reach your desired down payment.  Also keep in mind it may not be possible for to save a down
payment in a year and a half for some salaries. In this case your function should notify the user that it 
is not possible to save for the down payment in 36 months with a print statement. Please make your
program print results in the format shown in the test cases below.

"""

annual_salary = int(input("Enter your annual salary: "))

# given variables
total_cost = 1000000
semi_annual_raise = 0.07
portion_down_payment = total_cost*0.25
r = 0.04

def saved(portion_saved):
    """
    portion_saved: decimal (e.g., 0.1 for 10%)
    for each month up to 36, add to current_savings, using the salary, savings rate, raise
    return: portion_down_payment - current_savings
    """
    monthly_salary = annual_salary/12
    current_savings = 0
    months = 1

    while months < 36:
        if (months +1)%6 == 0:
            monthly_salary = monthly_salary + monthly_salary*semi_annual_raise
        current_savings += portion_saved*monthly_salary + current_savings*(r/12)
        months+=1

    return portion_down_payment-current_savings

def bisection(a,b,error, i):
    """
    a: lower bound savings rate (start 0)
    b: upper bound savings rate (start 10000)
    error: $100
    i: iterations

    c: bisection
    d: convert c to decimal
    """
    c = round((b+a)/2,0)
    print(c/10000)
    d = c/10000

    # check case: 100% savings rate 
    if i==1 and saved(1) > 0:
        print("It is not possible to save the amount in 3 years")

    # if amount saved < error, print the rate and quit
    elif abs(saved(d)) < error:
        print("Best savings rate: {}".format(d))
        print("Steps in the bisection search: {}".format(i+1))
        quit()
    
    # if down payment > savings, set c as new lower bound
    elif saved(d) > 0:
        print("Rate: {}".format(c))
        bisection(c,b,error, i+1)

    # if down payment < savings, set c as new upper bound
    elif saved(d) < 0:
        print("Rate: {}".format(c))
        bisection(a,c,error, i+1)
    
bisection(0,10000,100, 1)



