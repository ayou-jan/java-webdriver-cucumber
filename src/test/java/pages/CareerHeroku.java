package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerHeroku extends Page {

    public CareerHeroku() {
        url="https://skryabin-careers.herokuapp.com/";
    }

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement loginButton;

    public LoginHeroku pressLogin() {
        loginButton.click();
        return new LoginHeroku();
    }
}
