package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;

public class AccountSummaryDefs {
    
    @Then("the following account types should be available")
    public void the_following_account_types_should_be_available(List<String> expectedAccountTypes) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> actualAccountTypes = BrowserUtils.getElementsText(accountSummaryPage.accountTypes);
        Assert.assertEquals(expectedAccountTypes,actualAccountTypes);
        
    }
    
    @Then("the Credit Accounts columns should be following")
    public void the_Credit_Accounts_columns_should_be_following(List<String> expectedtCreditAccountHeaders) {
        AccountSummaryPage accountSummaryPage =new AccountSummaryPage();
        List<String> actualCreditAccountHeaders = BrowserUtils.getElementsText(accountSummaryPage.creditAccountHeaders);
        String verificationMessage = "Verify that the credit account headers are: " + expectedtCreditAccountHeaders;
        Assert.assertEquals(verificationMessage,expectedtCreditAccountHeaders,actualCreditAccountHeaders);
    }
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
       new AccountSummaryPage().navigateThroughLinks(link);
    }
    
    
    
}
