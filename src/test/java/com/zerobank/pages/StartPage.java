package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage{
    public StartPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    
    @FindBy(xpath = "//i[@class='icon-signin']")
    public WebElement proceedToSignIn;
}
