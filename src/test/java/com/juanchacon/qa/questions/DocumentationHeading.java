package com.juanchacon.qa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.juanchacon.qa.ui.SeleniumDocumentationPage.DOCUMENTATION_HEADING;

public class DocumentationHeading implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return DOCUMENTATION_HEADING
                .resolveFor(actor)
                .getText();
    }

    public static DocumentationHeading displayed() {
        return new DocumentationHeading();
    }
}