package request;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

 class RequestBase {
     RequestSpecification request = new RequestSpecBuilder()
             .setContentType(ContentType.JSON)
             .setBaseUri("https://3e3d2990-3fca-4144-8b26-1538cf135a09.mock.pstmn.io")
             .build();
}
