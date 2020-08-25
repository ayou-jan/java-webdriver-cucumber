package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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

    @Given("I need {string} page")
    public void iNeedPage(String page) throws InterruptedException {
        getDriver().get(page);
        getDriver().findElement(By.partialLinkText("Look Up a ZIP")).click();
        Thread.sleep(1000);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        Actions actions = new Actions(getDriver());
        WebElement menuElement = getDriver().findElement(By.xpath("//a[contains(@class,'nav-first-element')]"));
        WebElement calculateElement = getDriver().findElement(By.xpath("//img[contains(@alt,'Calculate')]"));
        actions.moveToElement(menuElement).click(calculateElement).perform();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String arg0, String arg1) {
        Select stateSelect = new Select(getDriver().findElement(By.xpath("//select[@id='CountryID']")));
        stateSelect.selectByVisibleText("Canada");
        getDriver().findElement(By.xpath("//input[@value='Postcard']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {
        assertThat(getDriver().findElement(By.xpath("//div[@id='total']")).getText()).contains(cost);
    }

    @When("I go to {string} tab")
    public void iGoToTab(String helpTab) {
        getDriver().findElement(By.xpath("//a[contains(@href,'faq')]")).click();
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String search) {
        getDriver().findElement(By.xpath("//input[contains(@class,'search-field')]")).sendKeys(search);
        getDriver().findElement(By.xpath("//button[@Title='Search']")).click();
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String result) {
        assertThat(getDriver().findElement(By.xpath("//div[@class='listContent']")).getText()).doesNotContain(result);
    }

    @When("I navigate to Find a Location page")
    public void iNavigateToFindALocationPage() {
        Actions actions = new Actions(getDriver());
        WebElement menuElement = getDriver().findElement(By.xpath("//a[contains(@class,'nav-first-element')]"));
        WebElement calculateElement = getDriver().findElement(By.xpath("//img[contains(@alt,'Locator')]"));
        actions.moveToElement(menuElement).click(calculateElement).perform();
    }

    @And("I filter by {string} location types, {string} services, {string} available services")
    public void iFilterByLocationTypesServicesAvailableServices(String locType, String service, String available) {
        getDriver().findElement(By.xpath("//button[@id='post-offices-select']")).click();
        getDriver().findElement(By.xpath("//a[@data-value='po']")).click();
        getDriver().findElement(By.xpath("//button[@id='service-type-select']")).click();
        getDriver().findElement(By.xpath("//a[contains(text()," + "\'" + service + "\'" + ")]")).click();
        getDriver().findElement(By.xpath("//button[@id='available-service-select']")).click();
        getDriver().findElement(By.xpath("//a[contains(text()," + "\'" + available + "\'" + ")]")).click();
    }

    @And("I provide data as {string} street, {string} city, {string} state")
    public void iProvideDataAsStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='search-input']")).click();
        getDriver().findElement(By.xpath("//input[@id='addressLineOne']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(city);
        Select stateSelect = new Select(getDriver().findElement(By.xpath("//select[@id='servicesStateSelect']")));
        stateSelect.selectByValue(state);
        getDriver().findElement(By.xpath("//a[contains(text(),'Results')]")).click();

    }

    @Then("I verify phone number is {string}")
    public void iVerifyPhoneNumberIs(String phoneNumber) {
        getDriver().findElement(By.xpath("//div[@id='resultBox']/div/div")).click();
        assertThat(getDriver().findElement(By.xpath("//p[@class='ask-usps']")).getText()).contains(phoneNumber);
    }
}
