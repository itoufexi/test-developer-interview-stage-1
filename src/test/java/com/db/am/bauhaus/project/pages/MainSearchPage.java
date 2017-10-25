package com.db.am.bauhaus.project.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

/**
 * Created by ongshir on 05/10/2016.
 */
@DefaultUrl("/")
public class MainSearchPage extends PageObject {

    @FindBy(id = "search-query")
    WebElementFacade inputBox;

    @FindBy(css = ".btn.btn-primary")
    WebElementFacade searchButton;
    
    @FindBy(css = ".text-smaller.text-link-secondary>span")
    WebElementFacade allCategoriesLink;
    
    @FindBy(css = ".display-inline.text-smaller")
    WebElementFacade customLink;

    public MainSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFromInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
        searchButton.click();
    }

    public String getAllCategoriesLinkText() {
    	return allCategoriesLink.getText();
    }

    public String getCustomLinkText() {
    	return customLink.getText();
    }
}
