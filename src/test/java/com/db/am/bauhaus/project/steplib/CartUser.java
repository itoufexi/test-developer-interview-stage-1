package com.db.am.bauhaus.project.steplib;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import com.db.am.bauhaus.project.pages.CartPage;
import com.db.am.bauhaus.project.pages.MainPage;

import net.thucydides.core.annotations.Step;

public class CartUser {
	
	private MainPage mainPage;
	private CartPage cartPage;

	@Step
	public void view_cart() {
		mainPage.viewCart();
	}

	@Step
	public void verify_cart_empty() {
        assertThat(cartPage.empty_message(), containsString("Your cart is empty."));
	}

}
