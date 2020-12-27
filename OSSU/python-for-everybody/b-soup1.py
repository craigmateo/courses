#Actual data: http://py4e-data.dr-chuck.net/comments_24964.html (Sum ends with 73)

from urllib import request
from bs4 import BeautifulSoup
html=request.urlopen('http://python-data.dr-chuck.net/comments_24964.html').read()
soup = BeautifulSoup(html)
tags=soup('span')
sum=0
for tag in tags:
    sum=sum+int(tag.contents[0])
print(sum)