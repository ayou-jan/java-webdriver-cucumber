package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UspsStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        WebElement mouseHover = getDriver().findElement(By.xpath("//a[text()='Quick Tools']"));
        Thread.sleep(1000);
        actions.moveToElement(mouseHover);
        actions.perform();
        getDriver().findElement(By.xpath("//ul[@role='menu']//img[contains(@alt,'Zip Code')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("(//a[@class='btn-primary zip-code-home'])[1]")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" + state + "']")).click();
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
        Thread.sleep(1000);
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {
        assertThat(getDriver().findElement(By.xpath("//ul[@class='list-group industry-detail']")).getText()).contains(zip);
    }
}
