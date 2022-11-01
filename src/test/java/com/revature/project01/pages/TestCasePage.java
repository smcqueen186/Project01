package com.revature.project01.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasePage {

    @FindBy(xpath="//h1")
    public WebElement testCasePageTitle;

    @FindBy(xpath = "//form//textarea[@name='desc']")
    public WebElement testCaseDescriptionInput;

    @FindBy(xpath = "//form//textarea[@name='steps']")
    public WebElement testCaseStepsInput;

    @FindBy(xpath = "//form//button[@type='submit']")
    public WebElement testCaseSubmitButton;

    @FindBy(xpath = "//table//tr[2]/td[4]/button[text()='Details']")
    public WebElement testCaseDetailsButton;

    @FindBy(xpath = "//div//div/div/h3")
    public WebElement caseIdDisplay; // MODAL

    @FindBy(xpath = "//div//div/div/button[text()='Close']")
    public WebElement closeButton; // MODAL

    @FindBy(xpath = "//div//div/div/button[2]")
    public WebElement editButton; // MODAL

    public TestCasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
