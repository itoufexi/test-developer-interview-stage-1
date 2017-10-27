package com.db.am.bauhaus.project.steplib;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;

public class ApiUser {

    private static final String OPENAPI_ENDPOINT = "https://openapi.etsy.com/v2/listings/active";

	private static final String HOMEPAGE_ENDPOINT = "https://www.etsy.com/";
	
	private Response response;
	private RequestSpecification request;
	
	@Step
	public void create_a_request() {
		request = given().when();
	}
	
	@Step
	public void create_a_request_with_an_invalid_api_key(String key) {
		request = given().queryParam("api_key", key).when();
	}
	
	@Step
	public void call_openapi_endpoint() {
		response = request.get(OPENAPI_ENDPOINT);
	}
	
	@Step
	public void call_homepage() {
		response = request.get(HOMEPAGE_ENDPOINT);		
	}
	
	@Step
	public void verify_response_body(String message) {
		response.then().body(equalTo(message));
	}
	
	@Step
	public void verify_status_code(int statusCode) {
		response.then().statusCode(statusCode);
	}

	@Step
	public void verify_response_uaid() {
		response.then().cookie("uaid");
	}
}
