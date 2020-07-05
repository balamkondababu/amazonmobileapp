package stepdefinitions;

import pages.CheckOutPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import utilities.BaseDriver;
import utilities.Log;

import java.util.HashMap;

public class CheckOutStepDefinitions extends BaseDriver {

    CheckOutPage checkOutPage = new CheckOutPage();
    ProductStepDefinitions ps =new ProductStepDefinitions();
    HashMap<String,String> infoCheckOutPage = new HashMap<String,String>();

    @Then("^I verify product information in checkout page$")
    public void iVerifyProductInformationInCheckoutPage() {
        checkOutPage.verifyProductBrand(infoCheckOutPage);
        checkOutPage.verifyProductName(infoCheckOutPage);
        checkOutPage.verifyProductPrice(infoCheckOutPage);
    }

    @And("^I compare product information between product page and checkout page$")
    public void iCompareProductInformationBetweenProductPageAndCheckoutPage() {
        Log.info("comparing product information between product page and checkout page");
        Assert.assertTrue(ps.infoProductPage.get("brand").equals(infoCheckOutPage.get("brand")));
        Assert.assertTrue(ps.infoProductPage.get("name").equals(infoCheckOutPage.get("name")));
        Assert.assertTrue(ps.infoProductPage.get("price").equals(infoCheckOutPage.get("price")));
    }

    @And("^I close the app$")
    public void iCloseTheApp() {
        Log.info("closing drive: "+driver.getCapabilities().getCapability("platformName"));
    }

    @And("^navigate to the Cart menu$")
    public void navigateToTheCartMenu() {
        checkOutPage.navigateToCart();
    }
}
