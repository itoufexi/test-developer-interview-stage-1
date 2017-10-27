package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.SearchFor;
import com.db.am.bauhaus.project.SearchTarget;
import com.db.am.bauhaus.project.SessionVar;
import com.db.am.bauhaus.project.pages.MainSearchPage;
import com.db.am.bauhaus.project.steplib.SearchUser;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchSteps {

    @Before
    public void before() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Steps
    SearchUser user;

    MainSearchPage mainSearchPage;

    @Given("^John is viewing the Etsy landing page$")
    public void goto_landing_page() {
        mainSearchPage.open();
    }

    @Given("^([^\\s]+) is viewing the Etsy landing page \\(screenplay\\)$")
    public void goto_landing_page_screenplay(String theUser) {
        theActorCalled(theUser).attemptsTo(Open.browserOn().the(mainSearchPage));
    }

    @When("^he searches for a product from the input box$")
    public void search_from_input_box() {
        user.search_from_input_box();
    }
    
    @When("^he searches for '(.*)' under '(.*)' from the dropdown$")
    public void search_from_dropdown(String subCategory, String category) {
        user.search_from_dropdown(category, subCategory);
    }
    
    @When("^he searches for a product from an icon$")
    public void search_from_icon() {
        user.search_from_icon();
    }

    @When("^he searches for a product from the input box \\(screenplay\\)$")
    public void search_from_input_box_screenplay() {
        theActorInTheSpotlight().attemptsTo(SearchFor.randomText());
    }

    @Then("^the result should be displayed$")
    public void verify_search_result() {
        user.verify_result_for_all_categories_link();
        user.verify_result_for_custom_link();
    }
    
    @Then("^the page for '(.*)' should be displayed$")
    public void verify_category_page(String title) {
        user.verify_result_for_title(title);
    }
    
    @Then("^the product from the icon should be displayed$")
    public void verify_product() {
        user.verify_product();
    }

    @Then("^the result should be displayed \\(screenplay\\)$")
    public void verify_search_result_screenplay() {
        String searchText = Serenity.sessionVariableCalled(SessionVar.SEARCH_TEXT).toString();
        theActorInTheSpotlight().should(
                seeThat("the top categories link ", the(SearchTarget.ALL_CATEGORIES_LINK), containsText("All categories")),
                seeThat("the custom link ", the(SearchTarget.CUSTOM_LINK), containsText(searchText))
        		);
    }
}
