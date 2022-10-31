package com.revature.project01.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TesterHome {

    @FindBy(xpath = "//h3[text()='My Defects']")
    public WebElement testerDefects;

    @FindBy(xpath = "//ul/li[6]/span")
    public WebElement testerDefectSpan; // 6th defect in the list

    @FindBy(xpath = "//ul/li[6]/div/div//div[1]/span")
    public WebElement changeStatusButton;

    @FindBy(xpath = "//ul/li[6]/div/div//div/button[1]")
    public WebElement acceptedButton;

    @FindBy(xpath = "//table//tr[2]/td[4]/button")
    public WebElement testCaseDetailsButton;

    @FindBy(xpath = "//ul/li[6]/div/span/p/b[2]")
    public WebElement defectStatus; // for 6th defect in the list


    public TesterHome(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
