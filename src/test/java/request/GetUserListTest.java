package request;

import io.restassured.common.mapper.TypeRef;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class GetUserListTest extends RequestBase{

    private final String path = "/users";

    @Test
    public void getUserList() {

        List<Map<String, Object>> users =
                given()
                        .spec(request)
                .when()
                        .get("/users")
                .then()
                        .statusCode(200)
                        .extract().as(new TypeRef<List<Map<String, Object>>>() {});

        assertThat(users, hasSize(2));
        assertThat(users.get(0).get("id"), equalTo("c4f6c088-f91b-494e-b7f0-a08f48df3180"));
        assertThat(users.get(0).get("username"), equalTo("doejj"));
        assertThat(users.get(0).get("firstName"), equalTo("jane"));
        assertThat(users.get(0).get("lastName"), equalTo("doe"));
        assertThat(users.get(0).get("isActive"), equalTo(true));
        assertThat(users.get(1).get("id"), equalTo("c3e140a4-99db-44c2-a9ea-896904745993"));
        assertThat(users.get(1).get("username"), equalTo("johnthesavior"));
        assertThat(users.get(1).get("firstName"), equalTo("john"));
        assertThat(users.get(1).get("lastName"), equalTo("doe"));
        assertThat(users.get(1).get("isActive"), equalTo(false));
    }
}
