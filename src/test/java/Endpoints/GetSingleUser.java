package Endpoints;

import Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleUser extends BaseTest {

    public static Response getSingleUserApi(int singleUser) {
        return RestAssured
                .given()
                .spec(reqSpec)
                .header("x-api-key", "reqres-free-v1") /* just to run Reqres.in */
                .when()
                .get("/users/" + singleUser);

    }
}
