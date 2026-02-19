package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    public AddEmployeePage(){
        //the code we write will be automatically called when you create an object
        //page factory we use to initialise all the elements we use from selenium and the driver is coming from cm
        PageFactory.initElements(driver,this);
    }

    //here we will create objects of the web elements and methods related to add employee page

    @FindBy(xpath = "//*[@name='firstName']")
    public WebElement firstNameField;

    @FindBy(xpath = "//*[@name='lastName']")
    public WebElement lastNameField;

    @FindBy(xpath = "//*[@name='middleName']")
    public WebElement middleNameField;

    @FindBy(xpath = "//label[text()='Employee Id']/../following-sibling::div/input")
    public WebElement employeeIdField;

    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement saveButton;

    @FindBy(xpath = "//h6[text()='Personal Details']")
    public WebElement personalDetailsHeader;

    // --- Error Messages ---
    @FindBy(css = "span.oxd-input-field-error-message")
    public WebElement fieldErrorMessage;

    // --- Method to get auto-generated Employee ID ---
    public String getEmployeeId() {
        return employeeIdField.getAttribute("value");

    }
}
