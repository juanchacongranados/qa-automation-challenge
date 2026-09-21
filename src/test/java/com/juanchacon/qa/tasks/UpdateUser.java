package com.juanchacon.qa.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateUser implements Performable {

    private final int userId;
    private final String name;
    private final String job;

    public UpdateUser(int userId, String name, String job) {
        this.userId = userId;
        this.name = name;
        this.job = job;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/api/users/" + userId)
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .body(Map.of(
                                        "name", name,
                                        "job", job
                                )))
        );
    }

    public static Performable with(int userId, String name, String job) {
        return instrumented(UpdateUser.class, userId, name, job);
    }
}