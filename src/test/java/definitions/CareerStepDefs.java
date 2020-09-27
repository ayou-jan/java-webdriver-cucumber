package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CareerHeroku;
import pages.ListHeroku;
import pages.LoginHeroku;
import pages.PositionHeroku;

public class CareerStepDefs {

    CareerHeroku careerHeroku = new CareerHeroku();
    LoginHeroku loginHeroku = new LoginHeroku();
    ListHeroku listHeroku = new ListHeroku();
    PositionHeroku positionHeroku = new PositionHeroku();

    @And("I login as {string}")
    public void iLoginAs(String username) {
        careerHeroku
                .pressLogin()
                .login(username);
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String username) {
        listHeroku.verifyLogin();
    }

    @When("I remove {string} position")
    public void iRemovePosition(String position) throws InterruptedException {
        listHeroku.select(position);
        positionHeroku.withdraw();
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String position) throws InterruptedException {
        listHeroku.verifyWithdraw(position);
    }
}
