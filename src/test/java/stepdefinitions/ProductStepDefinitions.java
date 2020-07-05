package stepdefinitions;

import pages.ProductPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.HashMap;

public class ProductStepDefinitions {

    ProductPage productPage = new ProductPage();

    HashMap<String,String> infoProductPage = new HashMap<String,String>();

    @Then("^I verify product information in product page$")
    public void iVerifyProductInformationInProductPage() {
        productPage.verifyProductBrand(infoProductPage);
        productPage.verifyProductName(infoProductPage);
        productPage.verifyProductPrice(infoProductPage);
    }

    @And("^I click on \"([^\"]*)\"$")
    public void iClickOn(String value) throws Throwable {
        if(value.contains("cart")) {
            productPage.addToCart(value);
        }else if (value.contains("proceed")){
            productPage.proceedToCheckout(value);
        }
    }
}
