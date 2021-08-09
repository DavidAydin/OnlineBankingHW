package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.BasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;


public class AccountActivityNavigationDefs extends BasePage {
    
    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String tabName) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.navigateToTab(tabName);
        
    }
    
    @Then("the current dropdown account type should be {string}")
    public void the_account_type_should_be_Savings(String expectedAccountType) {
        
        String actualAccountType = new AccountActivityPage().getCurrentDropDownAccountType();
        Assert.assertEquals("Verify default account type in dropdown menu",expectedAccountType,actualAccountType);
    }
    
    @Then("the account dropdown should have the following options")
    public void the_account_dropdown_should_have_the_following_options(List<String> expectedtDropDownOptions) {
        List<String> actualDropDownOptions = new AccountActivityPage().getDropDownOptions();
        boolean checkExpected = BrowserUtils.doesListContainsList(actualDropDownOptions, expectedtDropDownOptions);
        Assert.assertTrue("verify drop down options",checkExpected);
        
    }
    
    @Then("the transaction table headers should have the following titles")
    public void the_transaction_table_headers_should_have_the_following_titles(List<String> expectedTransactionTableHeaders) {
        new WebDriverWait(Driver.get(),2).
                until(ExpectedConditions.visibilityOfAllElements(new AccountActivityPage().tableHeaders));
        List<String> actualTransactionTableHeaders = new ArrayList<>();
        for (WebElement tableHeader : new AccountActivityPage().tableHeaders) {
            actualTransactionTableHeaders.add(tableHeader.getText());
        }
        Assert.assertEquals("verify transaction table headers",expectedTransactionTableHeaders,
                actualTransactionTableHeaders);
        
        
    }
    
 
}
