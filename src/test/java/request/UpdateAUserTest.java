package request;

import body.UserBody;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateAUserTest extends RequestBase {

    @Test
    public void updateAUserHappyPath() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180";

        UserBody userBody = new UserBody();
        userBody.setFirstName("Thierry");
        userBody.setLastName("Henry");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .put(path)
        .then()
                .statusCode(200)
                .body("userId", equalTo("c4f6c088-f91b-494e-b7f0-a08f48df3180"));
    }

    @Test
    public void doNotUpdateAUserWithNonExistedUserId() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3181";

        UserBody userBody = new UserBody();
        userBody.setFirstName("Thierry");
        userBody.setLastName("Henry");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .put(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 404 http status code
    }

    @Test
    public void doNotUpdateAUserWithoutFirstName() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180";

        UserBody userBody = new UserBody();
        userBody.setLastName("Henry");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .put(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void doNotUpdateAUserWithoutLastName() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180";

        UserBody userBody = new UserBody();
        userBody.setFirstName("Thierry");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .put(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void doNotUpdateAUserWithOneCharFirstName() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180";

        UserBody userBody = new UserBody();
        userBody.setFirstName("T");
        userBody.setLastName("Henry");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .put(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void updateAUserWithTwoCharFirstName() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180";

        UserBody userBody = new UserBody();
        userBody.setFirstName("Th");
        userBody.setLastName("Henry");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .put(path)
        .then()
                .statusCode(200)
                .body("userId", equalTo("c4f6c088-f91b-494e-b7f0-a08f48df3180"));
    }

    @Test
    public void updateAUserWithFiftyCharFirstName() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180";

        UserBody userBody = new UserBody();
        userBody.setFirstName("Thierryyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        userBody.setLastName("Henry");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .put(path)
        .then()
                .statusCode(200)
                .body("userId", equalTo("c4f6c088-f91b-494e-b7f0-a08f48df3180"));
    }

    @Test
    public void doNotUpdateAUserWithFiftyOneCharFirstName() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180";

        UserBody userBody = new UserBody();
        userBody.setFirstName("Thierryyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        userBody.setLastName("Henry");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .put(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void doNotUpdateAUserWithOneCharLastName() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180";

        UserBody userBody = new UserBody();
        userBody.setFirstName("Thierry");
        userBody.setLastName("H");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .put(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void updateAUserWithTwoCharLastName() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180";

        UserBody userBody = new UserBody();
        userBody.setFirstName("Thierry");
        userBody.setLastName("He");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .put(path)
        .then()
                .statusCode(200)
                .body("userId", equalTo("c4f6c088-f91b-494e-b7f0-a08f48df3180"));
    }

    @Test
    public void updateAUserWithFiftyCharLastName() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180";

        UserBody userBody = new UserBody();
        userBody.setFirstName("Thierry");
        userBody.setLastName("Henryyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .put(path)
        .then()
                .statusCode(200)
                .body("userId", equalTo("c4f6c088-f91b-494e-b7f0-a08f48df3180"));
    }

    @Test
    public void doNotUpdateAUserWithFiftyOneCharLastName() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180";

        UserBody userBody = new UserBody();
        userBody.setFirstName("Thierry");
        userBody.setLastName("Henryyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .put(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }
}
