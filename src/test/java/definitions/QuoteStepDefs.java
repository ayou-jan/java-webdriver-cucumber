package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ErrorNotes;
import pages.QuoteForm;
import pages.QuoteResult;

import java.util.Map;

import static support.TestContext.getData;

public class QuoteStepDefs {

    QuoteForm formPage = new QuoteForm();
    QuoteResult result = new QuoteResult();
    ErrorNotes errorNotes = new ErrorNotes();

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

        formPage.submit();


    }

    @Then("I verify required fields for {string} oop")
    public void iVerifyRequiredFieldsOop(String role) {
        Map<String, String> user = getData(role);

        result.checkUsername(user.get("username"));
        result.checkEmail(user.get("email"));
        result.checkPassword("[entered]");
        result.checkAgreement("true");
        result.checkName(user.get("firstName") + " " + user.get("lastName"));
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

        result.checkCountryOfOrigin(user.get("countryOfOrigin"));
        result.checkDateOfBirth(user.get("dateOfBirth"));
        result.checkPhone(user.get("phone"));
        result.checkAddress(user.get("address"));
        result.checkGender(user.get("gender"));
    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String type, String msg) {
        errorNotes.checkErrorExistence(type, msg);
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String var) {
        formPage.fillInputField(field, var);
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String type) {
        errorNotes.checkErrorExistence(type);
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
