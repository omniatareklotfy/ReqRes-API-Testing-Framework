package Tests;

import Base.BaseTest;
import Endpoints.GetSingleUser;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static TestData.SingleUserData.*;

public class GetSingleUserTest extends BaseTest {

    @Test(description = "Test Get Single User Status Code is 200")
    @Feature("Single User")
    @Owner("Omnia")
    @Story("Get Single User REQ-35")
    public void TestGetSingleUserStatusCode() {
        Response response = GetSingleUser.getSingleUserApi(2);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Test Get Single User Status Line")
    @Feature("Single User")
    @Owner("Omnia")
    @Story("Get Single User REQ-35")
    public void TestGetSingleUserStatusLine() {
        Response response = GetSingleUser.getSingleUserApi(2);
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test(description = "Test Get Single User Id = 2")
    @Feature("Single User")
    @Owner("Omnia")
    @Story("Get Single User REQ-35")
    public void TestSingleUserIdReturnAsRequested() {
        Response response = GetSingleUser.getSingleUserApi(2);
        Assert.assertEquals(response.jsonPath().getInt("data.id"), USER_ID);
    }

    @Test(description = "Test Email for Get Single User")
    @Feature("Single User")
    @Owner("Omnia")
    @Story("Get Single User REQ-35")
    public void TestSingleUserEmail() {
        Response response = GetSingleUser.getSingleUserApi(2);
        Assert.assertEquals(response.jsonPath().getString("data.email"), USER_EMAIL);

    }

    @Test(description = "Test First Name for Get Single User")
    @Feature("Single User")
    @Owner("Omnia")
    @Story("Get Single User REQ-35")
    public void TestSingleUserFirstName() {
        Response response = GetSingleUser.getSingleUserApi(2);
        Assert.assertEquals(response.jsonPath().getString("data.first_name"), USER_FIRSTNAME);
    }

    @Test(description = "Test Last Name for Get Single User")
    @Feature("Single User")
    @Owner("Omnia")
    @Story("Get Single User REQ-35")
    public void TestSingleUserLastName() {
        Response response = GetSingleUser.getSingleUserApi(2);
        Assert.assertEquals(response.jsonPath().getString("data.last_name"), USER_LASTNAME);

    }

    @Test(description = "Test Avatar for Get Single User")
    @Feature("Single User")
    @Owner("Omnia")
    @Story("Get Single User REQ-35")
    public void TestSingleUserAvatar() {
        Response response = GetSingleUser.getSingleUserApi(2);
        Assert.assertEquals(response.jsonPath().getString("data.avatar"), USER_AVATAR);

    }

    @Test(description = "Test If Get Single User Not Found")
    @Feature("Single User")
    @Owner("Omnia")
    @Story("Get Single User REQ-35")
    public void TestSingleUserNotFound() {

        Response response = GetSingleUser.getSingleUserApi(25);
        Assert.assertEquals(response.getStatusCode(), 404, "Status code should be 404 for not found user");

    }


}

