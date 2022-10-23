# 9.4 Write a program to read through the mbox-short.txt and figure out who has sent the greatest number of mail messages. The program looks for 'From ' lines and takes the second word of those lines as the person who sent the mail. The program creates a Python dictionary that maps the sender's mail address to a count of the number of times they appear in the file. After the dictionary is produced, the program reads through the dictionary using a maximum loop to find the most prolific committer.


name = input("Enter file:")
if len(name) < 1 : name = "mbox-short.txt"
handle = open(name)

dict={}

for line in handle:
    if line.startswith("From:"):
        s=line.split()
        email=s[1]
        if email in dict.keys():
            dict[email]=dict[email]+1
        else:
            dict[email]=1
        
max_value = max(dic.values())
max_key = [k for k, v in dic.items() if v == max_value]
print(max_key[0], max_value)
