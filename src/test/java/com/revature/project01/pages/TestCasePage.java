package com.revature.project01.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasePage {

    @FindBy(xpath="//h1")
    public WebElement testCasePageTitle;
}