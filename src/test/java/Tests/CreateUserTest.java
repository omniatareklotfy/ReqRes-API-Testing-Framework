package Tests;

import Base.BaseTest;
import Endpoints.CreateUser;
import Payloads.UserPayload;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateUserTest extends BaseTest {

    UserPayload newUser = new UserPayload();

    /**
     * Data provider for user creation test.
     * Provides multiple sets of name and job values.
     */
    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        return new Object[][]{{"morpheus", "leader"}
        };
    }

    /**
     * Test class for verifying user creation functionality
     * using ReqRes API.
     * <p>
     * - Uses TestNG framework for testing.
     * - Allure annotations are added for better reporting.
     * - DataProvider supplies multiple sets of test data.
     */
    @Test(description = "Test Create User Status Code is 201")
    @Feature("Create User")
    @Owner("Omnia")
    @Story("Create new User REQ-36")
    public void TestcreateUserStatusCode() {
        Response response = CreateUser.createUserApi(newUser);
        Assert.assertEquals(response.getStatusCode(), 201);
    }


    @Test(description = "Test Create User Status Line")
    @Feature("Create User")
    @Owner("Omnia")
    @Story("Create new User REQ-36")
    public void TestcreateUserStatusLine() {
        Response response = CreateUser.createUserApi(newUser);
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 201 Created");
    }


    @Test(dataProvider = "userData", description = "Test Create User by name and job")
    @Feature("Create User")
    @Owner("Omnia")
    @Story("Create new User REQ-36")
    public void TestcreateUserByEmailAndPassword(String name, String job) {

        UserPayload newUser = new UserPayload(name, job);
        Response response = CreateUser.createUserApi(newUser);
        Allure.parameter("name", name);  // to appear the parameter in Allure Report
        Allure.parameter("job", job);
        System.out.println("Testing with: " + name + " | " + job);
        System.out.println("Status Code: " + response.getStatusCode());

        Assert.assertEquals(response.jsonPath().getString("name"), name);
        Assert.assertEquals(response.jsonPath().getString("job"), job);

    }


}
