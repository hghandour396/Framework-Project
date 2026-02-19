package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class LoginPage extends CommonMethods {

    @FindBy(xpath = "//*[@name='username']")
    public WebElement usernameField;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginButton;

    public String getErrorMessage() {

        List<WebElement> invalidMsg =
                driver.findElements(By.cssSelector("p.oxd-alert-content-text"));

        if (!invalidMsg.isEmpty()) {
            return invalidMsg.get(0).getText().trim();
        }

        List<WebElement> requiredMsg =
                driver.findElements(By.cssSelector("span.oxd-input-field-error-message"));

        if (!requiredMsg.isEmpty()) {
            return requiredMsg.get(0).getText().trim();
        }

        return null;
    }

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
}