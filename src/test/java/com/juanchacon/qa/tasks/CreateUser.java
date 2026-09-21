package com.juanchacon.qa.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateUser implements Performable {

    private final String name;
    private final String job;

    public CreateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/api/users")
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .body(Map.of(
                                        "name", name,
                                        "job", job
                                )))
        );
    }

    public static Performable with(String name, String job) {
        return instrumented(CreateUser.class, name, job);
    }
}