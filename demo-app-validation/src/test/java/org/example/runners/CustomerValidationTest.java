package org.example.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features" }, glue = { "org.example.step.definitions" }, tags = { "~@Ignore" })
public class CustomerValidationTest {

}
