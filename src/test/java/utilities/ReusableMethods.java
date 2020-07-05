package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {

    public void waitUntilElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToTextAndClick(AppiumDriver<WebElement> driver,String text) {
        MobileElement element = (MobileElement) ((FindsByAndroidUIAutomator) driver)
                .findElementByAndroidUIAutomator("new UiScrollable("
                        + "new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().textContains(\""+text+"\"));");
        element.click();
    }
}
