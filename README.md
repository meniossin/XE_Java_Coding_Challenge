# XE_Java_Coding_Challenge
A small restful service developed in Spring boot that counts words from classified texts.

This service was developed with Intellij Ultimate edition 2019.1 and Java Spring Boot.
The Open source Java HTML parser Jsoup was used in order to strip the HTML tags when sending classified data edited with HTML.


The service is deployed and hosted on Heroku >  https://xe-coding-challenge.herokuapp.com/ 

The service exposes two endpoints :
 1. ` https://xe-coding-challenge.herokuapp.com/count`
 2. ` https://xe-coding-challenge.herokuapp.com/countHtml`
 
 

# Testing

You can directly test the service from your terminal with curl :

`curl -d @request.json -H "Content-Type: application/json"  https://xe-coding-challenge.herokuapp.com/count`

the `data_requests` directory contains some json data file to use for testing . 


After you hit the request, you should receive a similar response:

 `{"text":"ΝΙΚΑΙΑ Ασπρα Χώματα, διαμέρισμα 70 τ.μ., 1ου, γωνιακό 600€","words":9,"price":"600€"}`


You can always import the project(with Maven) into your IDE and run this service on localhost. 
