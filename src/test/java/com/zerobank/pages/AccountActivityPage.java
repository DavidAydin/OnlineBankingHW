package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
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
    
    @FindBy(id = "aa_description")
    public WebElement descriptionBox;
    
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[2]")
    public List<WebElement> searchResultDescriptions;
    
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[3]")
    public List<WebElement> searchTableDepositColumns;
    
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[4]")
    public List<WebElement> searchTableWithdrawalColumns;
    
    @FindBy(xpath = "//select[@id='aa_type']")
    public WebElement accountTypeSelect;
    
    
    
    
   
    
    public String getCurrentDropDownAccountType(){
        Select select = new Select(accountType);
        return select.getFirstSelectedOption().getText();
    }
    
    public List<String> getDropDownOptions(){
        Select select = new Select(accountType);
        return BrowserUtils.getElementsText(select.getOptions());
    }
    
    public boolean isDateOrder_MostRecentFirst(List<String> transactionDates) {
        // [15,19, 13,12,10, 9, 12,7, 6]
        
        boolean result = true;
    
        for (int i = 0; i <transactionDates.size()-1 ; i++) {
            Date date1 = getDatefromString(transactionDates.get(i));
            Date date2 = getDatefromString(transactionDates.get(i+1));
            if(!(date1.compareTo(date2)>=0)){
                result = false;
                break;
            }
   
        }
        
        return result;
    }
    
    public boolean isThereAtLeastOneFull(String accountType) {
       
        int locatorIndex = 15;
        if (accountType.contains("Deposit")) {
           locatorIndex =3;
        } else if (accountType.contains("Withdrawal")) {
            locatorIndex =4;
        }
        String locator = "//div[@id='filtered_transactions_for_account']//td["+locatorIndex+"]";
        List<String> amounts = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath(locator)));
    
        boolean check = false;
        for (String amount : amounts) {
                if (!amount.isEmpty()) {
                    check = true;
                    break;
                }
            }
        
        return check;
    }
    
    public boolean isAllBoxesAreEmpty(String accountType) {
        
        int locatorIndex = 15;
        if (accountType.contains("Deposit")) {
            locatorIndex =3;
        } else if (accountType.contains("Withdrawal")) {
            locatorIndex =4;
        }
        String locator = "//div[@id='filtered_transactions_for_account']//td["+locatorIndex+"]";
        List<String> amounts = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath(locator)));
        
        boolean check = true;
        for (String amount : amounts) {
            if (!amount.isEmpty()) {
                check = false;
                break;
            }
        }
        
        return check;
    }
    
    
}
