package request;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

 class RequestBase {
     RequestSpecification request = new RequestSpecBuilder()
             .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJFUzI1NiJ9.eyJzdWIiOiJodHRwczovL3d3dy5uZXRzcGFya2VyY2xvdWQuY29tLyIsImF1ZCI6ImRpc2NvLXN2YyIsInN5c3RlbV90eXBlIjoiaWUtdXMiLCJpc3MiOiJJbnZpY3RpIFNlY3VyaXR5IEx0ZCIsIm5iZiI6MTY5MzI5MzY1NCwiZXhwIjoxNzg3OTg4MDU0LCJpYXQiOjE2OTMyOTM2NTV9.q10H2AUwj4AqirX_4QnoS5f6fo4HzYcN8fE6fw5Ihxpvji9s8YUEF3ScXm-jI5SmK3BWjutZEvXfuqGoCmn7YA")
             .setBaseUri("http://localhost:8080")
             .build();

     RequestSpecification requestWithoutAuthorizationHeader = new RequestSpecBuilder()
             .setBaseUri("http://localhost:8080")
             .build();

     RequestSpecification requestWithoutValidAuthorizationHeader = new RequestSpecBuilder()
             .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJFUzI1NiJ9.eyJzdWIiOiJodHRwczovL3d3dy5uZXRzcGFya2VyY2xvdWQuY29tLyIsImF1ZCI6ImRpc2NvLXN2YyIsInN5c3RlbV90eXBlIjoiaWUtdXMiLCJpc3MiOiJJbnZpY3RpIFNlY3VyaXR5IEx0ZCIsIm5iZiI6MTY5MzI5MzY1NCwiZXhwIjoxNzg3OTg4MDU0LCJpYXQiOjE2OTMyOTM2NTV9.q10H2AUwj4AqirX_4QnoS5f6fo4HzYcN8fE6fw5Ihxpvji9s8YUEF3ScXm-jI5SmK3BWjutZEvXfuqGoCmn7YC")
             .setBaseUri("http://localhost:8080")
             .build();

     RequestSpecification requestForUserThatIntegrationSiteIsTemporaryUnavailable = new RequestSpecBuilder()
             .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJFUzI1NiJ9.eyJzdWIiOiJodHRwczovL3d3dy5uZXRzcGFya2VyY2xvdWQuY29tLyIsImF1ZCI6ImRpc2NvLXN2YyIsInN5c3RlbV90eXBlIjoiaWUtdXMiLCJpc3MiOiJJbnZpY3RpIFNlY3VyaXR5IEx0ZCIsIm5iZiI6MTY5MzI5MzY1NCwiZXhwIjoxNzg3OTg4MDU0LCJpYXQiOjE2OTMyOTM2NTV9.q10H2AUwj4AqirX_4QnoS5f6fo4HzYcN8fE6fw5Ihxpvji9s8YUEF3ScXm-jI5SmK3BWjutZEvXfuqGoCmn7YB")
             .setBaseUri("http://localhost:8080")
             .build();
}
