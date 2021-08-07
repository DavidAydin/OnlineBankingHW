package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage{
    
    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> accountTypes;
    
    @FindBy(xpath = "(//table//thead)[3]//th")
    public  List<WebElement> creditAccountHeaders;
    
    @FindBy(xpath = "(//a[contains(text(),'Savings')])[1]")
    public WebElement savingsAccountLink1;
    
    
    
    public void navigateThroughLinks(String linkName){
        String xpath = "(//a[contains(text(),'"+linkName+"')])[1]";
        Driver.get().findElement(By.xpath(xpath)).click();
    }
    
    public void dismissPasswordChangeAlert() {
        try {
            Alert alert = Driver.get().switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
