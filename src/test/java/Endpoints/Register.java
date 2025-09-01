package Endpoints;

import Base.BaseTest;
import Payloads.RegisterPayload;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Register extends BaseTest {

    public static Response registerApi(RegisterPayload newUser) {

        return RestAssured
                .given()
                .spec(reqSpec)
                .body(newUser)
                .header("x-api-key", "reqres-free-v1") /* just to run Reqres.in */
                .when()
                .post("/register");


    }

}
