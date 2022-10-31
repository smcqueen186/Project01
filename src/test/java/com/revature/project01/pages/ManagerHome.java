package com.revature.project01.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHome {

    // Navigation Links
    @FindBy(xpath="//a[contains(text(), 'Matrices')]")
    public WebElement matricesLink;

    @FindBy(xpath="//a[contains(text(), 'Test Cases')]")
    public WebElement testCasesLink;

    @FindBy(xpath="//a[contains(text(), 'Report a Defect')]")
    public WebElement defectReporterLink;

    @FindBy(xpath="//a[contains(text(), 'Defect Overview')]")
    public WebElement defectOverviewLink;

    @FindBy(xpath = "//nav/p")
    public WebElement greeting;

    // Create matrix
    @FindBy(xpath = "//button[contains(text(), 'Create A new Requirements Matrix')]")
    public WebElement matrixFormButton;

    @FindBy(xpath = "//h2[(text()='New matrix')]")
    public WebElement matrixTitle;

    @FindBy(xpath = "//input[@name='title']")
    public WebElement matrixTitleInput;

    @FindBy(xpath = "//input[@placeholder='User Story']")
    public WebElement userStoryInput;

    @FindBy(xpath = "//input[@placeholder='Note']")
    public WebElement noteInput;

    @FindBy(xpath = "//fieldset/button[1][contains(text(),'Add Requirement')]")
    public WebElement addReqButton;

    @FindBy(xpath = "//button[contains(text(), 'Create Matrix')]")
    public WebElement createMatrixButton;

    // Pending Defects
    @FindBy(xpath = "//tr[2]/td/button[contains(text(), 'Select')]")
    public WebElement defectSelectButton;

    @FindBy(xpath = "//div/div[1]/h4")
    public WebElement defectDescription;

    @FindBy(xpath = "//div/div[1]/input")
    public WebElement assignDefectInput;

    @FindBy(xpath = "//datalist[@id='employees']")
    public WebElement assignDefectDropDown;

    @FindBy(xpath = "//datalist/option[contains(text(), 'ryeGuy')]")
    public WebElement ryeGuySelect;

    @FindBy(xpath = "//div/button[text()='Assign']")
    public WebElement assignButton;

    public ManagerHome(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
