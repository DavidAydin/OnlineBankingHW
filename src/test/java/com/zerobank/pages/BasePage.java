package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    
    public Date getDatefromString(String sDate)  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    
    public boolean isDateBetween(Date checkDate, Date startDate, Date endDate){
        boolean result = false;
        int startCompare = checkDate.compareTo(startDate);
        int endCompare = checkDate.compareTo(endDate);
        
        if (startCompare>=0 && endCompare<=0){
            result = true;
        }
        
        return result;
    }
    
    public boolean isDateBetween(String checkDate, String startDate, String endDate){
        boolean result;
        int startCompare = getDatefromString(checkDate).compareTo(getDatefromString(startDate));
        int endCompare = getDatefromString(checkDate).compareTo(getDatefromString(endDate));
//        System.out.println("startCompare = " + startCompare);
//        System.out.println("endCompare = " + endCompare);
        
        if (startCompare>=0 && endCompare<=0){
            result = true;
        } else{
            result = false;
        }
        
        return result;
    }
}


