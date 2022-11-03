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

    @FindBy(xpath = "//table//tr[7]/td[4]/button[text()='Details']")
    public WebElement testCase7DetailsButton;

    @FindBy(xpath = "//table//tr[6]/td[4]/button[text()='Details']")
    public WebElement testCaseDetailsButton;

    @FindBy(xpath = "//table//tr[5]/td[4]/button[text()='Details']")
    public WebElement testCase5DetailsButton;

    @FindBy(xpath = "//table//tr[3]/td[4]/button[text()='Details']")
    public WebElement editTestCaseDetailsButton;

    @FindBy(xpath = "//div//div/div[@role='dialog']")
    public WebElement modalWindow;

    @FindBy(xpath = "//div//div/div/h3")
    public WebElement caseIdDisplay; // MODAL

    @FindBy(xpath = "//div//div/div/button[text()='Close']")
    public WebElement closeButton; // MODAL

    @FindBy(xpath = "//div//div/div/button[2]")
    public WebElement modalEditButton; // MODAL

    public TestCasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
