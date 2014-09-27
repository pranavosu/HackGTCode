import requests
import pprint
import re

def get_details(placedetails):

	rem = placedetails.find('info')
	placedetails = placedetails[:rem-1]

	payload = {'query':placedetails,'key':'AIzaSyDNi1Owcq0YvA2LUdFdrWfIHj_1RAE4nco'}

	r = requests.get('https://maps.googleapis.com/maps/api/place/textsearch/json',params=payload)
	r_j = r.json()

	#pprint.pprint(r_j)
	num_results = 3
	results = dict()
	try:
		for i in range(num_results):
			id_place = r_j['results'][i]['place_id']
			id_name =  str(r_j['results'][i]['name'])

			#pprint.pprint(str(id_place))
			#pprint.pprint(str(id_name))

			payload_detail = {'placeid':str(id_place),'key':'AIzaSyDNi1Owcq0YvA2LUdFdrWfIHj_1RAE4nco'}

			details = requests.get('https://maps.googleapis.com/maps/api/place/details/json?',params = payload_detail)

			details_j = details.json()
			phonenum = str(details_j['result']['formatted_phone_number'])
			address = str(details_j['result']['formatted_address'])

			results[str(id_name)] = phonenum + '$' + address

			#pprint.pprint(phonenum)

		answer = ''
		
		for k,v in results.items():
			num,loc = v.split('$')
			answer += k + ' : ' + num + '\n' + loc + '\n\n' 

		return answer
		
	except:
		return "Oops . No results found. I apologize. Feel like trying a different query?"

def get_directions(place):

		places = place.find('directions')
		mode = place[places+len('directions')+1:]
		data = place[:places].split(' to ')
		place1 = data[0]
		place2 = data[1]

		try:
		
			if len(mode) < 1:

				payload = {'origin':place1,'destination':place2,'mode':'driving','key':'AIzaSyDske8En0zCLrvsDxKiZ3seGc-YfQnEWyQ'}
			
			else:

				payload = {'origin':place1,'destination':place2,'mode': mode,'key':'AIzaSyDske8En0zCLrvsDxKiZ3seGc-YfQnEWyQ'}


			directions = requests.get('https://maps.googleapis.com/maps/api/directions/json',params=payload)

			directions_j = directions.json()

			#pprint.pprint(directions_j)

			alldirections = '' 
			for eachstep in directions_j['routes'][0]['legs'][0]['steps']:
				alldirections += str(eachstep['html_instructions']) + '\n'
			

			pattern = re.compile('<[^>]*>')
			alldirections = pattern.sub('',alldirections)
	
			return alldirections

		except:

			return "Sorry, I was unable to get you the directions you wanted. I am reading up as fast as I can. Hopefully, soon I'll be really smart and will not disappoint you."




