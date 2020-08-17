package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class MarketStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        if (page.equalsIgnoreCase("quote")) {
            getDriver().get("https://skryabin.com/market/quote.html");
        } else if (page.equalsIgnoreCase("google")) {
            getDriver().get("https://www.google.com");
        } else {
            throw new RuntimeException("Unsupported page: " + page);
        }
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
    }

    @And("I go back and forward, then refresh")
    public void iGoBackAndForwardThenRefresh() throws InterruptedException {
        Thread.sleep(2000);
        getDriver().navigate().back();
        Thread.sleep(2000);
        getDriver().navigate().forward();
        Thread.sleep(2000);
        getDriver().navigate().refresh();
    }

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("Artur");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("Artur@email.com");
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@name='firstName']")).sendKeys("Artur");
        getDriver().findElement(By.xpath("//input[@name='lastName']")).sendKeys("Airiian");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("123456789");
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']")).click();
        getDriver().findElement(By.xpath("//option[@value='China']")).click();
        getDriver().findElement(By.xpath("//input[@value='male']")).click();
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();

    }

    @Then("I verify required fields")
    public void iVerifyRequiredFields() {
        System.out.println(getDriver().findElement(By.xpath("//b[@name='username']")).getText());
        System.out.println(getDriver().findElement(By.xpath("//b[@name='email']")).getText());
        System.out.println(getDriver().findElement(By.xpath("//b[@name='password']")).getText());
        System.out.println(getDriver().findElement(By.xpath("//b[@name='name']")).getText());
        System.out.println(getDriver().findElement(By.xpath("//b[@name='phone']")).getText());
        System.out.println(getDriver().findElement(By.xpath("//b[@name='gender']")).getText());
        System.out.println(getDriver().findElement(By.xpath("//b[@name='countryOfOrigin']")).getText());
        System.out.println("agreed? " + getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText());
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String device) {
        if (device.equals("phone")) {
            getDriver().manage().window().setSize(new Dimension(400, 768));
        } else if (device.equals("desktop")) {
            getDriver().manage().window().setSize(new Dimension(1024, 768));
        } else {
            throw new RuntimeException("Unsupported device");
        }
    }

    @When("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("email.com");
        Thread.sleep(1000);
        // I did not understand what "then delete just one character" mean...
        //getDriver().findElement(By.xpath("//input[@name='email']")).getText();
        //Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("Artur@email.com");
        Thread.sleep(1000);

    }

    @Then("I verify that fields values recorded correctly")
    public void iVerifyThatFieldsValuesRecordedCorrectly() {
        assertThat(getDriver().findElement(By.xpath("//b[@name='username']")).getText()).isEqualTo("Artur");
        assertThat(getDriver().findElement(By.xpath("//b[@name='firstName']")).getText()).isEqualTo("Artur");
        assertThat(getDriver().findElement(By.xpath("//b[@name='lastName']")).getText()).isEqualTo("Airiian");
        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText()).isEqualTo("Artur@email.com");
        assertThat(getDriver().findElement(By.xpath("//b[@name='countryOfOrigin']")).getText()).isEqualTo("China");
        assertThat(getDriver().findElement(By.xpath("//b[@name='password']")).getText()).contains("entered");
        assertThat(getDriver().findElement(By.xpath("//b[@name='phone']")).getText()).contains("123456789");
        assertThat(getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).isDisplayed());

    }

    @And("I {string} agreement")
    public void iAgreement(String choice) {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        switch (choice) {
            case "accept":
                getDriver().switchTo().alert().accept();
                break;
            case "dismiss":
                getDriver().switchTo().alert().dismiss();
                break;
            case "default":
                System.out.println("What to do?");
                break;
        }
    }
}
