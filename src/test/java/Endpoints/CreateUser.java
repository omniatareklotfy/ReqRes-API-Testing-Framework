package Endpoints;

import Base.BaseTest;
import Payloads.UserPayload;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateUser extends BaseTest {

    public static Response createUserApi(UserPayload user) {

        return RestAssured
                .given()
                .spec(reqSpec)
                .header("x-api-key", "reqres-free-v1") /* just to run Reqres.in */
                .body(user)
                .when()
                .post("/users");
    }
}
