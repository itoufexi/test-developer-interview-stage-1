Feature: Connect to API

  @api
  Scenario: User calls web service with no API key
    Given an API user uses no API key
	When they call the endpoint
	Then the response message is 'API request missing api_key or valid OAuth parameters'
	And the status code is 400
   
  @api
  Scenario Outline: User calls web service with an invalid API key
    Given an API user uses the invalid API key <key>
	When they call the endpoint
	Then the response message is 'Invalid api_key: <key>'
	And the status code is 403
    Examples:
      | key                       |
      | invalid_key_1 |
      | invalid_key_2 |