package com.revature.project01.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHome {

    @FindBy(xpath="//a[contains(text(), 'Matrices')]")
    public WebElement matricesLink;

    @FindBy(xpath="//a[contains(text(), 'Test Cases')]")
    public WebElement testCasesLink;

    @FindBy(xpath="//a[contains(text(), 'Report a Defect')]")
    public WebElement defectReporterLink;

    @FindBy(xpath="//a[contains(text(), 'Defect Overview')]")
    public WebElement defectOverviewLink;


    @FindBy(xpath="//h1[contains(text(), 'Test Case')]")
    public WebElement testCasePageTitle;

    @FindBy(xpath="//h1[contains(text(), 'Defect Reporter')]")
    public WebElement defectReporterPageTitle;

    @FindBy(xpath="//h1[contains(text(), 'Defect Overview')]")
    public WebElement defectOverviewPageTitle;


    public ManagerHome(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
