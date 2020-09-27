package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Map;

import static support.TestContext.getData;

public class LoginHeroku extends Page {

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    private WebElement Logout;

    @FindBy(xpath = "//input[@placeholder='Please enter an Email']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@placeholder='Please enter a Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@id='loginButton']")
    private WebElement submitLogin;

    public void login(String user) {
        Map<String, String> users = getData("careerUsers");
        for (Map.Entry<String, String> userInfo : users.entrySet()) {
            if (userInfo.getKey().equals(user)) {
                String[] credentials = userInfo.getValue().split(" ");
                usernameInput.sendKeys(credentials[0]);
                passwordInput.sendKeys(credentials[1]);
            } else {
                new RuntimeException("No such a user " + user);
            }
        }
        submitLogin.click();
    }

}
