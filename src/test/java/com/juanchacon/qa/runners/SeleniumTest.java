package com.juanchacon.qa.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
    key = GLUE_PROPERTY_NAME,
    value = "com.juanchacon.qa.stepdefinitions"
)
@ConfigurationParameter(
    key = PLUGIN_PROPERTY_NAME,
    value = "net.serenitybdd.cucumber.core.plugin.SerenityReporterParallel,pretty"
)
public class SeleniumTest {
}