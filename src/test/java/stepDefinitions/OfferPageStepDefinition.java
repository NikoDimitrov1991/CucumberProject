package stepDefinitions;


import io.cucumber.java.en.Then;
import org.picocontainer.annotations.Inject;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;


public class OfferPageStepDefinition {
    public String offerPageProductName;

    @Inject
    TestContextSetup testContextSetup;

    @Then("^user search for (.+) shortname in offers page$")
    public void user_search_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
        switchToOfferPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
        offersPage.searchItem(shortName);
        Thread.sleep(2000);
        offerPageProductName = offersPage.getProductName();
    }

    public void switchToOfferPage() {
//        if (!testContextSetup.driver.getCurrentUrl().contains("/seleniumPractise/#/offers")) {
            LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
            landingPage.selectTopDeals();
            testContextSetup.genericUtils.SwitchWindowToChild();
//        }
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_Landing_Page() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }
}
