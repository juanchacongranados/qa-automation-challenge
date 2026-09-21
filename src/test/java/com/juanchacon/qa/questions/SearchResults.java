package com.juanchacon.qa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static com.juanchacon.qa.ui.SeleniumHomePage.SEARCH_RESULTS;

public class SearchResults implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor) {
        return SEARCH_RESULTS
                .resolveAllFor(actor)
                .stream()
                .map(element -> element.getText())
                .toList();
    }

    public static SearchResults displayed() {
        return new SearchResults();
    }
}