package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuoteResult {

    public QuoteResult() {
        PageFactory.initElements(getDriver(), this);
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

    @FindBy(name = "agreedToPrivacyPolicy")
    private WebElement privacy;

    public void checkUsername(String value) {
        assertThat(username.getText()).isEqualTo(value);
    }

    public void checkEmail(String value) {
        assertThat(email.getText()).isEqualTo(value);
    }

    public void checkName(String value) {
        assertThat(name.getText()).isEqualTo(value);
    }
    public void checkPassword(String value) {
        assertThat(password.getText()).isEqualTo(value);
    }
    public void checkAgreement(String value) {
        assertThat(privacy.getText()).isEqualTo(value);
    }

    public void checkCountryOfOrigin(String value) {
        assertThat(countryOfOrigin.getText()).isEqualTo(value);
    }

    public void checkDateOfBirth(String value) {
        assertThat(dateOfBirth.getText()).isEqualTo(value);
    }

    public void checkPhone(String value) {
        assertThat(phoneNumber.getText()).isEqualTo(value);
    }

    public void checkAddress(String value) {
        assertThat(address.getText()).isEqualTo(value);
    }

    public void checkGender(String value) {
        assertThat(gender.getText()).isEqualTo(value);
    }


}