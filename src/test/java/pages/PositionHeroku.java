package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PositionHeroku extends Page {

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement withdrawButton;

    public void withdraw() {
        withdrawButton.click();
    }

}
