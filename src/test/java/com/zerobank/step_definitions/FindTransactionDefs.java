package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FindTransactionDefs {
    @When("the user clicks on Find Transaction tab on the Account Activity page")
    public void the_user_clicks_on_Find_Transaction_tab_on_the_Account_Activity_page() {
        new AccountActivityPage().findTransactions.click();
        new WebDriverWait(Driver.get(),5).until(ExpectedConditions.elementToBeClickable(new AccountActivityPage().startDateInput));
    }
    
    @When("the user enters start date {string} and end date {string}")
    public void the_user_enters_start_date_and_end_date(String startDate, String endDate) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.startDateInput.sendKeys("" +Keys.SHIFT + Keys.HOME +Keys.BACK_SPACE);
        accountActivityPage.endDateInput.sendKeys("" +Keys.SHIFT + Keys.HOME +Keys.BACK_SPACE);
        accountActivityPage.startDateInput.sendKeys(startDate);
        accountActivityPage.endDateInput.sendKeys(endDate);
        
    }
    
    @When("the user clicks on the Find button")
    public void the_user_clicks_on_the_Find_button() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.findButton.click();
        new WebDriverWait(Driver.get(),5).until(ExpectedConditions.visibilityOfAllElements(accountActivityPage.searchResultDates));
        
        
    }
    
    @Then("the shown results should be between dates {string} and {string}")
    public void the_shown_results_should_be_between_dates_and(String startDate, String endDate) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> transactionDates = BrowserUtils.getElementsText(accountActivityPage.searchResultDates);
        
        boolean check = true;
        for (String transactionDate : transactionDates) {
            if(!accountActivityPage.isDateBetween(transactionDate,startDate,endDate)){
                check = false;
            }
        }
        Assert.assertTrue("verify all transactions are within the search dates",check);
        
    }
    
    
    @Then("the results should be sorted by most recent date")
    public void theResultsShouldBeSortedByMostRecentDate() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> transactionDates = BrowserUtils.getElementsText(accountActivityPage.searchResultDates);
        boolean isMostRecentFirst = accountActivityPage.isDateOrder_MostRecentFirst(transactionDates);
        Assert.assertTrue("verify that most recent is first",isMostRecentFirst);
        
    }
    
    
    @Then("the shown results should should not contain {string}")
    public void theShownResultsShouldShouldNotContain(String sDate) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> transactionDates = BrowserUtils.getElementsText(accountActivityPage.searchResultDates);
        String verificationMessage = "verify the search results does not contain " + sDate;
        Assert.assertFalse(verificationMessage,transactionDates.contains(sDate));
    }
    
    
    @When("the user enters {string} in description")
    public void theUserEntersInDescription(String description) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.descriptionBox.sendKeys(""+Keys.SHIFT + Keys.HOME +Keys.BACK_SPACE);
        accountActivityPage.descriptionBox.sendKeys(description);
        
    }
    
    @Then("results table should only show transactions with description {string}")
    public void resultsTableShouldOnlyShowTransactionsWithDescription(String expectedDescription) {
        List<String> transactionDescriptions =
                BrowserUtils.getElementsText(new AccountActivityPage().searchResultDescriptions);
        
        boolean verification = true;
        for (String transactionDescription : transactionDescriptions) {
            if (!transactionDescription.contains(expectedDescription)){
                verification = false;
                break;
            }
        }
        String verificationMessage ="verify all search results contain " + expectedDescription;
        Assert.assertTrue(verificationMessage,verification);
    }
    
    @And("results table should not show transactions with description {string}")
    public void resultsTableShouldNotShowTransactionsWithDescription(String expectedDescription) {
        List<String> transactionDescriptions =
                BrowserUtils.getElementsText(new AccountActivityPage().searchResultDescriptions);
        boolean verification = true;
        for (String transactionDescription : transactionDescriptions) {
            if (transactionDescription.contains(expectedDescription)){
                verification = false;
                break;
            }
        }
        String verificationMessage ="verify search results does not contain " + expectedDescription;
        Assert.assertTrue(verificationMessage,verification);
    }
    
    
    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String accountType) {
       AccountActivityPage accountActivityPage = new AccountActivityPage();
       boolean check = accountActivityPage.isThereAtLeastOneFull(accountType);
           Assert.assertTrue("verify at least one box is full",check);
        
        
    }
    
    @When("user selects type {string} and hits Find button")
    public void user_selects_type(String accountType) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select type = new Select(accountActivityPage.accountTypeSelect);
        type.selectByVisibleText(accountType);
        accountActivityPage.findButton.click();
        BrowserUtils.waitFor(1);
        
    }
    
    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String accountType) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
       boolean check = accountActivityPage.isAllBoxesAreEmpty(accountType);
            Assert.assertTrue("verify all boxes are empty",check);
        
    }
}
