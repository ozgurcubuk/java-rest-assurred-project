package request;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import response.ProductResponse;

import java.io.InputStream;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetProductListTest extends RequestBase {

    private final String path = "/products";

    @Test
    public void getProductsList() {

        InputStream getProductListJsonSchema = getClass().getClassLoader()
                .getResourceAsStream("getProductList.json");

        List<ProductResponse> productListResponse =
                given()
                        .spec(request)
                .when()
                        .get("/products")
                .then()
                        .statusCode(200)
                        .and()
                        .assertThat()
                        .body(JsonSchemaValidator.matchesJsonSchema(getProductListJsonSchema))
                        .extract()
                        .body()
                        .jsonPath()
                        .getList(".", ProductResponse.class);

        assertThat(productListResponse.get(0).getId(), equalTo(1));
        assertThat(productListResponse.get(1).getId(), equalTo(2));
    }

    @Test
    public void cannotGetProductListWithoutAuthorizationHeader() {
                given()
                        .spec(requestWithoutAuthorizationHeader)
                .when()
                        .get("/products")
                .then()
                        .statusCode(401);
    }

    @Test
    public void cannotGetProductListWithoutValidAuthorizationHeader() {
        given()
                .spec(requestWithoutValidAuthorizationHeader)
                .when()
                .get("/products")
                .then()
                .statusCode(401);
    }

    @Test
    public void cannotGetProductListForUserThatIntegrationSiteIsTemporaryUnavailable() {
        given()
                .spec(requestForUserThatIntegrationSiteIsTemporaryUnavailable)
                .when()
                .get("/products")
                .then()
                .statusCode(503);
    }

    @Test
    public void getProductsListWithOneExtraPropertyKey() {
            List<ProductResponse> productListResponse =
                    given()
                            .spec(request)
                    .when()
                            .get("/productsWithOneExtraProperty")
                    .then()
                            .statusCode(200)
                            .extract()
                            .body()
                            .jsonPath()
                            .getList(".", ProductResponse.class);

            /*Throws UnrecognizedPropertyException and fails test since the
            ProductResponse object doesn't contain "thatOneExtraProperty"*/

    }
}
