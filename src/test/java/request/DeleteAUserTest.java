package request;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteAUserTest extends RequestBase {


    @Test
    public void deleteAUserHappyPath() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180";

        given()
                .spec(request)
        .when()
                .delete(path)
        .then()
                .statusCode(200);
    }

    @Test
    public void doNotDeleteAUserWitNonExistedUserId() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3181";

        given()
                .spec(request)
        .when()
                .delete(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 404 http status code
    }
}
