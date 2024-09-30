package stepDefinitions;


import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.picocontainer.annotations.Inject;
import org.testng.Assert;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {
    public String offerPageProductName;

    @Inject
    TestContextSetup testContextSetup;

    @Then("user search for {string} shortname in offers page")
    public void user_search_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
        switchToOfferPage();
        testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        offerPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
    }

    public void switchToOfferPage()  {
        if (!testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {
            testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
            Set<String> s1 = testContextSetup.driver.getWindowHandles();
            Iterator<String> iterator = s1.iterator();
            String parentWindow = iterator.next();
            String childWindow = iterator.next();
            testContextSetup.driver.switchTo().window(childWindow);
        }
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_Landing_Page() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }
}
