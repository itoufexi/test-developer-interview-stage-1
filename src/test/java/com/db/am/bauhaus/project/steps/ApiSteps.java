package com.db.am.bauhaus.project.steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiSteps {

    private static final String ENDPOINT = "https://openapi.etsy.com/v2/listings/active";
	
	private Response response;
	private RequestSpecification request;

    @Given("an API user uses no API key")
    public void a_user_uses_no_api_key() {
        request = given().when();
    }
    
    @Given("an API user uses the invalid API key (.*)$")
    public void a_user_uses_invalid_api_key(String key) {
        request = given().queryParam("api_key", key).when();
    }
    
	@When("they call the endpoint")
	public void a_user_retrieves_the_book_by_isbn(){
		response = request.get(ENDPOINT);
		System.out.println("response: " + response.prettyPrint());
	}
	
	@Then("the response message is '(.*)'$")
	public void verify_response_body(String message) {
		response.then().body(equalTo(message));
	}

	@And("the status code is (\\d+)")
	public void verify_status_code(int statusCode) {
		response.then().statusCode(statusCode);
	}

}