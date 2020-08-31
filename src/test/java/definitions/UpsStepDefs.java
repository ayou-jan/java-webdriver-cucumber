package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
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
        //getWait().until(ExpectedConditions.elementToBeSelected(getDriver().findElement(By.xpath("//select[@id='originstate']")))); - how to check if the needed element/value was selected?
        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys("aa@gmail.com");
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys("1234567890");
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        getExecutor().executeScript("arguments[0].click()", getDriver().findElement(By.xpath("//button[contains(@id,'ContinueButton')]")));
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
}
