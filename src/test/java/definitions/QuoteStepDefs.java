package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.QuoteForm;
import pages.QuoteResult;

import java.util.Map;

import static support.TestContext.getData;

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
    public void iSubmitTheFormOop() {

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
}
