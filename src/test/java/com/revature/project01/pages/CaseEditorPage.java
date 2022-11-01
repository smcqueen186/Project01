package com.revature.project01.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaseEditorPage {

    @FindBy(xpath = "//textarea[contains(text(),'Verify')]")
    public WebElement caseEditorDescriptionInput;

    @FindBy(xpath = "//fieldset[1]/textarea[2]")
    public WebElement caseEditorStepsInput;

    @FindBy(xpath = "//fieldset[1]/input[@type='checkbox']")
    public WebElement automatedCheckBox;

    @FindBy(xpath = "//fieldset[1]//select")
    public WebElement performedByDropDown;

    @FindBy(xpath = "//fieldset[2]/select")
    public WebElement testResultDropDown;

    @FindBy(xpath = "//fieldset[2]/textarea")
    public WebElement caseEditSummaryInput;

    @FindBy(xpath = "//button[text()='Edit']")
    public WebElement caseEditorEditButton;

    @FindBy(xpath = "//button[text()='Reset']")
    public WebElement resetButton;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;

    public CaseEditorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
