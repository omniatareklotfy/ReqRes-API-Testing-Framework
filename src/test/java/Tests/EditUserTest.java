package Tests;

import Base.BaseTest;
import Endpoints.EditUser;
import Payloads.UserPayload;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditUserTest extends BaseTest {
    int userId = 2;
    UserPayload updatedUser = new UserPayload();

    @DataProvider(name = "userUpdatedData")
    public Object[][] getUserUpdatedData() {
        return new Object[][]{{"morpheus", "zion resident"}
        };
    }

    @Test(description = "Test Update User Status Code")
    @Feature("Update User")
    @Owner("Omnia")
    @Story("Update User REQ-37")
    public void TestUpdatedUserStatusCode() {
        Response response = EditUser.editUserApi(updatedUser, userId);
        Assert.assertEquals(response.getStatusCode(), 201);
    }


    @Test(description = "Test Update User Status Line")
    @Feature("Update User")
    @Owner("Omnia")
    @Story("Update User REQ-37")
    public void TestUpdatedUserStatusLine() {
        Response response = EditUser.editUserApi(updatedUser, userId);
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 201 Created");
    }


    @Test(dataProvider = "userUpdatedData", description = "Test Update User by Name")
    @Feature("Update User")
    @Owner("Omnia")
    @Story("Update User REQ-37")
    public void TestUpdatedUserByName(String name, String job) {
        updatedUser.setName(name);
        Allure.parameter("name", name);  // to appear the parameter in Allure Report
        System.out.println("Testing with: " + name + " | " + name);

        Response response = EditUser.editUserApi(updatedUser, userId);
        Assert.assertEquals(response.jsonPath().getString("name"), name);
    }

    @Test(dataProvider = "userUpdatedData", description = "Test Update User by job")
    @Feature("Update User")
    @Owner("Omnia")
    @Story("Update User REQ-37")
    public void TestUpdatedUserByJob(String name, String job) {
        updatedUser.setJob(job);
        Allure.parameter("job", job);  // to appear the parameter in Allure Report
        System.out.println("Testing with: " + job + " | " + job);

        Response response = EditUser.editUserApi(updatedUser, userId);
        Assert.assertEquals(response.jsonPath().getString("job"), job);
    }

}
