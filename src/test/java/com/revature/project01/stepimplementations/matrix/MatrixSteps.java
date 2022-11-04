package com.revature.project01.stepimplementations.matrix;

import com.revature.project01.runners.BasicRunner;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import static com.revature.project01.runners.BasicRunner.*;
public class MatrixSteps {

    // CREATE MATRIX

    @Given("Manager logs into their homepage")
    public void manager_logs_into_their_homepage() {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=20");
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
        BasicRunner.loginPage.loginButton.click();
    }

    @When("Manager clicks on the button to create a matrix")
    public void manager_clicks_on_the_button_to_create_a_matrix() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Create A new Requirements Matrix')]")));
        BasicRunner.managerHome.matrixFormButton.click();
    }

    @When("Manager pulls up a form to make a new matrix")
    public void manager_pulls_up_a_form_to_make_a_new_matrix() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//h2[(text()='New matrix')]"), "New matrix"));
    }

    @When("Manager adds a title to the matrix")
    public void manager_adds_a_title_to_the_matrix() {
        BasicRunner.managerHome.matrixTitleInput.sendKeys("New RTM 3000");
    }

    @When("Manager adds a user story")
    public void manager_adds_a_user_story() {
        BasicRunner.managerHome.userStoryInput.sendKeys("New matrix");
    }

    @When("Manager selects a priority level")
    public void manager_selects_a_priority_level() {
        Select priority = new Select(driver.findElement(By.xpath("//tbody//tr//td//select")));
        priority.selectByVisibleText("High");
    }

    @When("Manager adds a note")
    public void manager_adds_a_note() {
        BasicRunner.managerHome.noteInput.sendKeys("This is a note");
    }

    @When("Manager adds requirements to the matrix")
    public void manager_adds_requirements_to_the_matrix() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//fieldset/button[1][contains(text(),'Add Requirement')]")));
        BasicRunner.managerHome.addReqButton.click();
    }

    @When("Manager saves the matrix")
    public void manager_saves_the_matrix() throws InterruptedException {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//fieldset/button[1][contains(text(),'Add Requirement')]")));
        //BasicRunner.managerHome.createMatrixButton.click();
    }

    // ADD DEFECT

    @Given("Manager clicks on the Matrices link")
    public void manager_clicks_on_the_matrices_link() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Matrices')]")));
        BasicRunner.managerHome.matricesLink.click();
    }

    @Given("Manager navigates to the Matrices page")
    public void manager_navigates_to_the_matrices_page() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//h1"), "Matrices"));
    }

    @When("Manager clicks the Show button to view details of a matrix")
    public void manager_clicks_the_show_button_to_view_details_of_a_matrix() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[2]/div/span")));
        BasicRunner.matricesPage.showButton.click();
    }

    @When("Manager clicks the edit button to a User Story")
    public void manager_clicks_the_edit_button_to_a_user_story() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[2]/div/div//table//tr[2]//td[6]/button")));
        BasicRunner.matricesPage.editButton.click();
    }

    @When("Manager inputs an ID number of a defect")
    public void manager_inputs_an_id_number_of_a_defect() {
        BasicRunner.matricesPage.defectIdInput.sendKeys("999");

    }

    @When("Manager clicks the add button to add the defect")
    public void manager_clicks_the_add_button_to_add_the_defect() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]")));
        BasicRunner.matricesPage.addDefectButton.click();

    }

    @Then("The defect is added to the list")
    public void the_defect_is_added_to_the_list() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[2]/div[1]/div[1]/div[1]/button")));
        BasicRunner.matricesPage.saveReqButton.click();
    }

    @Then("Manager sees an alert stating {string}")
    public void manager_sees_an_alert_stating(String expectedAlert) throws InterruptedException {
        BasicRunner.wait.until(ExpectedConditions.alertIsPresent());
        String actualAlert = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlert, "Matrix Saved");
    }

    // ADD TEST CASE

    @When("Manager inputs an ID number of a test case")
    public void manager_inputs_an_id_number_of_a_test_case() {
        BasicRunner.matricesPage.testCaseIdInput.sendKeys("888");

    }

    @When("Manager clicks the add button to add the test case")
    public void manager_clicks_the_add_button_to_add_the_test_case() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[2]/div/div//div/ul[1]/li/button[text()='Add']")));
        matricesPage.addTestCaseButton.click();

    }

    @Then("The test case is added to the list")
    public void the_test_case_is_added_to_the_list() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[2]/div[1]/div[1]/div[1]/button")));
        BasicRunner.matricesPage.saveReqButton.click();
    }

    // REMOVE DEFECT
    @When("Manager clicks the remove button to remove the defect")
    public void manager_clicks_the_remove_button_to_remove_the_defect() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[2]/div/div//div/ul[2]/li[1]/button[1]")));
        BasicRunner.matricesPage.removeDefectButton.click();
    }

    @Then("The defect is removed")
    public void the_defect_is_removed() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[2]/div[1]/div[1]/div[1]/button")));
        BasicRunner.matricesPage.saveReqButton.click();
    }

    // REMOVE TEST CASE
    @When("Manager clicks the remove button to remove the test case")
    public void manager_clicks_the_remove_button_to_remove_the_test_case() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[2]/div/div//div/ul[1]/li[1]/button[1]")));
        BasicRunner.matricesPage.removeTestButton.click();
    }

    @Then("The test case is removed")
    public void the_test_case_is_removed() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[2]/div[1]/div[1]/div[1]/button")));
        BasicRunner.matricesPage.saveReqButton.click();
    }

    // ADD NON-NUMERICAL ID
    @When("Manager inputs a non-numerical ID of a defect")
    public void manager_inputs_a_non_numerical_id_of_a_defect() {
        BasicRunner.matricesPage.defectIdInput.sendKeys("forty");
    }

    @Then("The defect is not added to the list")
    public void the_defect_is_not_added_to_the_list() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//ul/li[2]//div/div//ul[2]/li[5]"), "NaN Remove"));
    }

    @When("Manager inputs a non-numerical ID of a test case")
    public void manager_inputs_a_non_numerical_id_of_a_test_case() {
        BasicRunner.matricesPage.testCaseIdInput.sendKeys("one thousand");
    }

    @Then("The test case is not added to the list")
    public void the_test_case_is_not_added_to_the_list() {
        BasicRunner.wait.until(ExpectedConditions.textToBe(By.xpath("//ul/li[2]//div/div//ul[1]/li[5]"), "NaN Remove"));
    }

}

    //List<WebElement> allProduct = Driver.findElements(By.xpath("//ul[@id='ListViewInner']/li"));
//ul/li[2]//div/div//ul[1]/li[5]