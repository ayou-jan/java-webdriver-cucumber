package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CareerStepDefs {

    CareerHeroku careerHeroku = new CareerHeroku();
    LoginHeroku loginHeroku = new LoginHeroku();
    ListHeroku listHeroku = new ListHeroku();
    PositionHeroku positionHeroku = new PositionHeroku();
    RecruitList recruitList = new RecruitList();

    @And("I login as {string}")
    public void iLoginAs(String username) {
        careerHeroku
                .pressLogin()
                .login(username);
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String username) {
        assertThat(listHeroku.verifyLogin()).isTrue();
    }

    @When("I remove {string} position")
    public void iRemovePosition(String position) {
        listHeroku.goToRecruitList();
        recruitList.removePosition(position);
//        listHeroku.select(position);
//        positionHeroku.withdraw();
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String position) {
        assertThat(recruitList.verifyExistance(position)).isFalse();
    }
}
