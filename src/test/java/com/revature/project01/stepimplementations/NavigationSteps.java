package com.revature.project01.stepimplementations;

import com.revature.project01.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Function;

import static com.revature.project01.runners.BasicRunner.*;

public class NavigationSteps {

    @Given("User is logging in as Manager")
    public void user_is_logging_in_as_manager() {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=20");
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
        BasicRunner.loginPage.loginButton.click();
    }

    @Given("Manager is on the homepage")
    public void manager_is_on_the_homepage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        BasicRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Manager Home')]")));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome");
    }

    @When("Manager clicks on Matrices")
    public void manager_clicks_on_matrices() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Matrices')]")));
        BasicRunner.managerHome.matricesLink.click();
    }
    @Then("Manager navigates to a page displaying the title Matrix Overview")
    public void manager_navigates_to_a_page_displaying_the_title_matrix_overview() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//h1"), "Matrix Overview"));
    }

    @When("Manager clicks on Test Cases")
    public void manager_clicks_on_test_cases() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Test Cases')]")));
        BasicRunner.managerHome.testCasesLink.click();
    }
    @Then("Manager navigates to a page displaying the title Test Case Overview")
    public void manager_navigates_to_a_page_displaying_the_title_test_case_overview() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//h1"), "Test Case Overview"));
    }

    @When("Manager clicks on Report a Defect")
    public void manager_clicks_on_report_a_defect() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Report')]")));
        managerHome.defectReporterLink.click();
    }
    @Then("Manager navigates to a page displaying the title Defect Reporter")
    public void manager_navigates_to_a_page_displaying_the_title_defect_reporter() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//h1"), "Defect Reporter"));
    }

    @When("Manager clicks on Defect Overview")
    public void manager_clicks_on_defect_overview() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Defect Overview')]")));
        managerHome.defectOverviewLink.click();
    }
    @Then("Manager navigates to a page displaying the title Defect Overview")
    public void manager_navigates_to_a_page_displaying_the_title_defect_overview() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//h1"), "Defect Overview"));
    }
}
