import urllib
import xml.etree.ElementTree as ET

url = raw_input("Enter location: ")
if len(url) < 1:
    url = "http://py4e-data.dr-chuck.net/comments_1111864.xml"
print "Retrieving " + url

xml = urllib.urlopen(url).read()
print "Retrieved: " + str(len(xml)) + " characters"

tree = ET.fromstring(xml)

counts =  tree.findall('.//count')
print "Count: " + str(len(counts))

accumulator = 0

for count in counts:
    accumulator += int(count.text)

print "Sum:" + str(accumulator)