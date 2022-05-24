import json
import urllib
from bs4 import BeautifulSoup

data=urllib.urlopen(' http://py4e-data.dr-chuck.net/comments_1111865.json').read()

info = json.loads(data)

count=0

for item in info["comments"]:
	#print item["count"]
	number = int(item["count"])
	count = count + number
print(count)