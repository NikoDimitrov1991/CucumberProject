package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    public void user_searched_with_shortname_and_extract_actual_name_of_product(String string) throws InterruptedException {
        testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
        Thread.sleep(2000);
        testContextSetup.landingPageProductName = testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(landingPageProductName + " is extracted from Home page");
    }
}
