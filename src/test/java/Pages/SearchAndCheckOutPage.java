package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.BaseDriver;
import utilities.ReusableMethods;

import java.util.List;

public class SearchAndCheckOutPage extends BaseDriver {

    ReusableMethods reusableMethods = new ReusableMethods();

    int itemCount = 0;

    @FindBy(id="web_home_shop_by_department_label")
    private WebElement searchShopBy;

    @FindBy(id="rs_search_src_text1")
    private WebElement searchField;

    @FindBy(id="iss_search_dropdown_item_suggestions")
    private List<WebElement> itemSuggestions;

    @FindBy(className="android.widget.LinearLayout")
    private WebElement searchResults;

    @FindBy(id="rs_results_count_text")
    private WebElement searchResultsCount;

    @FindBy(id="item_title")
    private WebElement itemTitle;

    @FindBy(xpath="//android.view.View[resource-id=''a-autoid-3]")
    private WebElement buyButton;

    @FindBy(className="android.view.View")
    private WebElement productDescription;

    @FindBy(xpath ="//*[@resource-id='titleExpanderContent']")
    private WebElement prodcutName;



    public SearchAndCheckOutPage(){
        PageFactory.initElements(driver,this);
    }

    public void assertUserOnHomePage() {
        reusableMethods.waitUntilElementVisible(driver,searchShopBy);
        Assert.assertTrue(searchShopBy.isDisplayed());
    }

    public void searchForProduct(String product) throws InterruptedException {
        searchField.click();
        Thread.sleep(2000);
        reusableMethods.waitUntilElementVisible(driver,searchField);
        searchField.sendKeys(product);
        Thread.sleep(3000);
        itemSuggestions.get(0).click();
    }

    public void assertSearchDisplayedOrNot() {
        Assert.assertTrue(searchResults.isDisplayed());
    }

    public void assertAndGetSearchResultsCount() {
        reusableMethods.waitUntilElementVisible(driver,searchResultsCount);
        Assert.assertTrue(searchResultsCount.isDisplayed());
        itemCount = Integer.parseInt(searchResultsCount.getText().split(" ")[0].trim());
    }

    public void selectProductFromSearchResults(String brand) {
        reusableMethods.scrollToTextAndClick(driver,brand);
        reusableMethods.waitUntilElementVisible(driver,prodcutName);
    }

    public void addToCart(String addCart) {
        reusableMethods.scrollToTextAndClick(driver,addCart);
    }
}
