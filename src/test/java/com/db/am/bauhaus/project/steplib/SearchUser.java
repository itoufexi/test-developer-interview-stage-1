package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.pages.CommonItems;
import com.db.am.bauhaus.project.pages.MainPage;
import com.db.am.bauhaus.project.pages.MainSearchPage;
import com.db.am.bauhaus.project.pages.ProductPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchUser extends ScenarioSteps {

    private MainSearchPage mainSearchPage;
    private CommonItems commonItems;
    private MainPage mainPage;
    private ProductPage productPage;
	private String productName;

    private static final String SEARCHTEXT = "craft";
    private static final String ALL_CATEGORIES = "All categories";

    @Step
    public void search_from_input_box() {
    	commonItems.searchFromInputBox(SEARCHTEXT);
    }
    
    @Step
    public void search_from_dropdown(String category, String subCategory) {
    	commonItems.searchFromDropdown(category, subCategory);
    }
    
    @Step
	public void search_from_icon() {
    	productName = mainPage.search_from_icon();
	}

    @Step
    public void verify_result_for_all_categories_link() {
        assertThat(mainSearchPage.getAllCategoriesLinkText(), containsString(ALL_CATEGORIES));
    }

    @Step
    public void verify_result_for_custom_link() {
        assertThat(mainSearchPage.getCustomLinkText(), containsString(SEARCHTEXT));
    }
    
    @Step
    public void verify_result_for_title(String title) {
        assertThat(mainSearchPage.getHeadingText(), containsString(title));
    }

    @Step
	public void verify_product() {
        assertThat(productPage.getProductName().replaceAll("\\s+",""), containsString(productName.replaceAll("\\s+","")));
	}

}
