package com.db.am.bauhaus.project.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MainPage extends PageObject {
	
    @FindBy(css = "[data-palette-listing-image=\"\"]")
    List<WebElementFacade> icons;

    public MainPage(WebDriver driver) {
        super(driver);
    }

	public String search_from_icon() {
        WebElementFacade icon = icons.get(new Random().nextInt(icons.size()));
		String title = icon.getAttribute("title");
		icon.click();
		return title;
	}
}
