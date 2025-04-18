package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static constants.PageUrls.BASE_URL;

public class BaseClient {
    public static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL + "/api")
                .setContentType(ContentType.JSON)
                .build();
    }
}
