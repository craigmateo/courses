# In this assignment you will read through and parse a file with text and numbers. You will extract all the numbers in the file and compute the sum of the numbers.

import re
hand = open('actual.txt')
total=0
vals=0
for line in hand:
    x=re.findall('[0-9]+', line)
    if len(x) > 0:
        ints=[int(i) for i in x]
        vals=vals+len(ints)
        total=total+sum(ints)
print("There are %d values with a sum=%d" % (vals, total))
