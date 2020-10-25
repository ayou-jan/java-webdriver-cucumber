package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class CareerStepDefs {

    CareersLanding careersLanding = new CareersLanding();
    CareerLogin careerLogin = new CareerLogin();
    ListHeroku listHeroku = new ListHeroku();
    PositionHeroku positionHeroku = new PositionHeroku();
    RecruitList recruitList = new RecruitList();
    NewPosition newPosition = new NewPosition();

    @And("I login as {string}")
    public void iLoginAs(String username) {
        careersLanding
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
        assertThat(recruitList.verifyExistence(position)).isFalse();
    }

    @When("I create new position")
    public void iCreateNewPosition() throws InterruptedException {
        listHeroku.goToRecruitList();
        recruitList.goToNewPosition()
        .fillFields("automation");
        newPosition.submit();
        //recruitList.waitUpdatedList();

    }

    @Then("I verify new position is created")
    public void iVerifyNewPositionIsCreated() throws InterruptedException {
        Thread.sleep(2000);
        //getDriver().navigate().refresh();
        assertThat(recruitList.checkPosition()).isTrue();
    }


    @When("I remove new position")
    public void iRemoveNewPosition() {
        recruitList.removePosition(getData("automation").get("Title"));
    }

    @And("I verify new position is removed")
    public void iVerifyNewPositionIsRemoved() {
        assertThat(recruitList.verifyExistence(getData("automation").get("Title"))).isFalse();
    }
}
