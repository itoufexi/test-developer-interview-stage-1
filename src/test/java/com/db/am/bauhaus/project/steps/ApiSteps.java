package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.steplib.ApiUser;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class ApiSteps {

    @Steps
    ApiUser apiUser;

    @Given("an API user uses no API key")
    public void a_user_uses_no_api_key() {
    	apiUser.create_a_request();
    }
    
    @Given("an API user uses the invalid API key (.*)$")
    public void a_user_uses_invalid_api_key(String key) {
        apiUser.create_a_request_with_an_invalid_api_key(key);
    }
    
    @Given("a user visits Etsy for the first time$")
    public void a_user_visits_first_time() {
        apiUser.create_a_request();
    }
    
	@When("they call the Etsy openapi endpoint")
	public void a_user_calls_the_openapi_endpoint(){
		apiUser.call_openapi_endpoint();
	}
	
	@When("they browse Etsy")
	public void a_user_requests_etsy_homepage(){
		apiUser.call_homepage();
	}
	
	@Then("the response message is '(.*)'$")
	public void verify_response_body(String message) {
		apiUser.verify_response_body(message);
	}

	@And("the status code is (\\d+)")
	public void verify_status_code(int statusCode) {
		apiUser.verify_status_code(statusCode);
	}
	
	@Then("the response should contain a uaid cookie")
	public void verify_response_uaid() {
		apiUser.verify_response_uaid();
	}

}