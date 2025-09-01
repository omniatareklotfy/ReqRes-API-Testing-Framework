package Endpoints;

import Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ListResources extends BaseTest {

    public static Response listResourcesApi(){

        return RestAssured
                .given()
                .spec(reqSpec)
                .header("x-api-key", "reqres-free-v1") /* just to run Reqres.in */
                .when()
                .get("/unknown");

    }
}
