package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteResult extends Page {

    public QuoteResult() {

    }

    @FindBy(id = "quotePageResult")
    private WebElement result;

    @FindBy(xpath = "//b[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement agreedToPrivacyPolicy;

    @FindBy(xpath = "//b[@name='allowedToContact']")
    private WebElement allowedToContact;

    public String getResult() {
        return result.getText();
    }

    public boolean isAgreedToPrivacyPolicy() {
        return Boolean.parseBoolean(agreedToPrivacyPolicy.getText());
    }

    public boolean isAllowedToContact() {
        return Boolean.parseBoolean(allowedToContact.getText());
    }

    public String getPassword() {
        return password.getText();
    }
}