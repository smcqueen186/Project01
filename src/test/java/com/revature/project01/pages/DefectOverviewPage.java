package com.revature.project01.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DefectOverviewPage {

    @FindBy(xpath="//h1")
    public WebElement defectOverviewPageTitle;

    @FindBy(xpath = "//ul[1]/li[1]/div[1]/span[1]")
    public WebElement pendingDefect;

    @FindBy(xpath = "//ul[1]/li[1]/div[1]/div[1]/span[1]")
    public WebElement changeStatus;

    @FindBy(xpath = "//ul/li[1]/div/span/p")
    public WebElement testerDefectSpan;

    @FindBy(xpath = "//ul/li[1]/div/div//div[1]/span")
    public WebElement changeStatusButton;

    @FindBy(xpath = "//li[1]//div//div//div/button[1]")
    public WebElement acceptedButton;

    @FindBy(xpath = "//li[1]//div//div//div/button[2]")
    public WebElement rejectedButton;

    @FindBy(xpath = "//li[1]//div//div//div/button[3]")
    public WebElement fixedButton;

    @FindBy(xpath = "//li[1]//div//div//div/button[4]")
    public WebElement declinedButton;

    @FindBy(xpath = "//li[1]//div//div//div/button[5]")
    public WebElement shelvedButton;



}
