package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {PageFactory.initElements(Driver.get(), this);
    }
    
    @FindBy(id="user_login")
    public  WebElement usernameInput;
    
    @FindBy(id = "user_password")
    public WebElement passwordInput;
    
    @FindBy(name = "submit")
    public WebElement LoginSubmitButton;
    
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessageBox;
    
}
