package Endpoints;

import Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUsers extends BaseTest {

    public static Response getUsersApi() {
        return RestAssured
                .given()
                .spec(reqSpec)
                .queryParam("page", "2")
                .header("x-api-key", "reqres-free-v1") /* just to run Reqres.in */
                .when()
                .get("/users");

    }
}
