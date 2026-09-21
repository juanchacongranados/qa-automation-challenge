package com.juanchacon.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUsers implements Performable {

    private final int page;

    public GetUsers(int page) {
        this.page = page;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/api/users")
                        .with(request -> request.queryParam("page", page))
        );
    }

    public static Performable fromPage(int page) {
        return instrumented(GetUsers.class, page);
    }
}