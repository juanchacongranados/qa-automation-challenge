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
            
    private SeleniumHomePage() {
    }
}