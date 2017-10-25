package com.db.am.bauhaus.project;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Created by ongshir on 06/04/2017.
 */
public class SearchTarget {
    public final static Target INPUT_BOX = Target.the("the search input box").located(By.id("search-query"));
    public final static Target INPUT_BOX_BUTTON = Target.the("the search input button").located(By.cssSelector(".btn.btn-primary"));
    public final static Target ALL_CATEGORIES_LINK = Target.the("the all categories link").located(By.cssSelector(".text-smaller.text-link-secondary>span"));
    public final static Target CUSTOM_LINK = Target.the("the custom link").located(By.cssSelector(".display-inline.text-smaller"));
}
