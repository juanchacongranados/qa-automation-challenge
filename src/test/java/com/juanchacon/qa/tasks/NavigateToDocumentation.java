package com.juanchacon.qa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;

import static com.juanchacon.qa.ui.SeleniumHomePage.DOCUMENTATION_LINK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToDocumentation implements Performable {

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DOCUMENTATION_LINK)
        );
    }

    public static Performable section() {
        return instrumented(NavigateToDocumentation.class);
    }
}