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
    @Given("Tester is on the homepage")
    public void tester_is_on_the_homepage() throws InterruptedException {
        Thread.sleep(1000);
        String actualUrl = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/testerhome");
    }
    @Then("Tester should see the pending defects assigned to them")
    public void tester_should_see_the_pending_defects_assigned_to_them() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//h3[text()='My Defects']"), "My Defects"));
    }

    // CHANGE DEFECT STATUS
    @When("Tester clicks on a defect to view its details")
    public void tester_clicks_on_a_defect_to_view_its_details() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[6]/div/span/p")));
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
        BasicRunner.testerHome.acceptedButton.click();
    }
    @Then("Tester should see the defect status is Accepted")
    public void tester_should_see_the_defect_status_is_accepted() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//ul/li[6]/div/span/p/b[2]"), "Accepted"));
    }
    @When("Tester clicks the Rejected button")
    public void tester_clicks_the_rejected_button() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[6]/div/div//div/button[2]")));
        BasicRunner.testerHome.rejectedButton.click();
    }
    @Then("Tester should see the defect status is Rejected")
    public void tester_should_see_the_defect_status_is_rejected() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//ul/li[6]/div/span/p/b[2]"), "Rejected"));
    }
    @When("Tester clicks the Fixed button")
    public void tester_clicks_the_fixed_button() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[6]/div/div//div/button[3]")));
        BasicRunner.testerHome.fixedButton.click();
    }
    @Then("Tester should see the defect status is Fixed")
    public void tester_should_see_the_defect_status_is_fixed() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//ul/li[6]/div/span/p/b[2]"), "Fixed"));
    }
    @When("Tester clicks the Declined button")
    public void tester_clicks_the_declined_button() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[6]/div/div//div/button[4]")));
        BasicRunner.testerHome.declinedButton.click();
    }
    @Then("Tester should see the defect status is Declined")
    public void tester_should_see_the_defect_status_is_declined() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//ul/li[6]/div/span/p/b[2]"), "Declined"));
    }
    @When("Tester clicks the Shelved button")
    public void tester_clicks_the_shelved_button() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[6]/div/div//div/button[5]")));
        BasicRunner.testerHome.shelvedButton.click();
    }
    @Then("Tester should see the defect status is Shelved")
    public void tester_should_see_the_defect_status_is_shelved() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//ul/li[6]/div/span/p/b[2]"), "Shelved"));
    }
}


