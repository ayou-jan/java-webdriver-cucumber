package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class UpsForm extends Page {

    public UpsForm() {
        url = "https://www.ups.com/us/en/Home.page";
    }

    @FindBy(id = "ups-menuLinks2")
    private WebElement shipping;

    @FindBy(xpath = "//a[contains(text(),'Create a Shipment:')]")
    private WebElement createNewShipment;

    @FindBy(xpath = "//button[contains(@id,'ContinueButton')]")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='ups-group ups-group_condensed']")
    private WebElement originInfoField;

    @FindBy(xpath = "//button[contains(@id,'CancelShipmentButton')]")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[@id='nbsCancelShipmentWarningYes']")
    private WebElement agreeWithCancel;

    @FindBy(xpath = "//h2[contains(text(),'Hello. Where')]")
    private WebElement shipmentFormHeader;

    public void shipping() {
        shipping.click();
    }

    public void createAShipment() {
        createNewShipment.click();
    }

    public void fillAllFields(Map<String, String> person) {
        for (Map.Entry<String, String> entry : person.entrySet()) {
            inputElement(entry.getKey()).sendKeys(entry.getValue());
        }
    }

    private WebElement inputElement(String fieldName) {
        return getDriver().findElement(By.id(fieldName));
    }

    public void next() {
        getExecutor().executeScript("arguments[0].click()", continueButton);
    }

    public boolean isOriginInfoMatches(Map<String, String> person) {
        boolean isMatch = true;
        for (Map.Entry<String, String> entry : person.entrySet()) {
            if (!entry.getKey().equals("originstate")) {         //we don't compare with the state, because North Carolina != NC
                if (!originInfoField.getText().contains(entry.getValue())) {
                    isMatch=false;
                    break;
                }
            }
        }
        return isMatch;
    }

    public void cancel() {
        getExecutor().executeScript("arguments[0].click()", cancelButton);
        agreeWithCancel.click();
    }

    public boolean isReseted() {
        boolean isReseted = true;
        if (!shipmentFormHeader.isDisplayed()) {
            isReseted = false;
        }
        return isReseted;
    }
}
