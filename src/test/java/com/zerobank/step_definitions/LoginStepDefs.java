package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.ChromeSecurityPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.StartPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginStepDefs {
    
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        Driver.get().navigate().to(ConfigurationReader.get("url"));
        StartPage startPage = new StartPage();
        startPage.proceedToSignIn.click();
    }
    
    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String usernameKey, String passwordKey) {
        String username = ConfigurationReader.get(usernameKey);
        String password = ConfigurationReader.get(passwordKey);
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.LoginSubmitButton.click();
        new ChromeSecurityPage().dismissChromeSecurityWarning();
        new AccountSummaryPage().dismissPasswordChangeAlert();
        
    }
    
    @Then("the user should land in {string} page")
    public void the_user_should_land_in(String expectedPageTitle) {
        expectedPageTitle = "Zero - " +expectedPageTitle;
        String actualPageTitle = Driver.get().getTitle();
        String verificationMessage = "Verify that the page title is: " +expectedPageTitle;
        Assert.assertEquals(verificationMessage,expectedPageTitle,actualPageTitle);
        
    }
    
    @Then("the webpage return following error message")
    public void the_webpage_return_following_error_message(String expectedErrorMessage) {
        LoginPage loginPage = new LoginPage();
        String actualErrorMessage = loginPage.errorMessageBox.getText();
        String verificationMessage = "Verify error Message is: " + expectedErrorMessage;
        Assert.assertEquals(verificationMessage,expectedErrorMessage,actualErrorMessage);
        
    }
}
