package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChromeSecurityPage {
    
    public ChromeSecurityPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    
    @FindBy(id ="details-button")
    public WebElement advancedButton;
    
    @FindBy(id = "proceed-link")
    public WebElement selectUnSafeLink;
    
    public void dismissChromeSecurityWarning() {
      try{
          advancedButton.click();
          selectUnSafeLink.click();
      } catch(Exception e){
          e.printStackTrace();
      }
      
      
      
    }
}
