package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class AddNewPayeeStepDefs {
    
    @When("the user enters the following data to add new Payee")
    public void theUserEntersTheFollowingDataToAddNewPayee(Map<String, String> payeeData) {
        PayBillsPage payBillsPage = new PayBillsPage();
        new WebDriverWait(Driver.get(),5).until(ExpectedConditions.elementToBeClickable(payBillsPage.addNewPayee_name));
        payBillsPage.addNewPayee_name.sendKeys(""+ Keys.SHIFT+Keys.HOME+Keys.BACK_SPACE);
        payBillsPage.addNewPayee_name.sendKeys(payeeData.get("Payee Name"));
        payBillsPage.addNewPayee_address.sendKeys(""+ Keys.SHIFT+Keys.HOME+Keys.BACK_SPACE);
        payBillsPage.addNewPayee_address.sendKeys(payeeData.get("Payee Address"));
        payBillsPage.addNewPayee_account.sendKeys(""+ Keys.SHIFT+Keys.HOME+Keys.BACK_SPACE);
        payBillsPage.addNewPayee_account.sendKeys(payeeData.get("Account"));
        payBillsPage.addNewPayee_details.sendKeys(""+ Keys.SHIFT+Keys.HOME+Keys.BACK_SPACE);
        payBillsPage.addNewPayee_details.sendKeys(payeeData.get("Payee details"));
        payBillsPage.addNewPayeeSubmitButton.click();
        
        
    }
    
    @Then("the user gets the following addPayee result message")
    public void theUserGetsTheFollowingAddPayeeResultMessage(String expectedMessage) {
        String actualMessage = new PayBillsPage().addPayeeResultMessage.getText();
        Assert.assertEquals("",expectedMessage,actualMessage);
    }
}
