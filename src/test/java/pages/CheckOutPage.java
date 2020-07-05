package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.BaseDriver;
import utilities.Log;
import utilities.ReusableMethods;

import java.util.HashMap;

public class CheckOutPage extends BaseDriver {

    ReusableMethods reusableMethods = new ReusableMethods();
    ProductPage productPage = new ProductPage();

    @FindBy(xpath="//android.view.View[@resource-id='bylineInfo']")
    private WebElement productBrand;

    @FindBy(xpath ="//android.view.View[@resource-id='title_feature_div']")
    private WebElement productName;

    @FindBy(xpath ="//android.view.View[@resource-id='atfRedesign_priceblock_priceToPay']")
    private WebElement productPrice;

    @FindBy(id ="com.amazon.mShop.android.shopping:id/action_bar_cart_image")
    private  WebElement cart;

    public CheckOutPage(){
        PageFactory.initElements(driver,this);
    }

    public void verifyProductBrand(HashMap<String,String> infoCheckOutPage) {
        Log.info("verifying brand name in checkout page");
        reusableMethods.waitUntilElementVisible(driver,productName);
        Assert.assertTrue(productBrand.isDisplayed());
        infoCheckOutPage.put("brand",productBrand.getText());
    }

    public void verifyProductName(HashMap<String,String> infoCheckOutPage) {
        Log.info("verifying product name in checkout page");
        Assert.assertTrue(productName.isDisplayed());
        infoCheckOutPage.put("name",productName.getText());
    }

    public void verifyProductPrice(HashMap<String,String> infoCheckOutPage) {
        Log.info("verifying product price in checkout page");
        Assert.assertTrue(productPrice.isDisplayed());
        infoCheckOutPage.put("price",productPrice.getText());
    }

    public void navigateToCart() {
        Log.info("navigating to cart");
        reusableMethods.waitUntilElementVisible(driver,cart);
        cart.click();
    }
}
