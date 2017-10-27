package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.steplib.CartUser;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CartSteps {

	@Steps
	CartUser user;
	
    @When("^he views the cart$")
    public void view_cart() {
        user.view_cart();
    }
    
    @Then("^the cart should be empty$")
    public void verify_cart_empty() {
        user.verify_cart_empty();
    }
	
}
