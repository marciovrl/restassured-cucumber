package com.example.support;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/features" }, glue = { "com/example/steps/" }, tags = { "~@notImplemented" })
public class CucumberRunner {
}