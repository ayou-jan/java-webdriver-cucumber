package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ErrorNotes {

    public ErrorNotes() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "username-error")
    private WebElement usernameError;

    @FindBy(id = "email-error")
    private WebElement emailError;

    @FindBy(id = "password-error")
    private WebElement passwordError;

    @FindBy(id = "name-error")
    private WebElement nameError;

    @FindBy(id = "agreedToPrivacyPolicy-error")
    private WebElement agreedToPrivacyPolicyError;

    List<WebElement> errorTypes = new ArrayList();

    public void checkErrorExistence(String type, String error) {
        errorTypes.add(usernameError);
        errorTypes.add(emailError);
        errorTypes.add(passwordError);
        errorTypes.add(nameError);
        errorTypes.add(agreedToPrivacyPolicyError);
        for (WebElement errorType : errorTypes) {
            if (errorType.getAttribute("for").contains(type)) {
                assertThat(errorType.getText()).contains(error);
            }
        }
    }

    public void checkErrorExistence(String type) {
        errorTypes.add(usernameError);
        errorTypes.add(emailError);
        errorTypes.add(passwordError);
        errorTypes.add(nameError);
        errorTypes.add(agreedToPrivacyPolicyError);
        for (WebElement errorType : errorTypes) {
            if (errorType.getAttribute("for").contains(type)) {
                assertThat(!errorType.isEnabled());
            }
        }
    }
}
