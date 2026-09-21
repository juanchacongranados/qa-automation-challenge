package com.juanchacon.qa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import com.juanchacon.qa.ui.SeleniumHomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenSeleniumWebsite {

    public static Performable homePage() {
        return instrumented(OpenSeleniumHomePage.class);
    }

    public static class OpenSeleniumHomePage implements Performable {

        @Override
        public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Open.url(SeleniumHomePage.URL)
            );
        }
    }

    private OpenSeleniumWebsite() {
    }
}