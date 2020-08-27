package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.*;

import static support.TestContext.getDriver;

public class UnitConverterStepDafs {
    @Given("I go to converter page")
    public void iGoToConverterPage() {
        getDriver().get("https://www.unitconverters.net/");
    }


    @And("I click on {string}")
    public void iClickOnTemperature(String unit) {
        getDriver().findElement(By.xpath("//div[@id='menu']//a[text()='" + unit + "']")).click();
    }

    @And("I set from {string} Unit and to {string} Unit")
    public void iSetFromUnitAndToUnit(String fromUnit, String toUnit) {
        new Select(getDriver().findElement(By.xpath("//select[@id='calFrom']"))).selectByVisibleText(fromUnit);
        new Select(getDriver().findElement(By.xpath("//select[@id='calTo']"))).selectByVisibleText(toUnit);
    }

    @And("I set {int} in From field value and verify that result is {double} in To value")
    public void iSetInFromFieldValueAndVerifyThatResultIsInToValue(int fromValue, double toValue) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(String.valueOf(fromValue));
        assertThat(toValue).isEqualTo(Double.parseDouble(getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value").substring(0, 4)));
    }
}
