package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage{
    
    @FindBy(xpath = "//select[@id='sp_payee']")
    public WebElement payeeSelect;
    
    @FindBy(xpath = "//select[@id='sp_account']")
    public WebElement accountSelect;
    
    @FindBy(xpath = "//input[@id='sp_amount']")
    public WebElement amountBox;
    
    @FindBy(xpath = "//input[@id='sp_date']")
    public WebElement dateBox;
    
    @FindBy(xpath = "//input[@id='sp_description']")
    public WebElement descriptionBox;
    
    @FindBy(xpath = "//input[@id='pay_saved_payees']")
    public WebElement paySubmitButton;
    
    @FindBy(xpath = "//span[contains(@title,'payed to payee')]")
    public WebElement paymentResultMessage;
    
    @FindBy(xpath = "//input[@id='np_new_payee_name']")
    public WebElement addNewPayee_name;
    
    @FindBy(xpath = "//textarea[@id='np_new_payee_address']")
    public WebElement addNewPayee_address;
    
    @FindBy(xpath = "//input[@id='np_new_payee_account']")
    public WebElement addNewPayee_account;
    
    @FindBy(xpath = "//input[@id='np_new_payee_details']")
    public WebElement addNewPayee_details;
    
    @FindBy(xpath = "//input[@id='add_new_payee']")
    public WebElement addNewPayeeSubmitButton;
    
    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement addPayeeResultMessage;
    
    
    /**
     * Methods
     */
    public WebElement getTabLocator(String tabName){
        String xpath = "//li/a[contains(text(),'"+tabName+"')]";
        return Driver.get().findElement(By.xpath(xpath));
    }
    public void navigateToPayBillsTab(String tabName){
        getTabLocator(tabName).click();
    }
}
