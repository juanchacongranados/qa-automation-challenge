package com.juanchacon.qa.ui;

import net.serenitybdd.screenplay.targets.Target;

public class SeleniumHomePage {

    public static final String URL = "https://www.selenium.dev/";

    public static final Target SELENIUM_LOGO = Target
        .the("Selenium logo")
        .locatedBy(".navbar-brand .navbar-logo");

    private SeleniumHomePage() {
    }
}