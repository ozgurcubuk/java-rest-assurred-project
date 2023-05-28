package request;

import body.UserBody;
import org.testng.annotations.Test;
import response.UserResponse;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertFalse;

public class CreateUserTest extends RequestBase{

    private final String path = "/users";

    @Test
    public void createUserHappyPath() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevin");
        userBody.setLastName("De Bruyne");
        userBody.setUserName("Legend19");
        userBody.setPassword("Test@123");

        UserResponse userResponse =
        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200)
                .extract().as(UserResponse.class);

        assertFalse(userResponse.getUserId().isEmpty());
    }

    @Test
    public void doNotCreateUserWithoutFirstName() {
        UserBody userBody = new UserBody();
        userBody.setLastName("De Bruyne");
        userBody.setUserName("Legend19");
        userBody.setPassword("Test@123");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void doNotCreateUserWithoutLastName() {
        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevin");
        userBody.setUserName("Legend19");
        userBody.setPassword("Test@123");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void doNotCreateUserWithoutUserName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevin");
        userBody.setLastName("De Bruyne");
        userBody.setPassword("Test@123");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void createUserWithoutPassword() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevin");
        userBody.setLastName("De Bruyne");
        userBody.setUserName("Legend19");

        UserResponse userResponse =
        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200)
                .extract().as(UserResponse.class);

        assertFalse(userResponse.getUserId().isEmpty());
    }

    @Test
    public void doNotCreateWithAlphanumericFirstName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevin123");
        userBody.setLastName("De Bruyne");
        userBody.setUserName("Legend19");
        userBody.setPassword("Test@123");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void doNotCreateWithAlphanumericLastName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevin");
        userBody.setLastName("De Bruyne123");
        userBody.setUserName("Legend19");
        userBody.setPassword("Test@123");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void doNotCreateUserWithOneCharFirstName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("K");
        userBody.setLastName("De Bruyne");
        userBody.setUserName("Legend19");
        userBody.setPassword("Test@123");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void createUserWithTwoCharFirstName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Ke");
        userBody.setLastName("De Bruyne");
        userBody.setUserName("Legend19");
        userBody.setPassword("Test@123");

        UserResponse userResponse =
        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200)
                .extract().as(UserResponse.class);

        assertFalse(userResponse.getUserId().isEmpty());
    }

    @Test
    public void createUserWithFiftyCharFirstName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        userBody.setLastName("De Bruyne");
        userBody.setUserName("Legend19");
        userBody.setPassword("Test@123");

        UserResponse userResponse =
        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200)
                .extract().as(UserResponse.class);

        assertFalse(userResponse.getUserId().isEmpty());
    }

    @Test
    public void doNotCreateUserWithFiftyOneCharFirstName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        userBody.setLastName("De Bruyne");
        userBody.setUserName("Legend19");
        userBody.setPassword("Test@123");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void doNotCreateUserWithOneCharLastName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevin");
        userBody.setLastName("D");
        userBody.setUserName("Legend19");
        userBody.setPassword("Test@123");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void createUserWithTwoCharLastName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevin");
        userBody.setLastName("De");
        userBody.setUserName("Legend19");
        userBody.setPassword("Test@123");

        UserResponse userResponse =
        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200)
                .extract().as(UserResponse.class);

        assertFalse(userResponse.getUserId().isEmpty());
    }

    @Test
    public void createUserWithFiftyCharLastName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevin");
        userBody.setLastName("De Bruyneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        userBody.setUserName("Legend19");
        userBody.setPassword("Test@123");

        UserResponse userResponse =
        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200)
                .extract().as(UserResponse.class);

        assertFalse(userResponse.getUserId().isEmpty());
    }

    @Test
    public void doNotCreateUserWithFiftyOneCharLastName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevin");
        userBody.setLastName("De Bruyneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        userBody.setUserName("Legend19");
        userBody.setPassword("Test@123");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void doNotCreateUserWithThreeCharUserName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevin");
        userBody.setLastName("De Bruyne");
        userBody.setUserName("Leg");
        userBody.setPassword("Test@123");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }

    @Test
    public void createUserWithFourCharUserName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevin");
        userBody.setLastName("De Bruyne");
        userBody.setUserName("Lege");
        userBody.setPassword("Test@123");

        UserResponse userResponse =
        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200)
                .extract().as(UserResponse.class);

        assertFalse(userResponse.getUserId().isEmpty());
    }

    @Test
    public void createUserWithTwelveCharUserName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevin");
        userBody.setLastName("De Bruyne");
        userBody.setUserName("Legend199999");
        userBody.setPassword("Test@123");

        UserResponse userResponse =
        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200)
                .extract().as(UserResponse.class);

        assertFalse(userResponse.getUserId().isEmpty());
    }

    @Test
    public void doNotCreateUserWithThirteenCharUserName() {

        UserBody userBody = new UserBody();
        userBody.setFirstName("Kevin");
        userBody.setLastName("De Bruyne");
        userBody.setUserName("Legend1999999");
        userBody.setPassword("Test@123");

        given()
                .spec(request)
                .body(userBody)
        .when()
                .post(path)
        .then()
                .statusCode(200); //if control was applied on api, we would expect an error message along with 400 http status code
    }
}
