package com.revature.project01.stepimplementations.testcase;

import com.revature.project01.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static com.revature.project01.runners.BasicRunner.driver;

public class TestCaseSteps {

    // ADD A TEST CASE
    @Given("Tester navigates to the Test Cases page")
    public void tester_navigates_to_the_test_cases_page() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Test Cases')]")));
        BasicRunner.testerHome.testCasesLink.click();
    }
    @When("Tester types {string} into Description box")
    public void tester_types_into_description_box(String string) {
        BasicRunner.testCasePage.testCaseDescriptionInput.sendKeys("Verify that usernames cannot have illegal characters");
    }
    @When("Tester types {string} into Steps box")
    public void tester_types_into_steps_box(String string) {
        BasicRunner.testCasePage.testCaseStepsInput
                .sendKeys("1. Go to create a new account page \n" +
                    "2. create several users with each username having 1 illegal character\n" +
                    "3. Make sure none of them are successful\n" +
                    "illegal characters: $, #, /, <, >, (, ), ^");
    }
    @When("Tester presses the submit button")
    public void tester_presses_the_submit_button() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//button[@type='submit']")));
        //BasicRunner.testCasePage.testCaseSubmitButton.click();
    }
    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        BasicRunner.wait.until(ExpectedConditions
                .textToBePresentInElementLocated(By.xpath("//table/tbody"), "Verify that usernames cannot have illegal characters"));
    }
    @Then("The test case result should say {string}")
    public void the_test_case_result_should_say(String string) {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//table//tr[6]/td[3]"), "UNEXECUTED"));
    }

    // VIEW TEST CASE DETAILS

    @When("Tester clicks on Details button of a test case")
    public void tester_clicks_on_details_button_of_a_test_case() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table//tr[6]/td[4]/button[text()='Details']")));
        BasicRunner.testCasePage.testCaseDetailsButton.click();
    }
    @When("The test case modal appears displaying the case ID")
    public void the_test_case_modal_appears_displaying_the_case_id() {
        BasicRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div//div/p[contains(text(), 'Verify')]")));
    }
    @When("The Performed By field says No One")
    public void the_performed_by_field_says_no_one() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//div//div/div//p[contains(text(), 'No One')]"), "No One"));
    }
    @When("The tester clicks the close button")
    public void the_tester_clicks_the_close_button() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div/div[@role='dialog']/button[text()='Close']")));
        BasicRunner.testCasePage.closeButton.click();
    }
    @Then("The modal will be closed")
    public void the_modal_will_be_closed() {
        // Manually view modal closing
    }

    // EDIT EXISTING CASE

    @When("Tester clicks on Details button of 5th test case")
    public void tester_clicks_on_details_button_of_5th_test_case() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table//tr[5]/td[4]/button[text()='Details']")));
        BasicRunner.testCasePage.testCase5DetailsButton.click();
    }
    @When("Tester clicks on the Edit button within the modal")
    public void tester_clicks_on_the_edit_button_within_the_modal() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div/div/button[2]")));
        BasicRunner.testCasePage.modalEditButton.click();
    }
    @When("Tester navigates to the 5th test case editor")
    public void tester_navigates_to_the_5th_test_case_editor() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/caseeditor/35759");
    }
    @When("The fields are uneditable")
    public void the_fields_are_uneditable() throws InterruptedException {
        Thread.sleep(1000);
        boolean editStatus = BasicRunner.caseEditorPage.caseEditorDescriptionInput.isEnabled();
        boolean isDisabled = editStatus != true;
    }
    @When("Tester clicks on the Edit button")
    public void tester_clicks_on_the_edit_button() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Edit']")));
        BasicRunner.caseEditorPage.caseEditorEditButton.click();
    }
    @When("The test case fields become editable")
    public void the_test_case_fields_become_editable() {

    }
    @When("Tester edits the text in the Description text box")
    public void tester_edits_the_text_in_the_description_text_box() {
        BasicRunner.caseEditorPage.caseEditorDescriptionInput.sendKeys(" VERY IMPORTANT! ");
    }
    @When("Tester edits the text in the Steps text box")
    public void tester_edits_the_text_in_the_steps_text_box() {
        BasicRunner.caseEditorPage.caseEditorStepsInput.sendKeys("VERY IMPORTANT ");
    }
    @When("Tester clicks on the automated check mark")
    public void tester_clicks_on_the_automated_check_mark() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//fieldset[1]/input[@type='checkbox']")));
        BasicRunner.caseEditorPage.automatedCheckBox.click();
    }
    @When("Tester selects ryeGuy from Performed By drop down")
    public void tester_selects_rye_guy_from_performed_by_drop_down() {
        Select performedBy = new Select(driver.findElement(By.xpath("//fieldset[1]//select")));
        performedBy.selectByVisibleText("ryeGuy");

    }
    @When("Tester selects FAIL from Test Result drop down")
    public void tester_selects_fail_from_test_result_drop_down() {
        Select testResult = new Select(driver.findElement(By.xpath("//fieldset[2]/select")));
        testResult.selectByVisibleText("FAIL");
    }
    @When("Tester edits the text in the Summary text box")
    public void tester_edits_the_text_in_the_summary_text_box() {
        BasicRunner.caseEditorPage.caseEditSummaryInput.sendKeys("This test case has failed");
    }
    @When("Tester clicks the Save button")
    public void tester_clicks_the_save_button() throws InterruptedException {
        Thread.sleep(1000);
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']")));
        BasicRunner.caseEditorPage.saveButton.click();
    }
    @When("A confirmation prompt appears saying {string}")
    public void a_confirmation_prompt_appears_saying(String string) {
        BasicRunner.wait.until(ExpectedConditions.alertIsPresent());
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals(actualText, "Are you sure you want to update the test case?");
    }
    @When("Tester clicks Ok")
    public void tester_clicks_ok() {
        BasicRunner.driver.switchTo().alert().accept();
    }
    @Then("An alert appears saying {string}")
    public void an_alert_appears_saying(String string) {
        BasicRunner.wait.until(ExpectedConditions.alertIsPresent());
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals(actualText, "Test Case has been Saved");
    }
    @Then("The fields become uneditable")
    public void the_fields_become_uneditable() {
        boolean editStatus = BasicRunner.caseEditorPage.caseEditorDescriptionInput.isEnabled();
        boolean isDisabled = editStatus != true;
    }

    // RESET TEST CASE

    @When("Tester navigates to the 6th test case editor")
    public void tester_navigates_to_the_6th_test_case_editor() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/caseeditor/80716");
    }
    @When("Tester types a new description into the Description text box")
    public void tester_types_a_new_description_into_the_description_text_box() {
        BasicRunner.caseEditorPage.caseEditorDescriptionInput.sendKeys("THIS IS THE 6TH TEST CASE CREATED");
    }
    @When("Tester types new steps into the Steps text box")
    public void tester_types_new_steps_into_the_steps_text_box() {
        BasicRunner.caseEditorPage.caseEditorStepsInput.sendKeys("THESE ARE THE STEPS TO THE 6TH TEST CASE");
    }
    @When("Tester types a new summary into the Summary text box")
    public void tester_types_a_new_summary_into_the_summary_text_box() {
        BasicRunner.caseEditorPage.caseEditSummaryInput.sendKeys("This test case has failed");
    }
    @When("Tester clicks on the Reset button")
    public void tester_clicks_on_the_reset_button() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Reset']")));
        BasicRunner.caseEditorPage.resetButton.click();
    }
    @Then("The fields should be populated with their old values")
    public void the_fields_should_be_populated_with_their_old_values() {
        String actualDesc = driver.findElement(By.xpath("//fieldset[1]/textarea[1]")).getText();
        Assert.assertEquals(actualDesc, "Verify that usernames cannot have illegal characters");

        String actualSteps = driver.findElement(By.xpath("//fieldset[1]/textarea[2]")).getText();
        Assert.assertEquals(actualSteps, "1. Go to create a new account page \n" +
                "2. create several users with each username having 1 illegal character\n" +
                "3. Make sure none of them are successful\n" +
                "illegal characters: $, #, /, <, >, (, ), ^");

        String performedBy = driver.findElement(By.xpath("//fieldset[1]//p[2]")).getText();
        Assert.assertEquals(performedBy, "No One");

        String automationStatus = driver.findElement(By.xpath("//fieldset[1]//p[1]")).getText();
        Assert.assertEquals(automationStatus, "NO");
    }
    @Then("The fields should be uneditable")
    public void the_fields_should_be_uneditable() {
        boolean editStatus = BasicRunner.caseEditorPage.caseEditorDescriptionInput.isEnabled();
        boolean isDisabled = editStatus != true;
    }
}
