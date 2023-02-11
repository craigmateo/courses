"""
Part B: Saving, with a raise

Background 
In Part A, we unrealistically assumed that your salary didn’t change.  But you are an MIT graduate, and
clearly you are going to be worth more to your company over time! So we are going to build on your
solution to Part A by factoring in a raise every six months. 

In ps1b.py, copy your solution to Part A (as we are going to reuse much of that machinery).  Modify
your program to include the following

1. Have the user input a semi-annual salary raise semi_annual_raise (as a decimal percentage)
2. After the 6th month, increase your salary by that percentage.  Do the same after the 12th
month, the 18th  month, and so on. 

Write a program to calculate how many months it will take you save up enough money for a down
payment.  LIke before, assume that your investments earn a return of r = 0.04 (or 4%) and the
required down payment percentage is 0.25 (or 25%).  Have the user enter the following variables:

1. The starting annual salary (annual_salary)
2. The percentage of salary to be saved (portion_saved)
3. The cost of your dream home (total_cost)
4. The semi­annual salary raise (semi_annual_raise)

"""

annual_salary = int(input("Enter your annual salary: "))
monthly_salary = annual_salary/12
portion_saved = float(input("Enter your savings rate, as a decimal: "))
total_cost = int(input("Enter your home cost: "))
semi_annual_raise = float(input("Enter the semi­annual raise, as a decimal: "))
portion_down_payment = total_cost*0.25
current_savings = 0
r = 0.04

months = 0

while current_savings < portion_down_payment:
    if (months +1)%6 == 0:
        monthly_salary = monthly_salary + monthly_salary*semi_annual_raise
    current_savings += portion_saved*monthly_salary + current_savings*(r/12)
    months+=1

print("Number of months: {}".format(months))