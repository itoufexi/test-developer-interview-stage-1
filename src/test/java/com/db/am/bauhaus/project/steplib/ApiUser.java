package com.db.am.bauhaus.project.steplib;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

import net.thucydides.core.annotations.Step;

public class ApiUser {

    private static final String ACTIVE_LISTINGS_OPENAPI_ENDPOINT = "https://openapi.etsy.com/v2/listings/active";

	private static final String HOMEPAGE_ENDPOINT = "https://www.etsy.com/";
	
	private String endpoint;
		
	@Step
	public void use_active_listings_openapi_endpoint() {
		endpoint = ACTIVE_LISTINGS_OPENAPI_ENDPOINT;
	}
	
	@Step
	public void call_homepage_endpoint() {
		endpoint = HOMEPAGE_ENDPOINT;
	}
	
	@Step
	public void call_endpoint() {
		given().when().get(endpoint);
	}
	
	@Step
	public void request_an_endpoint_with_an_invalid_api_key(String key) {
		given().params("api_key", key).when().get(endpoint);
	}
	
	@Step
	public void use_homepage() {
		endpoint = HOMEPAGE_ENDPOINT;		
	}
	
	@Step
	public void verify_response_body(String message) {
		then().body(equalTo(message));
	}
	
	@Step
	public void verify_status_code(int statusCode) {
		then().statusCode(statusCode);
	}

	@Step
	public void verify_response_uaid() {
		then().cookie("uaid", startsWith("uaid"));
	}
}
