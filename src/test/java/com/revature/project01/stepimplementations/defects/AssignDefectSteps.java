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
    @When("Manager assigns a tester to the defect")
    public void manager_assigns_a_tester_to_the_defect() {
        BasicRunner.managerHome.assignDefectInput.sendKeys("ryeGuy");
    }
    @When("Manager clicks the assign button")
    public void manager_clicks_the_assign_button() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/button[text()='Assign']")));
        BasicRunner.managerHome.assignButton.click();
    }
    @Then("The defect disappears from the list on the homepage")
    public void the_defect_disappears_from_the_list_on_the_homepage() {
        BasicRunner.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table//tbody"),"New Defect 06"));

    }
    @Then("The defect is visible on the tester's homepage")
    public void the_defect_is_visible_on_the_tester_s_homepage() {
        driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=20");
        BasicRunner.loginPage.usernameInput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.loginPage.loginButton.click();
        BasicRunner.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div/ul[1]"),"New Defect 06"));

    }



}
