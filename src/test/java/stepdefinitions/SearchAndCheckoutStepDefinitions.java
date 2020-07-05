package stepdefinitions;

import Pages.SearchAndCheckOutPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.BaseDriver;
import utilities.DataLoader;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class SearchAndCheckoutStepDefinitions extends BaseDriver {

    SearchAndCheckOutPage searchAndCheckOutPage = new SearchAndCheckOutPage();

    @Given("^Launch the Amazon app$")
    public void launch_the_amazon_app() {
        System.out.println(driver.getCapabilities().getCapability("platformName"));
    }
    
    @Given("^I am on the amazon app homepage$")
    public void iAmOnTheAmazonAppHomepage() {
        searchAndCheckOutPage.assertUserOnHomePage();
    }

    @When("^I search for a \"([^\"]*)\"$")
    public void iClickOnSearchAndSearchForAProduct(String product) throws Throwable {
        searchAndCheckOutPage.searchForProduct(DataLoader.getData("product.json",product));
    }

    @Then("^I see search results for a product displayed$")
    public void iSeeSearchResultsForAProduct() {
        searchAndCheckOutPage.assertSearchDisplayedOrNot();
    }

    @Then("^I verify product name on search screen$")
    public void iVerifyProductNameOnSearchScreen() {
        searchAndCheckOutPage.assertSearchDisplayedOrNot();
    }

    @And("^I verify search results count displayed$")
    public void iVerifySearchResultsCountDisplayed() {
        searchAndCheckOutPage.assertAndGetSearchResultsCount();
    }

    @When("^I select random \"([^\"]*)\" product from search results$")
    public void iSelectRandomProductFromSearchResults(String brand) throws MalformedURLException, InterruptedException, FileNotFoundException {
        searchAndCheckOutPage.selectProductFromSearchResults(DataLoader.getData("product.json",brand));
    }

    @Then("^I click on \"([^\"]*)\"$")
    public void iClickOn(String addCart) {
        searchAndCheckOutPage.addToCart(addCart);
    }
}
