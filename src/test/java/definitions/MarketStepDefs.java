package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class MarketStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        if (page.equalsIgnoreCase("quote")) {
            getDriver().get("https://skryabin.com/market/quote.html");
        } else if (page.equalsIgnoreCase("usps")) {
            getDriver().get("https://www.usps.com/");
        }else if (page.equalsIgnoreCase("google")) {
            getDriver().get("https://www.google.com");
        } else if (page.equalsIgnoreCase("calculator")) {
            getDriver().get("https://www.calculator.net/");
        } else if (page.equalsIgnoreCase("ups")) {
            getDriver().get("https://www.ups.com/us/en/Home.page/");
        }else {
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
        Map<String, String> user = getData("user");
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(user.get("username"));
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(user.get("email"));
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(user.get("password"));
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(user.get("password"));
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@name='firstName']")).sendKeys(user.get("firstName"));
        getDriver().findElement(By.xpath("//input[@name='lastName']")).sendKeys(user.get("lastName"));
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys(user.get("phone"));
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']")).click();
        getDriver().findElement(By.xpath("//option[@value='" + user.get("countryOfOrigin") + "']")).click();
        getDriver().findElement(By.xpath("//input[@value='" + user.get("gender") + "']")).click();
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

    @Then("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@id='return']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("email.com");
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@id='password']")).click();
        getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed();
        String currentEmail = getDriver().findElement(By.xpath("//input[@name='email']")).getAttribute("value");
        currentEmail = "Artur@" + currentEmail;
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(currentEmail);
        Thread.sleep(1000);
        assertThat(!getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed());

    }

    @Then("I verify that fields values recorded correctly")
    public void iVerifyThatFieldsValuesRecordedCorrectly() {
        Map<String, String> user = getData("user");
        assertThat(getDriver().findElement(By.xpath("//b[@name='username']")).getText()).isEqualTo("user1");
        assertThat(getDriver().findElement(By.xpath("//b[@name='firstName']")).getText()).isEqualTo("Justin");
        assertThat(getDriver().findElement(By.xpath("//b[@name='lastName']")).getText()).isEqualTo("Cloze");
        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText()).isEqualTo("jc@mail.com");
        assertThat(getDriver().findElement(By.xpath("//b[@name='countryOfOrigin']")).getText()).isEqualTo("Canada");
        assertThat(getDriver().findElement(By.xpath("//b[@name='password']")).getText()).doesNotContain("1234567890");
        assertThat(getDriver().findElement(By.xpath("//b[@name='phone']")).getText()).contains("1234567890");
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

    @And("I {string} third party agreement")
    public void iThirdPartyAgreement(String action) throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();

        if (action.equals("accept")) {
            getDriver().switchTo().alert().accept();
        } else if (action.equals("dismiss")) {
            getDriver().switchTo().alert().dismiss();
        } else {
            throw new RuntimeException("Incorrect action: " + action);
        }
    }

    @And("I fill out {string} name and {string} phone contact")
    public void iFillOutNameAndPhoneNumber(String name, String phone) {
        getDriver().switchTo().frame(0);
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(name);
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(phone);
        getDriver().switchTo().defaultContent();
    }

    @And("I verify document list contains {string}")
    public void iVerifyDocumentList(String document) {
        getDriver().findElement(By.xpath("//button[contains(@onclick,'new')]")).click();
        String originalWindow = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        String result = getDriver().findElement(By.xpath("//body")).getText();
        assertThat(result).contains(document);
        getDriver().switchTo().window(originalWindow);
    }
}
