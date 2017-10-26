package com.db.am.bauhaus.project.pages;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Created by ongshir on 05/10/2016.
 */
@DefaultUrl("/")
public class MainSearchPage extends PageObject {
    
    @FindBy(css = ".text-smaller.text-link-secondary>span")
    WebElementFacade allCategoriesLink;
    
    @FindBy(css = ".display-inline.text-smaller")
    WebElementFacade customLink;
    
    @FindBy(css = ".float-left>h1")
    WebElementFacade heading;

    public MainSearchPage(WebDriver driver) {
        super(driver);
    }

    public String getAllCategoriesLinkText() {
    	return allCategoriesLink.getText();
    }

    public String getCustomLinkText() {
    	return customLink.getText();
    }
    
    public String getHeadingText() {
    	return heading.getText();
    }
}
