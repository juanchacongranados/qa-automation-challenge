package com.juanchacon.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.juanchacon.qa.ui.SeleniumHomePage.SEARCH_BUTTON;
import static com.juanchacon.qa.ui.SeleniumHomePage.SEARCH_INPUT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchSeleniumDocumentation implements Performable {

    private final String searchTerm;

    public SearchSeleniumDocumentation(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SEARCH_BUTTON),
                Enter.theValue(searchTerm).into(SEARCH_INPUT)
        );
    }

    public static Performable forTerm(String searchTerm) {
        return instrumented(SearchSeleniumDocumentation.class, searchTerm);
    }
}