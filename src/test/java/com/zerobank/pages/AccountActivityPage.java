package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{
    
    @FindBy(xpath = "//select[@id='aa_accountId']")
    public WebElement accountType;
    
    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> tableHeaders;
    
    @FindBy(xpath = "//a[@href='#ui-tabs-2']")
    public WebElement findTransactions;
    
    @FindBy(xpath = "//input[@id='aa_fromDate']")
    public WebElement startDateInput;
    
    @FindBy(xpath = "//input[@id='aa_toDate']")
    public WebElement endDateInput;
    
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findButton;
    
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[1]")
    public List<WebElement> searchResultDates;
    
    
    
    
    
    public String getCurrentDropDownAccountType(){
        Select select = new Select(accountType);
        return select.getFirstSelectedOption().getText();
    }
    
    public List<String> getDropDownOptions(){
        Select select = new Select(accountType);
        return BrowserUtils.getElementsText(select.getOptions());
    }
}
