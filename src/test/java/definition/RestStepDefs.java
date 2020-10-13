package definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.RestClient;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class RestStepDefs {

    RestClient restClient = new RestClient();

    @Given("I login via REST as {string}")
    public void iLoginViaRESTAs(String role) {
        restClient.login(getData(role));
    }

    @When("I create via REST {string} position")
    public void iCreateViaRESTPosition(String type) {
        restClient.createPosition(getPosition(type));
    }

    @Then("I verify via REST new {string} position is in the list")
    public void iVerifyViaRESTNewPositionIsInTheList(String type) {
        List<Map<String, Object>> actualPositions = restClient.getPositions();
        Map<String, String> expectedPosition = getPosition(type);

        boolean isFound = false;
        for (Map<String, Object> actualPosition : actualPositions) {
            if (actualPosition.get("id").equals(restClient.positionId)) {
                for (String key : expectedPosition.keySet()) {
                    assertThat(actualPosition.get(key)).isEqualTo(expectedPosition.get(key));
                }
                isFound = true;
                break;
            }
        }
        assertThat(isFound).isTrue();
    }


    @When("I update via REST {string} position")
    public void iUpdateViaRESTPosition(String type) {
        Map<String, String> updatedPosition = getPosition(type + "_updated");
        restClient.updatePosition(updatedPosition, restClient.positionId);
    }

    @Then("I verify via REST new {string} position is updated")
    public void iVerifyViaRESTNewPositionIsUpdated(String type) {
        Map<String, Object> actualPosition = restClient.getPosition(restClient.positionId);
        Map<String, String> expectedFields = getPosition(type + "_updated");

        for (String key : expectedFields.keySet()) {
            assertThat(actualPosition.get(key)).isEqualTo(expectedFields.get(key));
        }
    }

    @When("I delete via REST new position")
    public void iDeleteViaRESTNewPosition() {
        restClient.deletePositionById(restClient.positionId);
    }

    @Then("I verify via REST new position is deleted")
    public void iVerifyViaRESTNewPositionIsDeleted() {
        List<Map<String, Object>> actualPositions = restClient.getPositions();
        for (Map<String, Object> position : actualPositions) {
            assertThat(position.get("id")).isNotEqualTo(restClient.positionId);
        }
    }

    @When("I create via REST {string} candidate")
    public void iCreateViaRESTCandidate(String person) {
        restClient.createCandidate(getCandidate(person));
    }

    @Then("I verify via REST new {string} candidate is in the list")
    public void iVerifyViaRESTNewCandidateIsInTheList(String person) {
        List<Map<String, Object>> actualCandidates = restClient.getCandidates();
        Map<String, String> expectedCandidate = getCandidate(person);

        boolean isFound = false;
        for (Map<String, Object> actualCandidate : actualCandidates) {
            if (actualCandidate.get("id").equals(restClient.candidateId)) {
                for (String key : expectedCandidate.keySet()) {
                    if (!(key.equals("password"))) {
                        assertThat(actualCandidate.get(key)).isEqualTo(expectedCandidate.get(key));
                    }
                }
                isFound = true;
                break;
            }
        }
        assertThat(isFound).isTrue();
    }

    @When("I update via REST {string} candidate")
    public void iUpdateViaRESTCandidate(String person) {
        Map<String, String> updatedCandidate = getCandidate(person + "_updated");
        restClient.updateCandidate(updatedCandidate, restClient.candidateId);
    }

    @Then("I verify via REST new {string} candidate is updated")
    public void iVerifyViaRESTNewCandidateIsUpdated(String person) {
        Map<String, Object> actualCandidate = restClient.getCandidate(restClient.candidateId);
        Map<String, String> expectedFields = getCandidate(person + "_updated");

        for (String key : expectedFields.keySet()) {
            assertThat(actualCandidate.get(key)).isEqualTo(expectedFields.get(key));
        }
    }

    @When("I delete via REST new candidate")
    public void iDeleteViaRESTNewCandidate() {
        restClient.deleteCandidateById(restClient.candidateId);
    }

    @Then("I verify via REST new candidate is deleted")
    public void iVerifyViaRESTNewCandidateIsDeleted() {
        List<Map<String, Object>> actualCandidates = restClient.getCandidates();
        for (Map<String, Object> candidate : actualCandidates) {
            assertThat(candidate.get("id")).isNotEqualTo(restClient.candidateId);
        }
    }
}

