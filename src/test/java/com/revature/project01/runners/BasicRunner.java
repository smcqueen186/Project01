package com.revature.project01.runners;

import com.revature.project01.pages.LoginPage;

import com.revature.project01.pages.ManagerHome;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@CucumberOptions(features = "src/test/resources/features", glue = "com.revature.project01.stepimplementations", tags = "@navi")
public class BasicRunner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static ManagerHome managerHome;
    public static WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);

        managerHome = new ManagerHome(driver);

    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
