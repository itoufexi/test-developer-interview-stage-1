Feature: API

  @api
  Scenario: Should set uaid cookie
  Given a user visits Etsy for the first time
  When they browse Etsy
  Then the response should contain a uaid cookie

  @api
  Scenario: Should get a Bad Request response when calling web service with no API key
    Given an API user uses no API key
	When they call the Etsy openapi endpoint
	Then the response message is 'API request missing api_key or valid OAuth parameters'
	And the status code is 400
   
  @api
  Scenario Outline: Should get a Forbidden response when calling web service with an invalid API key
    Given an API user uses the invalid API key <key>
	When they call the Etsy openapi endpoint
	Then the response message is 'Invalid api_key: <key>'
	And the status code is 403
    Examples:
      | key                       |
      | invalid_key_1 |
      | invalid_key_2 |