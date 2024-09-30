package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

    ChromeOptions options = new ChromeOptions();
    public String landingPageProductName;

    TestContextSetup testContextSetup;

    // Constructor injection
    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("user is on GreenCard Landing page")
    public void user_is_on_green_card_landing_page() {
        options.addArguments("--disable-search-engine-choice-screen");
        testContextSetup.driver = new ChromeDriver();
        testContextSetup.driver.manage().window().maximize();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched with shortname {string} and extract actual name of product")
    public void user_searched_with_shortname_and_extract_actual_name_of_product(String shortName) throws InterruptedException {
        LandingPage landingPage = new LandingPage(testContextSetup.driver);
        landingPage.searchItem(shortName);
        Thread.sleep(2000);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(landingPageProductName + " is extracted from Home page");
    }
}
