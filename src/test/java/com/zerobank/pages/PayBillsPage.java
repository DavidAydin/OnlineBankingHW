package com.zerobank.pages;

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
}
