package com.nahorny.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/nahorny/cucumber",
//        glue = "src/test/java/com/nahorny/cucumber", // path to package contains steps implementation

//        tags = {"@my_first_tag", "@my_second_tag"}, //filtering tests
        tags = "@my_first_tag",
//        tags = "@my_second_tag",

//        name = "^RegEx.*" //filtering tests, could not be used with tags

        dryRun = false, // check all steps implementation, generate warning when get unimplemented test (false) or at once after start
        strict = false, // stop run wits error (true) or miss (false) unimplemented step

        plugin = {"pretty", "html:target/cucumber-reports",
                "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml"}, //reporter, see /target/cucumber-reports/index
        monochrome = false, // makes report monochrome
        snippets = SnippetType.UNDERSCORE // format of naming for unimplemented step
)
public class CucumberTestRunner {
}
