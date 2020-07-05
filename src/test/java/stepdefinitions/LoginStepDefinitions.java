package stepdefinitions;

import pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DataLoader;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("^I am on the amazon app sign in Page$")
    public void iAmOnTheAmazonAppSignInPage() throws InterruptedException {
        loginPage.assertUserOnSignInPage();
    }

    @When("^I click on already a customer sign in button$")
    public void iClickOnAlreadyACustomerSignInButton() {
        loginPage.clickSignInButton();
    }

    @Then("^I enter \"([^\"]*)\"$")
    public void iFillUsernameWith(String value) throws Throwable {
        if(value.equals("username")){
            loginPage.enterEmail(DataLoader.getData("user.json",value));
        } else if(value.equals("password")) {
            loginPage.enterPassword(DataLoader.getData("user.json",value));
        }
    }

    @And("^I click on Login button$")
    public void iClickOnLoginButton() {
        loginPage.submitSignIn();
    }

    @And("^I should see user login successfully$")
    public void iShouldSeeUserLoginSuccessfully() {
    }

    @And("^I click on continue button$")
    public void iClickOnContinueButton() {
        loginPage.submitEmail();
    }
}
