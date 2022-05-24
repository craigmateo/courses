# 10.2 Write a program to read through the mbox-short.txt and figure out the distribution by hour of the day for each of the messages. You can pull the hour out from the 'From ' line by finding the time and then splitting the string a second time using a colon.

name = input("Enter file:")
if len(name) < 1 : name = "mbox-short.txt"

handle = open(name)

hours = []

for line in handle:
    s=line.split()
    if "From" in line and len(s)>2:
        tlist=s[-2].split(":")
        t=tlist[0]
        hours.append(t)

counts=[]
for h in hours:
    c=hours.count(h)
    if (h,c) not in counts:
	    counts.append((h,c))
counts.sort()
for a,b in counts:
	print(a, b)