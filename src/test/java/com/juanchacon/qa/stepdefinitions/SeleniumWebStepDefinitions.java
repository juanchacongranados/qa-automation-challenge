package com.juanchacon.qa.stepdefinitions;

import com.juanchacon.qa.tasks.OpenSeleniumWebsite;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import com.juanchacon.qa.questions.PageTitle;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

import com.juanchacon.qa.ui.SeleniumHomePage;

public class SeleniumWebStepDefinitions {

    @Given("{word} opens the Selenium website")
    public void opensTheSeleniumWebsite(String actorName) {
        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled(actorName).attemptsTo(
                OpenSeleniumWebsite.homePage()
        );
    }

    @Then("the Selenium home page should be displayed")
    public void theSeleniumHomePageShouldBeDisplayed() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        "Selenium logo is visible",
                        actor -> SeleniumHomePage.SELENIUM_LOGO.resolveFor(actor).isVisible()
                )
        );
    }

    @Then("the page title should contain {string}")
    public void thePageTitleShouldContain(String expectedTitle) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(PageTitle.displayed(), containsString(expectedTitle))
        );
    }
}