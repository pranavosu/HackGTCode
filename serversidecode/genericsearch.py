import requests
import urllib

def get_search_results(query):

	try:
		result = requests.get('http://api.duckduckgo.com/?q='+query+'&format=json&pretty=1').json()
		answer = str(result['AbstractText'])

		if answer == '':
			heading = result['RelatedTopics'][0]['Result'] 
			headingpos_start = heading.find('">')
			headingpos_end = heading.find('<',headingpos_start+2)
			

			answerpos_start = heading.find('</a>')
			asnwerpos_end = heading.find('"',answerpos_start+4)


			answer = heading[answerpos_start+4:asnwerpos_end]
			heading = heading[headingpos_start + 2:headingpos_end]

			if heading.upper() == query.upper():
				pass
			else:
				answer = "Did you mean " + heading + ' ? ' + '\n\n' + answer

		return answer

	except:

		return "Couldn't find what you were looking for. Please don't be mad. I am only a few days old. I am still increasing my knowledge base." 