package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    
    @FindBy(xpath = "//body[@class='vsc-initialized']")
    public WebElement spinnerBlock;
    
    
    
    public void waitUntilPageLoads(){
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
       try {
           wait.until(ExpectedConditions.invisibilityOf(spinnerBlock));
       }catch (Exception e){
           e.printStackTrace();
       }
       
    }
    
    public void navigateToTab(String tabName){
        String tabLocatorName = "//ul[@class='nav nav-tabs']/li[.='"+tabName+"']";
        WebElement tabLocator = Driver.get().findElement(By.xpath(tabLocatorName));
        tabLocator.click();
    }
}


