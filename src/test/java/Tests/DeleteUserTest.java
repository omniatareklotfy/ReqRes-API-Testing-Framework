package Tests;

import Base.BaseTest;
import Endpoints.DeleteUser;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTest extends BaseTest {
    int userId = 2;

    @Test(description = "Test Delete User Status Code is 204")
    @Feature("Delete User")
    @Owner("Omnia")
    @Story("Delete User REQ-37")
    public void TestDeleteUserStatusCode() {
        Response response = DeleteUser.deleteUserApi(userId);
        Assert.assertEquals(response.getStatusCode(), 204);
    }


    @Test(description = "Test Delete User Status Line")
    @Feature("Delete User")
    @Owner("Omnia")
    @Story("Delete User REQ-37")
    public void TestDeleteUserStatusLine() {
        Response response = DeleteUser.deleteUserApi(userId);
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 204 No Content");
    }

}
