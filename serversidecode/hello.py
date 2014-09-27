from flask import Flask, request
from flask import Response
from placesapi import get_details, get_directions
from genericsearch import get_search_results
from stocks import get_stock_info
import requests
import pprint
import re

app = Flask(__name__)
app.debug= True
@app.route('/',methods=['POST'])

def hello():
    query = request.form['Body']
    #query = '1204 w adams blvd los angeles to ronald tutor campus center directions'
    #query = 'sachin tendulkar'
    #query = 'fb stock'

    if 'directions' in query:
    	result = get_directions(query)
    elif 'translate' in query:
    	result = get_translation(query)
    elif 'info' in query:
    	result = get_details(query)
    elif 'stock' in query:
    	result = get_stock_info(query)
    else:
    	result = get_search_results(query)
    
    print result
    
    if len(result) < 2:
    	result = "Sorry, We couldn't find the information you were looking for"

    xml = '<?xml version="1.0" encoding="UTF-8"?><Response><Sms>'+result+'</Sms></Response>'
    return Response(xml, mimetype='text/xml')
