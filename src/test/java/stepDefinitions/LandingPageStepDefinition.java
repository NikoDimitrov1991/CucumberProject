package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {


    LandingPage landingPage;
    TestContextSetup testContextSetup;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("user is on GreenCard Landing page")
    public void user_is_on_green_card_landing_page() {
        Assert.assertTrue(landingPage.getLandingPageTitle().contains("GreenKart"));

    }

    @When("^user searched with shortname (.+) and extract actual name of product$")
    public void user_searched_with_shortname_and_extract_actual_name_of_product(String shortName) throws InterruptedException {
        landingPage.searchItem(shortName);
        Thread.sleep(2000);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName + " is extracted from Home page");
    }

    @When("Added {string} items of the selected product to cart")
    public void added_items_of_the_selected_product_to_cart(String quantity) {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();

    }
}
