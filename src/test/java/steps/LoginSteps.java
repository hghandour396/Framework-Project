package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    // public WebDriver driver;

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {

        openBrowserAndLaunchApplication();
    }

    @When("user leaves admin username empty")
    public void user_leaves_admin_username_empty() {

        //   usernameField.sendKeys(ConfigReader.read("userName"));
        //   passwordField.sendKeys(ConfigReader.read("password"));

        sendText("", loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
        //   loginButton.click();
        click(loginPage.loginButton);
    }
    @Then("I should see the error message {string}")
    public void i_should_see_the_error_message(String expectedMessage) {

        String actualMessage = loginPage.getErrorMessage();

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("user leaves password empty")
    public void user_leaves_password_empty() {

        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText("", loginPage.passwordField);
    }

    @When("user enters invalid admin username and password")
    public void user_enters_invalid_admin_username_and_password() {
        //   usernameField.sendKeys("hrm_user3245");
        //   passwordField.sendKeys("Hrm_user@1232334");

        sendText("hrm_@user", loginPage.usernameField);
        sendText("Hrm_user123", loginPage.passwordField);
    }

    @Then("user should be able to attempt login again")
    public void user_can_try_again() {
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());

    }
    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        //   usernameField.sendKeys(ConfigReader.read("userName"));
        //   passwordField.sendKeys(ConfigReader.read("password"));
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }


    @Then("user is able to login successfully")
    public void user_is_able_to_login_successfully() {
        //using assertion to verify that the user is logged in successfully
        //we can verify it by checking the presence of welcome message on the dashboard page
        Assert.assertTrue(dashboardPage.welcomeScreenLoc.isDisplayed());

    }
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        // pimOption.click();
        click(dashboardPage.pimOption);
    }

    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {

        //  addEmpOption.click();
        click(dashboardPage.addEmpOption);
    }
}