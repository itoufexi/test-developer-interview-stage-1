package com.db.am.bauhaus.project.pages;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPage extends PageObject {
	
    @FindBy(css = "#listing-page-cart-inner>h1>span")
    WebElementFacade name;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

	public String getProductName() {
		return name.getText();
	}
	
}
