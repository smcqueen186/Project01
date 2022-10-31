package com.revature.project01.stepimplementations.defects;

import com.revature.project01.pages.ManagerHome;
import com.revature.project01.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static com.revature.project01.runners.BasicRunner.driver;
import static com.revature.project01.runners.BasicRunner.managerHome;

public class AssignDefectSteps {

    // VIEW DESCRIPTION
    @Given("Manager is logged in as a manager")
    public void manager_is_logged_in_as_a_manager() {
        driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=20");
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
        BasicRunner.loginPage.loginButton.click();
    }
    @When("Manager clicks on the select button for a defect")
    public void manager_clicks_on_the_select_button_for_a_defect() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[2]/td/button[contains(text(), 'Select')]")));
        BasicRunner.managerHome.defectSelectButton.click();
    }
    @Then("The defect description appears in bold font")
    public void the_defect_description_appears_in_bold_font() {
        BasicRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div[1]/h4")));
        String fontWeight = BasicRunner.managerHome.defectDescription.getCssValue("font-weight");
        boolean isBold = Integer.parseInt(fontWeight) >= 700;
    }

    // ASSIGN
    @When("Manager selects a tester from the drop down")
    public void manager_selects_a_tester_from_the_drop_down() {
        BasicRunner.managerHome.assignDefectInput.sendKeys("ryeGuy");
    }
    @When("Manager clicks the assign button")
    public void manager_clicks_the_assign_button() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/button[text()='Assign']")));
        BasicRunner.managerHome.assignButton.click();
    }
    @Then("The defect is assigned to the tester")
    public void the_defect_is_assigned_to_the_tester() {
        // Tester will manually check their homepage for the newly assigned defect
    }



}
