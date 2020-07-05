package stepdefinitions;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BaseDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks extends BaseDriver {

    @Before
    public void test() throws MalformedURLException {
        /**
         *  to setup all capabilities , launch the application
         */
        setupAppium();
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                /**
                 *  This code to take a screenshot when scenario got failed
                 */
                TakesScreenshot scrShot =((TakesScreenshot)driver);
                File sourcePath = scrShot.getScreenshotAs(OutputType.FILE);

                File destinationPath = new File(System.getProperty("user.dir") + "/cucumber-reports/screenshots/" + screenshotName + ".png");
                Files.copy(sourcePath, destinationPath);
                Reporter.addScreenCaptureFromPath("./screenshots/" + screenshotName +".png");
            } catch (IOException e) {
            }
        }
    }

    @Before(order = 0)
    public void closeDriver() {
        driver.quit();
    }
}
