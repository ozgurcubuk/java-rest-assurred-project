package request;

import org.testng.annotations.Test;
import response.UserResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetAUserTest extends RequestBase {

    @Test
    public void getAUserHappyPath() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180";

        UserResponse userResponse =
        given()
                .spec(request)
        .when()
                .get(path)
        .then()
                .statusCode(200)
                .extract().as(UserResponse.class);

        assertThat(userResponse.getId(), equalTo("c4f6c088-f91b-494e-b7f0-a08f48df3180"));
        assertThat(userResponse.getusername(), equalTo("doejj"));
        assertThat(userResponse.getFirstName(), equalTo("jane"));
        assertThat(userResponse.getLastName(), equalTo("doe"));
        assertThat(userResponse.isActive(), equalTo(true));
    }

    @Test
    public void doNotGetAUserWithNonExistedUserId() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3181";

        given()
                .spec(request)
        .when()
                .get(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 404 http status code
    }
}
