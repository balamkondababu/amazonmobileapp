package utilities;

import Pages.LoginPage;
import Pages.SearchAndCheckOutPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseDriver {

    public static AppiumDriver<WebElement> driver = null;
    public LoginPage loginPage = null;
    public SearchAndCheckOutPage searchAndCheckOutPage = null;

    public void setCapabilities() throws MalformedURLException {

        File f = new File("src");
        File fs = new File(f, "Amazon_shopping.apk");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "5203087ef42fb495");
        //caps.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.amazon.mShop.android.shopping");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.amazon.mShop.splashscreen.StartupActivity");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub/"), caps);
    }

    public WebDriver setup() throws MalformedURLException {
        if(driver == null) {
            setCapabilities();
            loginPage = new LoginPage();
            searchAndCheckOutPage = new SearchAndCheckOutPage();
        }
        return driver;
    }
}
