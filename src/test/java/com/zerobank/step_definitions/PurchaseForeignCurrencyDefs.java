package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
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
    
}
