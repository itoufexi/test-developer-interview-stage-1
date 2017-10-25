package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.pages.MainSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchUser extends ScenarioSteps {

    MainSearchPage mainSearchPage;

    private static final String SEARCHTEXT = "craft";
    private static final String ALL_CATEGORIES = "All categories";

    @Step
    public void search_from_input_box() {
        mainSearchPage.searchFromInputBox(SEARCHTEXT);
    }

    @Step
    public void verify_result_for_all_categories_link() {
        assertThat(mainSearchPage.getAllCategoriesLinkText(), containsString(ALL_CATEGORIES));
    }

    @Step
    public void verify_result_for_custom_link() {
        assertThat(mainSearchPage.getCustomLinkText(), containsString(SEARCHTEXT));
    }
}
