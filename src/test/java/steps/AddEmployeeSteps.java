package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;


public class AddEmployeeSteps extends CommonMethods {

    String generatedEmployeeID;


    @When("user enters employee value {string} and {string} and {string} and leaves employee ID empty")
    public void user_enters_employee_value_and_and(String firstName,
                                                   String middleName,
                                                   String lastName) {

        sendText(firstName, addEmployeePage.firstNameField);
        sendText(middleName, addEmployeePage.middleNameField);
        sendText(lastName, addEmployeePage.lastNameField);

        // Save auto-generated ID for later verification
        generatedEmployeeID = addEmployeePage.getEmployeeId();
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        //WebElement saveButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        //saveButton.click();
        click(addEmployeePage.saveButton);

    }

    @Then("user is able to see employee added successfully")
    public void user_is_able_to_see_employee_added_successfully() {
        System.out.println("employee added successfully");
    }

    @Then("employee should be added successfully")
    public void verify_employee_added() {
        Assert.assertTrue(addEmployeePage.personalDetailsHeader.isDisplayed());
        System.out.println("Employee added with ID: " + generatedEmployeeID);
    }

    @When("user tries to save without first name")
    public void user_tries_to_save_without_first_name() {

        sendText("", addEmployeePage.firstNameField); // leave empty
        sendText("Test", addEmployeePage.lastNameField);

        click(addEmployeePage.saveButton);
    }
    @Then("user should display required field error")
    public void user_should_display_required_field_error() {
        Assert.assertTrue(addEmployeePage.fieldErrorMessage.isDisplayed());
        Assert.assertEquals("Required", addEmployeePage.fieldErrorMessage.getText());
    }

}


