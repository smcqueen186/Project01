package com.revature.project01.stepimplementations.login;

import com.revature.project01.runners.BasicRunner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.revature.project01.runners.BasicRunner.*;

public class LoginSteps {

    @Given("User is at the login page")
    public void user_is_at_the_login_page() {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=20");
    }

    @When("User types in a valid username of {string}")
    public void user_types_in_a_valid_username_of(String username) {
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
    }

    @And("User types in a valid password of {string}")
    public void user_types_in_a_valid_password_of(String password) {
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
    }

    @And("User clicks the login button")
    public void user_clicks_the_login_button() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Login')]")));
        BasicRunner.loginPage.loginButton.click();
    }

    @Then("User should be redirected to the homepage")
    public void user_should_be_redirected_to_the_homepage() throws InterruptedException {
        BasicRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Manager Home')]")));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome");
    }

    @When("User types in an invalid password of {string}")
    public void user_types_in_an_invalid_password_of(String password) {
       BasicRunner.loginPage.passwordInput.sendKeys("invalidPass");
    }
    @Then("User should see an alert for invalid password stating {string}")
    public void user_should_see_an_alert_for_invalid_password_stating(String expectedAlert) throws InterruptedException {
        BasicRunner.wait.until(ExpectedConditions.alertIsPresent());
        String actualAlert = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlert, "Wrong password for User");
    }

    @When("User types in an invalid username of {string}")
    public void user_types_in_an_invalid_username_of(String username) {
        BasicRunner.loginPage.usernameInput.sendKeys("invalidUser");
    }

    @Then("User should see an alert for invalid username stating {string}")
    public void user_should_see_an_alert_for_invalid_username_stating(String expectedAlert) throws InterruptedException {
        BasicRunner.wait.until(ExpectedConditions.alertIsPresent());
        String actualAlert = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlert, "Username not found");
    }

    @Then("User should see an alert for invalid username and password stating {string}")
    public void user_should_see_an_alert_for_invalid_username_and_password_stating(String string) throws InterruptedException {
        BasicRunner.wait.until(ExpectedConditions.alertIsPresent());
        String actualAlert = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlert, "Wrong username/password for User");
    }

}
