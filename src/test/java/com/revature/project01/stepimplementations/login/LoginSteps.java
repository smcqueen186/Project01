package com.revature.project01.stepimplementations.login;

import com.revature.project01.runners.BasicRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import static com.revature.project01.runners.BasicRunner.*;

public class LoginSteps {

    // VALID CREDENTIALS
    @Given("User is at the login page")
    public void user_is_at_the_login_page() {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=20");
    }

    @When("User types in a valid username of g8tor")
    public void user_types_in_a_valid_username_of_g8tor() {
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
    }

    @And("User types in a valid password of chomp!")
    public void user_types_in_a_valid_password_of_chomp() {
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
    }

    @And("User clicks the login button")
    public void user_clicks_the_login_button() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Login')]")));
        BasicRunner.loginPage.loginButton.click();
    }

    @Then("User should be redirected to the Manager homepage")
    public void user_should_be_redirected_to_the_manager_homepage() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//h1"), "Manager Home"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome");
    }

    @When("User types in a valid username of ryeGuy")
    public void user_types_in_a_valid_username_of_rye_guy() {
        BasicRunner.loginPage.usernameInput.sendKeys("ryeGuy");
    }
    @When("User types in a valid password of coolbeans")
    public void user_types_in_a_valid_password_of_coolbeans() {
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
    }
    @Then("User should be redirected to the Tester homepage")
    public void user_should_be_redirected_to_the_tester_homepage() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//h1"), "Tester Home"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/testerhome");
    }
    @When("User types in a valid username of cavalier89")
    public void user_types_in_a_valid_username_of_cavalier89() {
        BasicRunner.loginPage.usernameInput.sendKeys("cavalier89");
    }
    @When("User types in a valid password of alucard")
    public void user_types_in_a_valid_password_of_alucard() {
        BasicRunner.loginPage.passwordInput.sendKeys("alucard");
    }
    @Then("User sees greeting message displaying Welcome Patty Pastiche")
    public void user_sees_greeting_message_displaying_welcome_patty_pastiche() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//nav//p"), "Welcome Patty Pastiche"));
    }
    @Then("User sees greeting message displaying Welcome Fakey McFakeFace")
    public void user_sees_greeting_message_displaying_welcome_fakey_mcfakeface() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//nav//p"), "Welcome Fakey McFakeFace"));
    }
    @Then("User sees greeting message displaying Welcome Dracula Fangs")
    public void user_sees_greeting_message_displaying_welcome_dracula_fangs() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//nav//p"), "Welcome Dracula Fangs"));
    }
    // INVALID PASSWORD
    @When("User types in a valid username of {string}")
    public void user_types_in_a_valid_username_of_(String username) {
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
    }
    @When("User types in an invalid password of {string}")
    public void user_types_in_an_invalid_password_of(String password) {
       BasicRunner.loginPage.passwordInput.sendKeys("invalidPass");
    }
    @Then("User should see an alert for invalid password stating {string}")
    public void user_should_see_an_alert_for_invalid_password_stating(String expectedAlert) {
        BasicRunner.wait.until(ExpectedConditions.alertIsPresent());
        String actualAlert = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlert, "Wrong password for User");
    }

    //INVALID USERNAME
    @When("User types in an invalid username of {string}")
    public void user_types_in_an_invalid_username_of(String username) {
        BasicRunner.loginPage.usernameInput.sendKeys("invalidUser");
    }
    @When("User types in a valid password of {string}")
    public void user_types_in_a_valid_password_of(String password) {
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
    }
    @Then("User should see an alert for invalid username stating {string}")
    public void user_should_see_an_alert_for_invalid_username_stating(String expectedAlert) {
        BasicRunner.wait.until(ExpectedConditions.alertIsPresent());
        String actualAlert = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlert, "Username not found");
    }

    // INVALID CREDENTIALS
    @Then("User should see an alert for invalid username and password stating {string}")
    public void user_should_see_an_alert_for_invalid_username_and_password_stating(String string) {
        BasicRunner.wait.until(ExpectedConditions.alertIsPresent());
        String actualAlert = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlert, "Wrong username/password for User");
    }

}
