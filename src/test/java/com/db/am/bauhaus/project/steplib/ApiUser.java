package com.db.am.bauhaus.project.steplib;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;

public class ApiUser {

    private static final String OPENAPI_ENDPOINT = "https://openapi.etsy.com/v2/listings/active";
	
	private Response response;
	private RequestSpecification request;
	
	@Step
	public void create_a_request_with_no_api_key() {
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
	public void verify_response_body(String message) {
		response.then().body(equalTo(message));
	}
	
	@Step
	public void verify_status_code(int statusCode) {
		response.then().statusCode(statusCode);
	}
}
