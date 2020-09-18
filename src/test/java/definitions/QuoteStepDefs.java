package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pages.QuoteForm;
import pages.QuoteResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class QuoteStepDefs {

    QuoteForm formPage = new QuoteForm();
    QuoteResult result = new QuoteResult();

    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page) {
            case "quote":

                formPage.open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }

    @When("I fill out required fields for {string} oop")
    public void iFillOutRequiredFieldsForOop(String role) {
        Map<String, String> user = getData(role);

        formPage.fillUsername(user.get("username"));
        formPage.fillEmail(user.get("email"));
        formPage.fillBothPasswords(user.get("password"));
        formPage.fillName(user.get("firstName"), user.get("lastName"));
        formPage.agreeWithPrivacyPolicy();


    }

    @And("I submit the form oop")
    public void iSubmitTheFormOop() throws InterruptedException {
        getDriver().findElement(By.xpath("//div[@class='well form-summary']")).click();
        formPage.submit();


    }

    @Then("I verify required fields for {string} oop")
    public void iVerifyRequiredFieldsOop(String role) {
        Map<String, String> user = getData(role);
        assertThat(result.getResult()).contains(user.get("username"));
        assertThat(result.getResult()).contains(user.get("email"));
        assertThat(result.getResult()).contains(user.get("firstName") + " " + user.get("lastName"));
        assertThat(result.getPassword()).isEqualTo("[entered]");
        assertThat(result.getResult()).doesNotContain(user.get("password"));
    }

    @When("I fill out optional fields for {string} oop")
    public void iFillOutOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        formPage.fillCountryOfOrigin(user.get("countryOfOrigin"));
        formPage.fillDateOfBirth(user.get("dateOfBirth"));
        formPage.fillPhoneNumber(user.get("phone"));
        formPage.fillAddress(user.get("address"));
        formPage.selectGender();
    }

    @Then("I verify optional fields for {string} oop")
    public void iVerifyOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);

        assertThat(result.getResult()).contains(user.get("countryOfOrigin"));
        assertThat(result.getResult()).contains(user.get("dateOfBirth"));
        assertThat(result.getResult()).contains(user.get("address"));
        assertThat(result.getResult()).contains(user.get("phone"));
        assertThat(result.getResult()).contains(user.get("gender"));
        assertThat(result.isAgreedToPrivacyPolicy()).isTrue();
    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String errorField, String errorMessage) {
        String actualError = formPage.getErrorFieldText(errorField);
        assertThat(actualError).isEqualTo(errorMessage);
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String var) {
        formPage.fillInputField(field, var);
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String errorField) {
        assertThat(formPage.isErrorFieldDisplayed(errorField)).isFalse();
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstName, String lastName) {
        formPage.fillName(firstName, lastName);
    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String type, String fullName) {
        formPage.checkContent(type, fullName);
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstName, String middleName, String lastName) {
        formPage.fillName(firstName, middleName, lastName);
    }
}
