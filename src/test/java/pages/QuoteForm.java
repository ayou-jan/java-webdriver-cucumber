package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuoteForm extends Page {

    public QuoteForm() {
        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }

    @FindBy(xpath = "//*[@name='username'][@type='text']")
    private WebElement username;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(xpath = "//*[@name='password'][@type='password']")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@name='name'][@type='text']")
    private WebElement name;

    @FindBy(xpath = "//*[@name='firstName'][@type='text']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@name='middleName'][@type='text']")
    private WebElement middleName;

    @FindBy(xpath = "//*[@name='lastName'][@type='text']")
    private WebElement lastName;

    @FindBy(name = "phone")
    private WebElement phoneNumber;

    @FindBy(name = "address")
    private WebElement address;

    @FindBy(name = "dateOfBirth")
    private WebElement dateOfBirth;

    @FindBy(name = "countryOfOrigin")
    private WebElement countryOfOrigin;

    @FindBy(name = "gender")
    private WebElement gender;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    @FindBy(name = "agreedToPrivacyPolicy")
    private WebElement privacy;

    @FindBy(id = "formSubmit")
    private WebElement submit;

    List<WebElement> inputFields = new ArrayList();


    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillInputField(String field, String value) {
        username.clear();
        if (inputFields.size()!=0) {
            inputFields.removeAll(inputFields);
        }
        inputFields.add(username);
        inputFields.add(email);
        inputFields.add(password);
        inputFields.add(confirmPassword);

        for (WebElement inputField : inputFields) {
            if (inputField.getAttribute("name").contains(field)) {
                inputField.sendKeys(value);
            }
        }
        phoneNumber.click();
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillBothPasswords(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }

    public void agreeWithPrivacyPolicy() {
        if (!privacy.isSelected()) {
            privacy.click();
        }
    }

    public void fillPhoneNumber(String value) {
        phoneNumber.sendKeys(value);
    }

    public void fillDateOfBirth(String value) {
        dateOfBirth.sendKeys(value);
    }

    public void fillCountryOfOrigin(String value) {
        countryOfOrigin.sendKeys(value);
    }

    public void fillAddress(String value) {
        address.sendKeys(value);
    }

    public void selectGender() {
        gender.click();
    }

    public void submit() {

        submit.click();
    }

    // dynamic field
    private WebElement errorElement(String fieldName) {
        return getDriver().findElement(By.id(fieldName + "-error"));
    }

    public String getErrorFieldText(String fieldName) {
        return errorElement(fieldName).getText();
    }

    public boolean isErrorFieldDisplayed(String fieldName) {
        boolean isDisplayed;
        try {
            isDisplayed = errorElement(fieldName).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public void checkContent(String field, String value) {
        assertThat(name.getAttribute("value")).isEqualTo(value);
    }

}
