package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.BaseDriver;
import utilities.Log;
import utilities.ReusableMethods;

import java.util.List;

public class SearchPage extends BaseDriver {

    ReusableMethods reusableMethods = new ReusableMethods();

    int itemCount = 0;

    @FindBy(id="web_home_shop_by_department_label")
    private WebElement searchShopBy;

    @FindBy(id="rs_search_src_text")
    private WebElement searchField;

    @FindBy(id="iss_search_dropdown_item_suggestions")
    private List<WebElement> itemSuggestions;

    @FindBy(className="android.widget.LinearLayout")
    private WebElement searchResults;

    @FindBy(id="rs_results_count_text")
    private WebElement searchResultsCount;

    @FindBy(id="item_title")
    private WebElement itemTitle;

    public SearchPage(){
        PageFactory.initElements(driver,this);
    }

    public void assertUserOnHomePage() {
        reusableMethods.waitUntilElementVisible(driver,searchShopBy);
        Log.info("asserting user on home page or not: "+ searchShopBy.isDisplayed());
        Assert.assertTrue(searchShopBy.isDisplayed());
    }

    public void searchForProduct(String product) throws InterruptedException {
        searchField.click();
        reusableMethods.waitUntilElementVisible(driver,searchField);
        searchField.sendKeys(product);
        reusableMethods.waitUntilElementVisible(driver,itemSuggestions.get(0));
        itemSuggestions.get(0).click();
    }

    public void assertSearchResultsDisplayedOrNot() {
        Log.info("asserting search results displayed or not: "+ searchResults.isDisplayed());
        Assert.assertTrue(searchResults.isDisplayed());
    }

    public void assertAndGetSearchResultsCount() {
        reusableMethods.waitUntilElementVisible(driver,searchResultsCount);
        Assert.assertTrue(searchResultsCount.isDisplayed());
        itemCount = Integer.parseInt(searchResultsCount.getText().split(" ")[0].trim());
        Log.info("search results count: "+ itemCount);
    }

    public void selectProductFromSearchResults(String brand) {
        Log.info("selecting random product");
        reusableMethods.scrollToTextAndClick(driver,brand);
    }
}
