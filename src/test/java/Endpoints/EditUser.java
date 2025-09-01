package Endpoints;

import Base.BaseTest;
import Payloads.UserPayload;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EditUser extends BaseTest {

    public static Response editUserApi(UserPayload updatedUser, int userId) {

        return RestAssured
                .given()
                .spec(reqSpec)
                .header("x-api-key", "reqres-free-v1") /* just to run Reqres.in */
                .body(updatedUser)
                .when()
                .post("/users" + userId);
    }

}
