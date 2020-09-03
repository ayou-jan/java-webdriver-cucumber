package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class UpsStepDefs {
    @And("I open Shipping menu")
    public void iOpenShippingMenu() {
        getDriver().findElement(By.xpath("//a[@id='ups-menuLinks2']")).click();

    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        getDriver().findElement(By.xpath("//ul[@class='ups-menu_links']//a[contains(text(),'Shipment')]")).click();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
        getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//select[@id='origincountry']"))));
        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys("Artur");
        getDriver().findElement(By.xpath("//input[@id='origincontactName']")).sendKeys("Artur Ayriyan");
        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys("8713 wandering Creek Way");
        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys("28227");
        getWait().until(ExpectedConditions.textToBePresentInElementValue(getDriver().findElement(By.xpath("//input[@id='origincity']")), "CHARLOTTE"));
        getWait().until(ExpectedConditions.textToBePresentInElement(getDriver().findElement(By.xpath("//select[@id='originstate']")), "North Carolina"));
        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys("aa@gmail.com");
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys("1234567890");
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() throws InterruptedException {
        if (getDriver().findElement(By.xpath("//span[@class='button-spinner']/button")).getText().equals("Continue")) {
            getExecutor().executeScript("arguments[0].click()", getDriver().findElement(By.xpath("//button[contains(@id,'ContinueButton')]")));
        } else {
            getExecutor().executeScript("arguments[0].click()", getDriver().findElement(By.xpath("//button[contains(@id,'ReviewPrimaryButton')]")));
        }

    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        assertThat(getDriver().findElement(By.xpath("//div[@class='ups-group ups-group_condensed']")).getText()).contains("8713 wandering Creek Way, CHARLOTTE, NC 28227");
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() throws InterruptedException {
        getExecutor().executeScript("arguments[0].click()", getDriver().findElement(By.xpath("//button[contains(@id,'CancelShipmentButton')]")));
        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();
    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        assertThat(getDriver().findElement(By.xpath("//input[@id='originname']")).getText()).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='origincontactName']")).getText()).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originaddress1']")).getText()).isEmpty();
    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {
        getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//select[@id='destinationcountry']"))));
        getDriver().findElement(By.xpath("//input[@id='destinationname']")).sendKeys("Artur");
        getDriver().findElement(By.xpath("//input[@id='destinationcontactName']")).sendKeys("Brain Boyd");
        getDriver().findElement(By.xpath("//input[@id='destinationaddress1']")).sendKeys("11 Wall St");
        getDriver().findElement(By.xpath("//input[@id='destinationpostal']")).sendKeys("10005");
        getWait().until(ExpectedConditions.textToBePresentInElementValue(getDriver().findElement(By.xpath("//input[@id='destinationcity']")), "NEW YORK"));
        //getWait().until(ExpectedConditions.elementToBeSelected(getDriver().findElement(By.xpath("//select[@id='destinationstate']")))); - how to check if the needed element/value was selected?
        getDriver().findElement(By.xpath("//input[@id='destinationemail']")).sendKeys("bb@gmail.com");
        getDriver().findElement(By.xpath("//input[@id='destinationphone']")).sendKeys("0123456789");
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() {
        getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@class,'ups-package_image')]")));
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys("1");
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageLengthField0']")).sendKeys("1");
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWidthField0']")).sendKeys("1");
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageHeightField0']")).sendKeys("1");
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
        WebElement bar = getDriver().findElement(By.xpath("//span[@id='nbsBalanceBarTotalCharges']"));
        getWait().until(ExpectedConditions.textToBePresentInElement(bar, "Total Charges"));
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {
        getExecutor().executeScript("arguments[0].click()", getDriver().findElement(By.xpath("(//div[contains(text(),'Lowest')])[1]/..//p[contains(@id,'TileTotalCharge')]")));
    }

    double firstPrice, secondPrice;
    @And("I set description and check Saturday Delivery type")
    public void iSetDescriptionAndCheckSaturdayDeliveryType() {
        WebElement totalPrice = getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']"));
        getDriver().findElement(By.xpath("//input[@id='nbsShipmentDescription']")).sendKeys("something");
        firstPrice = Double.parseDouble(totalPrice.getText().substring(1));
        getExecutor().executeScript("arguments[0].click()", getDriver().findElement(By.xpath("//input[contains(@id,'SaturdayDelivery')]")));
        getWait().until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(totalPrice, "$" + firstPrice)));
        secondPrice = Double.parseDouble(totalPrice.getText().substring(1));

    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() {
        assertThat(firstPrice).isNotEqualTo(secondPrice);
    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() {
        getDriver().findElement(By.xpath("//label[@for='other-ways-to-pay-tile']")).click();
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryContactName']")).getText().contains("Artur Ayriyan"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryAddressLine1']")).getText().contains("8713 Wandering Creek Way"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='destinationnbsAgentSummaryContactName']")).getText().contains("Brain Boyd"));
        assertThat(getDriver().findElement(By.xpath("//package-review/div[@class='row']")).getText().contains("1 lbs"));
        assertThat(getDriver().findElement(By.xpath("//package-review/div[@class='row']")).getText().contains("1 in x 1 in x 1 in"));

    }
}
