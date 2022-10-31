package com.revature.project01.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefectReportPage {

    @FindBy(xpath="//h1")
    public WebElement defectReportPageTitle;

    @FindBy(xpath = "//form/input[@name='dateReported']")
    public WebElement dateReportedInput;

    @FindBy(xpath = "//form/textarea[@name='desc']")
    public WebElement descriptionInput;

    @FindBy(xpath = "//form/textarea[@name='stepsToReproduce']")
    public WebElement stepsInput;

    @FindBy(xpath = "//form/input[@name='severity']")
    public WebElement severityInput; // range: (low)min='1' -- (high)max='3'

    @FindBy(xpath = "//form/p[1]")
    public WebElement severityLevel;

    @FindBy(xpath = "//form/input[@name='priority']")
    public WebElement priorityInput; // range: (low)min='1' -- (high)max='3'

    @FindBy(xpath = "//form/p[2]")
    public WebElement priorityLevel;

    @FindBy(xpath = "//form/button[text()='Report']")
    public WebElement reportButton;

    @FindBy(xpath = "//div[1]")
    public WebElement modalOne; //div located at top of file

    @FindBy(xpath = "//div[@role='dialog']")
    public WebElement modalTwo; //div located at bottom of file MOST LIKELY CORRECT

    @FindBy(xpath = "//div[@role='dialog']/h4")
    public WebElement modalIdDisplay;

    @FindBy(xpath = "//div[@role='dialog']/button")
    public WebElement modalCloseButton;

    public DefectReportPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
