package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static support.TestContext.getDriver;

public class QuoteForm {
    private String url;
    private String title;

    public QuoteForm() {
        PageFactory.initElements(getDriver(), this);
        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }

    public void open() {
        getDriver().get(url);
    }


    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
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
        inputFields.add(username);
        inputFields.add(email);
        inputFields.add(password);


        for (WebElement inputField : inputFields) {
            if (inputField.getAttribute("name").contains(field)) {
                inputField.sendKeys(value);
            }
        }
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

}
