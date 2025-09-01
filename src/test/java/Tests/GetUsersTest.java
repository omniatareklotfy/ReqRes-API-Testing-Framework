package Tests;

import Base.BaseTest;
import Endpoints.GetUsers;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;

import static TestData.UsersTestData.*;

import org.testng.annotations.Test;

public class GetUsersTest extends BaseTest {

    @Test(description = "Test Get Users Status Code is 200")
    @Feature("Users")
    @Owner("Omnia")
    @Story("Get Users REQ-34")
    public void TestGetUsersStatusCode() {
        Response response = GetUsers.getUsersApi();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Test Get Users Status Line")
    @Feature("Users")
    @Owner("Omnia")
    @Story("Get Users REQ-34")
    public void TestGetUsersStatusLine() {
        Response response = GetUsers.getUsersApi();
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test(description = "Test Get Users Page Returned should be 2")
    @Feature("Users")
    @Owner("Omnia")
    @Story("Get Users REQ-34")
    public void TestUserPageReturnAsRequested() {
        Response response = GetUsers.getUsersApi();
        Assert.assertEquals(response.jsonPath().getInt("page"), 2);
    }

    @Test(description = "Test Get Users Data of First User ")
    @Feature("Users")
    @Owner("Omnia")
    @Story("Get Users REQ-34")
    public void TestDataOfFirstUser() {
        Response response = GetUsers.getUsersApi();
        Assert.assertEquals(response.jsonPath().getInt("data[0].id"), FIRST_USER_ID);
        Assert.assertEquals(response.jsonPath().getString("data[0].email"), FIRST_USER_EMAIL);
        Assert.assertEquals(response.jsonPath().getString("data[0].first_name"), FIRST_USER_FIRSTNAME);
        Assert.assertEquals(response.jsonPath().getString("data[0].last_name"), FIRST_USER_LASTNAME);
        Assert.assertEquals(response.jsonPath().getString("data[0].avatar"), FIRST_USER_AVATAR);

    }


    @Test(description = "Test Get Users Data of Second User ")
    @Feature("Users")
    @Owner("Omnia")
    @Story("Get Users REQ-34")
    public void TestDataOfSecondUser() {
        Response response = GetUsers.getUsersApi();
        Assert.assertEquals(response.jsonPath().getInt("data[1].id"), SECOND_USER_ID);
        Assert.assertEquals(response.jsonPath().getString("data[1].email"), SECOND_USER_EMAIL);
        Assert.assertEquals(response.jsonPath().getString("data[1].first_name"), SECOND_USER_FIRSTNAME);
        Assert.assertEquals(response.jsonPath().getString("data[1].last_name"), SECOND_USER_LASTNAME);
        Assert.assertEquals(response.jsonPath().getString("data[1].avatar"), SECOND_USER_AVATAR);

    }
}


