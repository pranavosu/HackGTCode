import requests
import pprint

payload = {'q':'Toy+Story+3','apikey':'3rqaqbrmxgmy63m92drr5w79','page_limit':'1'}

r = requests.get('http://api.rottentomatoes.com/api/public/v1.0/movies.json',params=payload)

r_j = r.json()

r_id = r_j['movies'][0]['id']

payload_review = {'apikey':'3rqaqbrmxgmy63m92drr5w79'}

r_details = requests.get('http://api.rottentomatoes.com/api/public/v1.0/movies/'+r_id+'/reviews.json',params = payload_review)

r_jdetails = r_details.json()

r_details_arr = r_jdetails['reviews'];

# pprint.pprint(r_details_arr)

for review in r_details_arr: 
	print(review['quote'])


