import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utilities.Log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(Cucumber.class)

@CucumberOptions(  monochrome = true,
        tags = "~@ignore",
        features = "src/test/resources/features/",
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"},
        dryRun = false,
        glue = "stepdefinitions" )

public class TestRunner {

    @BeforeClass
    public static void setupReport() {
        Log.startLog( "Test Starts Here");
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("cucumber-reports/"+timeStamp.replace(":","_").replace(".","_")+".html");
    }

    @AfterClass
    public static void writeExtentReport() {

        Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Log.endLog("Test Ends Here");
    }
}