package com.revature.project01.stepimplementations.defects;

import com.revature.project01.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.revature.project01.runners.BasicRunner.*;
import static com.revature.project01.runners.BasicRunner.driver;

public class DefectStatusSteps {

    @Given("Tester is on the login page")
    public void tester_is_on_the_login_page() {
        driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=20");
    }
    @When("Tester types in a username of {string}")
    public void tester_types_in_a_username_of(String string) {
        BasicRunner.loginPage.usernameInput.sendKeys("ryeGuy");
    }
    @When("Tester types in a password of {string}")
    public void tester_types_in_a_password_of(String string) {

        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
    }
    @When("Tester clicks the login button")
    public void tester_clicks_the_login_button() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Login')]")));
        BasicRunner.loginPage.loginButton.click();
    }
    @Then("Tester should be redirected to the homepage")
    public void tester_should_be_redirected_to_the_homepage() throws InterruptedException {
        Thread.sleep(10000);
        String actualUrl = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/testerhome");
    }
    @Then("Tester should see the pending defects assigned to them")
    public void tester_should_see_the_pending_defects_assigned_to_them() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//h3[text()='My Defects']"), "My Defects"));
    }

    // CHANGE DEFECT STATUS
    @Given("Tester is on the homepage")
    public void tester_is_on_the_homepage() {
        driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=20");
        BasicRunner.loginPage.usernameInput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Login')]")));
        BasicRunner.loginPage.loginButton.click();
    }
    @When("Tester clicks on a defect to view its details")
    public void tester_clicks_on_a_defect_to_view_its_details() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[6]/span")));
        BasicRunner.testerHome.testerDefectSpan.click();
    }
    @When("Tester clicks the Change Status button")
    public void tester_clicks_the_change_status_button() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[6]/div/div//div[1]/span")));
        BasicRunner.testerHome.changeStatusButton.click();
    }
    @When("Tester clicks the Accepted button")
    public void tester_clicks_the_accepted_button() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[6]/div/div//div/button[1]")));
        BasicRunner.testerHome.changeStatusButton.click();
    }
    @Then("Tester should see the defect has a different status")
    public void tester_should_see_the_defect_has_a_different_status() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//ul/li[6]/div/span/p/b[2]"), "Accepted"));
    }
}
