package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;

public class PurchaseForeignCurrencyDefs {
    
   
    @Then("the following currencies should be available")
    public void the_following_currencies_should_be_available(List<String> expectedCurrencies) {
        PayBillsPage payBillsPage = new PayBillsPage();
        new WebDriverWait(Driver.get(),5).until(ExpectedConditions.elementToBeClickable(payBillsPage.currencyPurchaseButton));
        Select currencySelect = new Select(payBillsPage.availableCurrencies);
        List<String> actualCurrencies = BrowserUtils.getElementsText(currencySelect.getOptions());
        actualCurrencies.remove(0);
        Assert.assertEquals("verify available currencies",expectedCurrencies,actualCurrencies);
    
    }
    
    @When("the user enters {string} as the amount to calculate currency")
    public void theUserEntersAsTheAmountToCalculateCurrency(String amount) {
        PayBillsPage payBillsPage = new PayBillsPage();
        new WebDriverWait(Driver.get(),10).until(ExpectedConditions.elementToBeClickable(payBillsPage.calculateCostsButton));
        payBillsPage.currencyAmountBox.sendKeys(""+ Keys.SHIFT + Keys.HOME +Keys.BACK_SPACE);
        payBillsPage.currencyAmountBox.sendKeys(amount);
    }
    
    @And("the user clicks on the Calculate Costs button")
    public void theUserClicksOnTheCalculateCostsButton() {
        PayBillsPage payBillsPage = new PayBillsPage();
        new WebDriverWait(Driver.get(),10).until(ExpectedConditions.elementToBeClickable(payBillsPage.calculateCostsButton));
        payBillsPage.calculateCostsButton.click();
    }
    
    @Then("currency calculator error message should be displayed")
    public void currencyCalculatorErrorMessageShouldBeDisplayed() {
       
        String alertMessage = "";
       try {
          Alert alert = Driver.get().switchTo().alert();
           alertMessage = alert.getText();
       } catch (NoAlertPresentException e) {
           e.printStackTrace();
       }
       Assert.assertEquals("Please, ensure that you have filled all the required fields with valid values.",alertMessage);
       
    }
    
    @When("the user selects the currency as {string}")
    public void theUserSelectsTheCurrencyAs(String currency) {
        PayBillsPage payBillsPage = new PayBillsPage();
        new WebDriverWait(Driver.get(),10).until(ExpectedConditions.elementToBeClickable(payBillsPage.calculateCostsButton));
        Select selectCurrency = new Select(payBillsPage.availableCurrencies);
        selectCurrency.selectByVisibleText(currency);
    }
    
    @When("the user checks the selected currency radio button")
    public void theUserChecksTheSelectedCurrencyRadioButton() {
        PayBillsPage payBillsPage = new PayBillsPage();
        new WebDriverWait(Driver.get(),10).until(ExpectedConditions.elementToBeClickable(payBillsPage.calculateCostsButton));
        payBillsPage.selectedCurrencyRB.click();
    }
}
