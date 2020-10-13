package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import java.util.Map;
import static support.TestContext.setTestData;

public class RestClient {

    private String baseUrl = "https://skryabin.com/recruit/api/v1/";
    private static String loginToken;
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";
    public static int positionId;
    public static int candidateId;

    public void login(Map<String, String> user) {

        RequestSpecification request = RestAssured
                .given().log().all()
                .baseUri(baseUrl)
                .basePath("login")
                .header(CONTENT_TYPE, JSON)
                .body(user);

        Response response = request.post();

        Map<String, Object> result = response
                .then().log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        loginToken = "Bearer " + result.get("token");

        System.out.println(loginToken);
    }

    public Map<String, Object> createPosition(Map<String, String> position) {

        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("positions")
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken)
                .body(position);

        Response response = request.post();

        Map<String, Object> result = response.then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");

        setTestData("newPosition", result);
        positionId = (int) result.get("id");
        return result;
    }

    public List<Map<String, Object>> getPositions() {
        return RestAssured
                .given().log().all()
                .baseUri(baseUrl)
                .basePath("positions")
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");
    }

    public Map<String, Object> updatePosition(Map<String, String> fields, int id) {

        return RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("positions/" + id)
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken)
                .body(fields)
                .when()
                .patch()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

    }

    public Map<String, Object> getPosition(int id) {
        return RestAssured
                .given().log().all()
                .baseUri(baseUrl)
                .basePath("positions/" + id)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
    }

    public void deletePositionById(int id) {
        RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("positions/" + id)
                .header(AUTH, loginToken)
                .when()
                .delete()
                .then()
                .log().all()
                .statusCode(204);

    }

    public Map<String, Object> createCandidate(Map<String, String> client) {

        Map<String, Object> result = RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("candidates")
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken)
                .body(client)
                .post().then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");

        setTestData("newCandidate", result);
        candidateId = (int) result.get("id");
        return result;
    }

    public List<Map<String, Object>> getCandidates() {
        return RestAssured
                .given().log().all()
                .baseUri(baseUrl)
                .basePath("candidates")
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");
    }

    public Map<String, Object> updateCandidate(Map<String, String> fields, int id) {

        return RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("candidates/" + id)
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken)
                .body(fields)
                .when()
                .patch()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

    }

    public Map<String, Object> getCandidate(int id) {
        return RestAssured
                .given().log().all()
                .baseUri(baseUrl)
                .basePath("candidates/" + id)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
    }

    public void deleteCandidateById(int id) {
        RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("candidates/" + id)
                .header(AUTH, loginToken)
                .when()
                .delete()
                .then()
                .log().all()
                .statusCode(204);

    }
}
