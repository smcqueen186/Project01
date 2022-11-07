package com.revature.project01.stepimplementations.defects;

import com.revature.project01.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.revature.project01.runners.BasicRunner.*;

public class ReportDefectSteps {
    Actions action = new Actions(driver);

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=20");
    }

    @When("User types in a username of {string}")
    public void user_types_in_a_username_of(String string) {
        BasicRunner.loginPage.usernameInput.sendKeys("ryeGuy");
    }

    @When("User types in a password of {string}")
    public void user_types_in_a_password_of(String string) {
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
    }

    @Given("User navigates to the Defect Reporter page")
    public void user_navigates_to_the_defect_reporter_page() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Report')]")));
        testerHome.defectReporterLink.click();
    }

    @When("User selects a date")
    public void user_selects_a_date() {
        BasicRunner.defectReportPage.dateReportedInput.sendKeys("11022022");
    }

    @When("User types in the Description box with {string}")
    public void user_types_in_the_description_box_with(String string) {
        BasicRunner.defectReportPage.descriptionInput.sendKeys(" USERS can go to the page and click the " +
                "submit button before typing into the input");
    }

    @When("User types in the How to Reproduce box with {string}")
    public void user_types_in_the_how_to_reproduce_box_with(String string) {
        BasicRunner.defectReportPage.stepsInput
                .sendKeys("1. Go to the page\n" +
                        "2. Click\n" +
                        "3. Type");
    }

    @When("User selects Medium priority")
    public void user_selects_medium_priority() {
        WebElement prioritySlider = driver.findElement(By.xpath("//form/input[@name='priority']"));
        action.sendKeys(prioritySlider, Keys.ARROW_LEFT).sendKeys(prioritySlider, Keys.PAUSE).build().perform();
    }

    @When("User selects Low severity")
    public void user_selects_low_severity() {
        WebElement severitySlider = driver.findElement(By.xpath("//form/input[@name='severity']"));
        action.sendKeys(severitySlider, Keys.ARROW_LEFT).build().perform();

    }

    @When("User clicks the Report button")
    public void user_clicks_the_report_button() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/button[text()='Report']")));
        BasicRunner.defectReportPage.reportButton.click();
    }

    @When("A confirmation box appears stating {string}")
    public void a_confirmation_box_appears_stating(String string) {
        String actualAlert = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlert, "Confirm Bug Report?");
    }

    @When("User clicks Ok")
    public void user_clicks_ok() throws InterruptedException {
        Thread.sleep(1000);
        BasicRunner.driver.switchTo().alert().accept();
    }

    @When("A modal appears displaying the newly created Defect ID")
    public void a_modal_appears_displaying_the_newly_created_defect_id() {
        BasicRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='dialog']")));
    }

    @When("User clicks close")
    public void user_clicks_close() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='dialog']/button")));
        BasicRunner.defectReportPage.modalCloseButton.click();
    }

    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        BasicRunner.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@role='dialog']")));
    }

    // SHORT DESC
    @When("User types short amount in the Description box with {string}")
    public void user_types_short_amount_in_the_description_box_with(String string) {
        BasicRunner.defectReportPage.descriptionInput.sendKeys("meh");
    }

    @Then("No confirmation box appears")
    public boolean no_confirmation_box_appears() {
        try{
            driver.switchTo().alert();
            return false;
        }
        catch(NoAlertPresentException e) {
            return true;
        }
    }

    // SHORT STEPS
    @When("User types short amount in the How to Reproduce box with {string}")
    public void user_types_short_amount_in_the_how_to_reproduce_box_with (String string){
        BasicRunner.defectReportPage.stepsInput.sendKeys("meh");
    }

    // UNREALISTIC DATE
    @When("User selects an unrealistic date")
    public void user_selects_an_unrealistic_date () {
        BasicRunner.defectReportPage.dateReportedInput.sendKeys("01015555");
    }
}
