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
    
	@Given("an API user calls the active listings Etsy openapi endpoint")
	public void a_user_calls_the_openapi_endpoint(){
		apiUser.use_active_listings_openapi_endpoint();
	}
	
	@Given("a user visits Etsy")
	public void a_user_requests_etsy_homepage(){
		apiUser.use_homepage();
	}
	
    @When("a cookie is not already set")
    public void a_user_visits_first_time() {
        apiUser.call_endpoint();
    }
	
    @When("they use no API key")
    public void a_user_uses_no_api_key() {
    	apiUser.call_endpoint();
    }
    
    @When("they use the invalid API key (.*)$")
    public void a_user_uses_invalid_api_key(String key) {
        apiUser.request_an_endpoint_with_an_invalid_api_key(key);
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