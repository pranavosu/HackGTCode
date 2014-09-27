import requests

def get_stock_info(query):

	stock, junk = query.split()
	resultobj = requests.get('https://www.google.com/finance/info?q=NASDAQ%3a' + stock)
	result = resultobj.text
	#print result
	
	startAt = result.find('"l"')
	#print result
	pos = result.find('"',startAt + 4) + 1
	endpos = result.find('"',pos)
	price = str(result[pos:endpos])
	
	if len(price) <= 1:
		return "Invalid Stock Name. Made a typo, didn't you? :)"
	else:
		return price