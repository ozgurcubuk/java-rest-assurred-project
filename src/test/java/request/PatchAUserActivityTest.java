package request;

import body.UserBody;
import org.testng.annotations.Test;
import response.UserResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PatchAUserActivityTest extends RequestBase {

    @Test
    public void patchAUserActivityAsTrue() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180/activity";

        UserBody userBody = new UserBody();
        userBody.setIsctive(true);

        UserResponse userResponse =
        given()
                .spec(request)
                .body(userBody)
        .when()
                .patch(path)
        .then()
                .statusCode(200)
                .extract().as(UserResponse.class);

        assertThat(userResponse.getUserId(), equalTo("c4f6c088-f91b-494e-b7f0-a08f48df3180"));
        assertThat(userResponse.isActive(), equalTo(true));
    }

    @Test
    public void patchAUserActivityAsFalse() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180/activity";

        UserBody userBody = new UserBody();
        userBody.setIsctive(false);

        UserResponse userResponse =
        given()
                .spec(request)
                .body(userBody)
        .when()
                .patch(path)
        .then()
                .statusCode(200)
                .extract().as(UserResponse.class);

        assertThat(userResponse.getUserId(), equalTo("c4f6c088-f91b-494e-b7f0-a08f48df3180"));
        assertThat(userResponse.isActive(), equalTo(true)); //if api could set the given isActive property value properly, we would expect as false
    }

    @Test
    public void doNotPatchAUserActivityWithoutIsActiveProperty() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180/activity";

        UserBody userBody = new UserBody();

        given()
                .spec(request)
                .body(userBody)
        .when()
                .patch(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 status code
    }

    @Test
    public void doNotPatchAUserActivityWithImproperTypeOfIsActivePropertyValue() {

        final String path = "/users/c4f6c088-f91b-494e-b7f0-a08f48df3180/activity";

        given()
                .spec(request)
                .body("{\"isActive\":\"invalidTypeForIsActiveProperty\"}")
        .when()
                .patch(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 status code
    }
}
