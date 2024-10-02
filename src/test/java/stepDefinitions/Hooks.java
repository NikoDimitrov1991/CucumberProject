package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

import java.io.IOException;

public class Hooks {
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        testContextSetup.testBase.WebDriverManager().quit();
    }

}
