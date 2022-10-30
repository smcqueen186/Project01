package com.revature.project01.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MatricesPage {

    @FindBy(xpath = "//ul/li[2]/div/span")
    public WebElement showButton;

    @FindBy(xpath = "//ul/li[2]/div/div/div/ul[2]/li/input")
    public WebElement defectIdInput;

    @FindBy(xpath = "//ul/li[2]/div//ul[1]/li/input")
    public WebElement testCaseIdInput;

    @FindBy(xpath = "//ul/li[2]/div/div/div/ul[2]/li/button[contains(text(), 'Add')]")
    public WebElement addDefectButton;

    @FindBy(xpath = "//ul/li[2]/div/div//div/ul[1]/li/button[text()='Add']")
    public WebElement addTestCaseButton;

    @FindBy(xpath = "//ul/li[2]/div/div//div/ul[2]/li[1]/button[1]")
    public WebElement removeDefectButton;

    @FindBy(xpath = "//ul/li[2]/div/div//div/ul[1]/li[1]/button[1]")
    public WebElement removeTestButton;

    @FindBy(xpath = "//ul/li[2]/div/div//table//tr[2]//td[6]/button")
    public WebElement editButton; // 2nd User Story under Lumber Bros

    @FindBy(xpath = "//div[@id=collapsible-content-1667121564037]/div/ul[2]")
    public WebElement defectIdList;

    @FindBy(xpath = "//ul/li[2]/div[1]/div[1]/div[1]/button")
    public WebElement saveReqButton;



    public MatricesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
