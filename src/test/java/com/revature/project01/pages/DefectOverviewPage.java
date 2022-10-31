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


}
