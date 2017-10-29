package com.db.am.bauhaus.project.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CommonItems extends PageObject {

    @FindBy(id = "search-query")
    WebElementFacade inputBox;

    @FindBy(css = ".btn.btn-primary")
    WebElementFacade searchButton;
    
    @FindBy(css= "[id^=catnav-primary-link-]")
    List<WebElementFacade> categories;
    
    public CommonItems(WebDriver driver) {
        super(driver);
    }

    public void searchFromInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
        searchButton.click();
    }
	
    public void searchFromDropdown(String categoryTitle, String subCategoryTitle) {
    	WebElementFacade category = getFromMenu(categoryTitle);
    	category.click();
        WebElementFacade subcategory = find(By.partialLinkText(subCategoryTitle));
        subcategory.waitUntilPresent().click();
    }
    
    private WebElementFacade getFromMenu(String title) {
    	WebElementFacade element = null;
    	for(int i=0;i<categories.size();i++) {
    		if (title.equals(categories.get(i).getText())) {
    			element = categories.get(i);
    			break;
    		}
    	}
    	if (element==null) {
    		throw new RuntimeException("Category not found");
    	}
    	else {
    		return element;
    	}
    }
}
