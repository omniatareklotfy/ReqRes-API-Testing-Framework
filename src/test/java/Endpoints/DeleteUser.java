package Endpoints;

import Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteUser extends BaseTest {

    public static Response deleteUserApi(int userId) {

        return RestAssured
                .given()
                .spec(reqSpec)
                .header("x-api-key", "reqres-free-v1") /* just to run Reqres.in */
                .when()
                .delete("/users/" + userId);
    }
}
