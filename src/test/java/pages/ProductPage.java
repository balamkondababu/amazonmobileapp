package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.BaseDriver;
import utilities.Log;
import utilities.ReusableMethods;

import java.util.HashMap;

public class ProductPage extends BaseDriver {

    ReusableMethods reusableMethods = new ReusableMethods();

    @FindBy(xpath="//android.view.View[@resource-id='bylineInfo']")
    private WebElement productBrand;

    @FindBy(xpath ="//android.view.View[@resource-id='title_feature_div']")
    private WebElement productName;

    @FindBy(xpath ="//android.view.View[@resource-id='atfRedesign_priceblock_priceToPay']")
    private WebElement productPrice;


    public ProductPage(){
        PageFactory.initElements(driver,this);
    }

    public void verifyProductBrand(HashMap<String,String> infoProductPage) {
        Log.info("verifying Brand name in product page");
        reusableMethods.waitUntilElementVisible(driver,productName);
        Assert.assertTrue(productBrand.isDisplayed());
        infoProductPage.put("brand",productBrand.getText());
    }

    public void verifyProductName(HashMap<String,String> infoProductPage) {
        Log.info("verifying product name in product page");
        Assert.assertTrue(productName.isDisplayed());
        infoProductPage.put("name",productName.getText());
    }

    public void verifyProductPrice(HashMap<String,String> infoProductPage) {
        Log.info("verifying product name in product page");
        Assert.assertTrue(productPrice.isDisplayed());
        infoProductPage.put("price",productPrice.getText());
    }

    public void addToCart(String addCart) {
        Log.info("adding product to the cart");
        reusableMethods.scrollToTextAndClick(driver,addCart);
    }

    public void proceedToCheckout(String value) {
        Log.info("clicking in proceed to checkout");
        reusableMethods.scrollToTextAndClick(driver,"Proceed to Buy");
    }
}
