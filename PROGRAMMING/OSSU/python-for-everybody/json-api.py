import json
import urllib

serviceurl = "http://python-data.dr-chuck.net/geojson?"
data_address = "Columbia University"
address_wanted = data_address

parameters = {"sensor": "false", "address": address_wanted}
paramsurl = urllib.urlencode(parameters)

queryurl = serviceurl + paramsurl
print("DATA URL: ", queryurl)

data = urllib.urlopen(queryurl).read()

jsondata = json.loads(str(data))
place_id = jsondata["results"][0]["place_id"]
print("PLACE ID: ", place_id)