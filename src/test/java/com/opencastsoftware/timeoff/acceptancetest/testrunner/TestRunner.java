package com.opencastsoftware.timeoff.acceptancetest.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Feature",glue={"com.opencastsoftware.timeoff.acceptancetest.stepdefinition"},
plugin={"html:target/cucumber-html-report","json:target/cucumber-report.json" } )
public class TestRunner {

}
