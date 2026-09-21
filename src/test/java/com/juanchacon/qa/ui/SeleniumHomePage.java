package com.juanchacon.qa.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SeleniumHomePage {

    public static final String URL = "https://www.selenium.dev/";

    public static final Target SELENIUM_LOGO = Target
        .the("Selenium logo")
        .locatedBy(".navbar-brand .navbar-logo");

    public static final Target DOCUMENTATION_LINK = Target
            .the("Documentation navigation link")
            .located(By.cssSelector("a.nav-link[href='/documentation']"));

    public static final Target SEARCH_BUTTON = Target
        .the("Selenium documentation search button")
        .located(By.cssSelector(".DocSearch-Button"));

    public static final Target SEARCH_INPUT = Target
            .the("Selenium documentation search input")
            .located(By.id("docsearch-input"));

    public static final Target SEARCH_RESULTS = Target
            .the("Selenium documentation search results")
            .located(By.cssSelector(".DocSearch-Hit"));
            
    private SeleniumHomePage() {
    }
}