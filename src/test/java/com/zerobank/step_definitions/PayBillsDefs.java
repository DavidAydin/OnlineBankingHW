package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.Map;

public class PayBillsDefs {
    @When("the user selects the payee as {string}")
    public void the_user_selects_the_payee_as(String payee) {
        Select select =new Select(new PayBillsPage().payeeSelect);
        select.selectByVisibleText(payee);
       
    }
    
    @When("the user selects the account as {string}")
    public void the_user_selects_the_account_as(String accountType) {
        Select select =new Select(new PayBillsPage().accountSelect);
        select.selectByVisibleText(accountType);
        
    }
    
    @When("the user enters the transfer amount as {string}")
    public void the_user_enters_the_transfer_amount_as(String amount) {
       new PayBillsPage().amountBox.sendKeys(amount);
       
    
    }
    
    @When("the user enters the transfer date as {string}")
    public void the_user_enters_the_transfer_date_as(String date) {
        new PayBillsPage().dateBox.sendKeys(date);
       
    
    }
    
    @When("the user enters the transfer description as {string}")
    public void the_user_enters_the_transfer_description_as(String description) {
        new PayBillsPage().descriptionBox.sendKeys(description);
        
    
    }
    
    @When("the user clicks the Pay button")
    public void the_user_clicks_the_Pay_button() throws InterruptedException {
        new PayBillsPage().paySubmitButton.click();
        
       

    }
    
    @Then("the user gets the following payment result message")
    public void the_user_gets_the_following_payment_result_message(String expectedMessage) {
        String actualPaymentResultMessage = new PayBillsPage().paymentResultMessage.getText();
        System.out.println("actualPaymentResultMessage = " + actualPaymentResultMessage);
        Assert.assertEquals("verify payment successful message",expectedMessage,actualPaymentResultMessage);
    }
    
    @Then("the transfer amount validation message should pop up as follows")
    public void the_transfer_amount_validation_message_should_pop_up_as_follows(String expectedErrorMessage) {
        String actualErrorMessage = new PayBillsPage().amountBox.getAttribute("validationMessage");
        Assert.assertEquals("verify amount message",expectedErrorMessage,actualErrorMessage);
      
    }
    @Then("the date validation message should pop up as follows")
    public void the_date_validation_message_should_pop_up_as_follows(String expectedErrorMessage) {
        String actualErrorMessage = new PayBillsPage().dateBox.getAttribute("validationMessage");
        Assert.assertEquals("verify amount message",expectedErrorMessage,actualErrorMessage);
        
    }
    
    @Then("the amount box should be empty")
    public void the_amount_box_should_be_empty() {
       String verificationMessage="verify that the amount box does not accept alphabetical and special characters " +
               "and should be therefore empty";
       Assert.assertEquals(verificationMessage,"", new PayBillsPage().amountBox.getAttribute("value"));
    }
    
    @Then("the date box should be empty")
    public void the_date_box_should_be_empty() {
        String verificationMessage="verify that the date box does not accept alphabetical and should be therefore empty";
        BrowserUtils.waitFor(7);
        Assert.assertEquals(verificationMessage,"", new PayBillsPage().dateBox.getAttribute("value"));
    }
    
    @And("the user clicks on {string} tab on the Pay Bills page")
    public void theUserClicksOnTabOnThePayBillsPage(String tabName) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.navigateToPayBillsTab(tabName);
        new WebDriverWait(Driver.get(),5).until(ExpectedConditions.elementToBeClickable(payBillsPage.addNewPayee_name));
    }
    
  
}
