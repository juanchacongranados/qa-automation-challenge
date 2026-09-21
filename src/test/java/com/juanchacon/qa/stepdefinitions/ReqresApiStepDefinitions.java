package com.juanchacon.qa.stepdefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import com.juanchacon.qa.tasks.GetUsers;
import io.cucumber.java.en.When;

import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.empty;

import com.juanchacon.qa.tasks.CreateUser;

import static org.hamcrest.Matchers.notNullValue;

import com.juanchacon.qa.tasks.UpdateUser;


public class ReqresApiStepDefinitions {

    private static final String REQRES_BASE_URL = "https://reqres.in";

    @Given("{word} uses the ReqRes API")
    public void usesTheReqResApi(String actorName) {
        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled(actorName)
                .whoCan(CallAnApi.at(REQRES_BASE_URL));
    }

    @When("he requests the users from page {int}")
    public void heRequestsTheUsersFromPage(int page) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetUsers.fromPage(page)
        );
    }

    @When("he creates a user named {string} with job {string}")
    public void heCreatesAUserNamedWithJob(String name, String job) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CreateUser.with(name, job)
        );
    }

    @When("he updates user {int} with name {string} and job {string}")
    public void heUpdatesUserWithNameAndJob(int userId, String name, String job) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                UpdateUser.with(userId, name, job)
        );
    }

    @Then("the users response should be successful")
    public void theUsersResponseShouldBeSuccessful() {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("The users request is successful",
                        response -> response.statusCode(200)
                )
        );
    }

    @Then("the response should contain users from page {int}")
    public void theResponseShouldContainUsersFromPage(int page) {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("The response contains users for the requested page",
                        response -> response
                                .body("page", equalTo(page))
                                .body("data", not(empty()))
                )
        );
    }

    @Then("the user should be created successfully")
    public void theUserShouldBeCreatedSuccessfully() {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("The user is created successfully",
                        response -> response
                                .statusCode(201)
                                .body("id", notNullValue())
                                .body("createdAt", notNullValue())
                )
        );
    }

    @Then("the created user should contain the submitted information")
    public void theCreatedUserShouldContainTheSubmittedInformation() {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("The created user contains the submitted information",
                        response -> response
                                .body("name", equalTo("Juan Chacon"))
                                .body("job", equalTo("QA Automation Engineer"))
                )
        );
    }

    @Then("the user should be updated successfully")
    public void theUserShouldBeUpdatedSuccessfully() {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("The user is updated successfully",
                        response -> response
                                .statusCode(200)
                                .body("updatedAt", notNullValue())
                )
        );
    }

    @Then("the updated user should contain the submitted information")
    public void theUpdatedUserShouldContainTheSubmittedInformation() {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("The updated user contains the submitted information",
                        response -> response
                                .body("name", equalTo("Juan Chacon"))
                                .body("job", equalTo("Senior QA Automation Engineer"))
                )
        );
    }
}