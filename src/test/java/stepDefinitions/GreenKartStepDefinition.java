package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;

public class GreenKartStepDefinition {
    public WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    public String landingPageProductName;
    public String offerPageProductName;


    @Given("user is on GreenCard Landing page")
    public void user_is_on_green_card_landing_page() {
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }


    @When("user searched with shortname {string} and extract actual name of product")
    public void user_searched_with_shortname_and_extract_actual_name_of_product(String string) {
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
        landingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(landingPageProductName + " is extracted from Home page");

    }


    @Then("user search for {string} shortname in offers page")
    public void user_search_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> iterator = s1.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_Landing_Page() {}
}
