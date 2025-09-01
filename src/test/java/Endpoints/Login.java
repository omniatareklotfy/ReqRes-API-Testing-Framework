package Endpoints;

import Base.BaseTest;
import Payloads.LoginPayload;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Login extends BaseTest {

    public static Response loginByUser(LoginPayload payload) {

        return RestAssured
                .given()
                .spec(reqSpec)
                .body(payload)
                .header("x-api-key", "reqres-free-v1") /* just to run Reqres.in */
                .when()
                .post("/login");
    }
}
