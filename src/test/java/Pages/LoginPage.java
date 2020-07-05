package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.BaseDriver;
import utilities.Log;
import utilities.ReusableMethods;

public class LoginPage extends BaseDriver {

    ReusableMethods reusableMethods = new ReusableMethods();

    @FindBy(id="sign_in_button")
    private WebElement signInButton;

    @FindBy(id="signin_to_yourAccount")
    private WebElement signInPage;

    @FindBy(xpath="//android.widget.EditText[@resource-id='ap_email_login']")
    private WebElement emailField;

    @FindBy(xpath="//android.widget.Button[@resource-id='continue']")
    private WebElement continueButton;

    @FindBy(xpath="//android.widget.EditText[@resource-id='ap_password']")
    private WebElement passwordField;

    @FindBy(xpath="//android.widget.Button[@resource-id='signInSubmit']")
    private WebElement signInSubmitButton;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public void assertUserOnSignInPage() throws InterruptedException {
        Log.info("waiting for the element to be visible" + signInButton );
        reusableMethods.waitUntilElementVisible(driver,signInButton);
        Log.info("asserting sign in page displayed or not:" + signInButton.isDisplayed() );
        Assert.assertTrue(signInPage.isDisplayed());
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void enterEmail(String username) throws InterruptedException {
        Thread.sleep(5000);
        Log.info("waiting for the element to be visible" + emailField );
        reusableMethods.waitUntilElementVisible(driver,emailField);
        emailField.clear();
        Log.info("enter email: "+username);
        emailField.sendKeys(username);
    }

    public void enterPassword(String password) {
        reusableMethods.waitUntilElementClickable(driver,passwordField);
        passwordField.clear();
        Log.info("enter email: "+password);
        passwordField.sendKeys(password);
    }

    public void submitSignIn() {
        signInSubmitButton.click();
        Log.info("submitted login successfully");
    }

    public void submitEmail() {
        continueButton.click();
        Log.info("submitted email successfully");
    }
}
