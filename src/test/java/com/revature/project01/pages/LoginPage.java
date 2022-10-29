package com.revature.project01.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.revature.project01.runners.BasicRunner.driver;

public class LoginPage {

    @FindBy(xpath="//input[1]")
    public WebElement usernameInput;

    @FindBy(xpath="//input[2]")
    public WebElement passwordInput;

    @FindBy(xpath="//button[contains(text(), 'Login')]")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
