package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Requests extends Client {
    private static final String POST_REGISTER = "/register";
    private static final String DELETE_CUSTOMER = "/customers/";

    public Response registerNewUser(User user) {
        return given()
                .spec(getSpecs())
                .body(user)
                .post(POST_REGISTER);
    }

    public Response deleteUser(String id) {
        return given()
                .spec(getSpecs())
                .delete(DELETE_CUSTOMER + id);
    }

}
