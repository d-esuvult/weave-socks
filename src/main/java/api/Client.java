package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static additional.URLs.BASE_URL;

public class Client {
    protected RequestSpecification getSpecs() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://localhost:80")
                .build();
    }
}
