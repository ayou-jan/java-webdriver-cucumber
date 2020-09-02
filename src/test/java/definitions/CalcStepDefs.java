package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;


public class CalcStepDefs {
    @When("I navigate to {string}")
    public void iNavigateTo(String page) {
        getDriver().findElement(By.xpath("//a[contains(text(),'" + page + "')]")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(By.xpath("//input[@name='cloanamount']")).clear();
        getDriver().findElement(By.xpath("//input[@name='cloanterm']")).clear();
        getDriver().findElement(By.xpath("//input[@name='cinterestrate']")).clear();
        getDriver().findElement(By.xpath("//input[@name='cdownpayment']")).clear();
        getDriver().findElement(By.xpath("//input[@name='ctradeinvalue']")).clear();
        getDriver().findElement(By.xpath("//input[@name='csaletax']")).clear();
        getDriver().findElement(By.xpath("//input[@name='ctitlereg']")).clear();
    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String error) {
        WebElement errorField = getDriver().findElement(By.xpath("//td[@valign='top']/a[@name='autoloanresult']/.."));
        assertThat(errorField.getText()).contains(error);
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String months, String interest, String downpayment, String tradeIn, String state, String tax, String fees) {
        getDriver().findElement(By.xpath("//input[@name='cloanamount']")).sendKeys(price);
        getDriver().findElement(By.xpath("//input[@name='cloanterm']")).sendKeys(months);
        getDriver().findElement(By.xpath("//input[@name='cinterestrate']")).sendKeys(interest);
        getDriver().findElement(By.xpath("//input[@name='cdownpayment']")).sendKeys(downpayment);
        getDriver().findElement(By.xpath("//input[@name='ctradeinvalue']")).sendKeys(tradeIn);
        new Select(getDriver().findElement(By.xpath("//select[@name='cstate']"))).selectByVisibleText(state);
        getDriver().findElement(By.xpath("//input[@name='csaletax']")).sendKeys(tax);
        getDriver().findElement(By.xpath("//input[@name='ctitlereg']")).sendKeys(fees);
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String pay) {
        assertThat(getDriver().findElement(By.xpath("//h2[contains(text(),'Monthly Pay')]")).getText()).contains(pay);
    }
}
