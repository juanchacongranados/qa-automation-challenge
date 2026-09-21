package com.juanchacon.qa.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SeleniumDocumentationPage {

public static final Target DOCUMENTATION_HEADING = Target
        .the("Selenium documentation heading")
        .located(By.cssSelector("h1"));

    private SeleniumDocumentationPage() {
    }
}