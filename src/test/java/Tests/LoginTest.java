package Tests;

import Base.BaseTest;
import Endpoints.Login;
import Payloads.LoginPayload;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPayload payload = new LoginPayload("eve.holt@reqres.in", "cityslicka");

    @DataProvider(name = "loginData")  // All Test Data in Login
    public Object[][] getLoginData() {
        return new Object[][]{{"eve.holt@reqres.in", "cityslicka"},  // valid
                {"wrong.email@reqres.in", "cityslicka"}, // invalid email
                {"eve.holt@reqres.in", "wrongpass"},  // invalid password
                {"", ""}  // empty values
        };
    }

    @Test(description = "Test Login Status Code is 200")
    @Feature("Login")
    @Owner("Omnia")
    @Story("Login By email and Password REQ-33")
    public void TestLoginStatusCode() {
        Response response = Login.loginByUser(payload);
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(description = "Test Login Status Line")
    @Feature("Login")
    @Owner("Omnia")
    @Story("Login By email and Password REQ-33")
    public void TestLoginStatusLine() {
        Response response = Login.loginByUser(payload);
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");

    }

    @Test(description = "TesT Token is exist after Login")
    @Feature("Login")
    @Owner("Omnia")
    @Story("Login By email and Password REQ-33")
    public void TestLoginToken() {
        Response response = Login.loginByUser(payload);
        Assert.assertNotNull(response.jsonPath().getString("token"));
        System.out.println("Token is : " + response.jsonPath().getString("token"));

    }

    @Test(dataProvider = "loginData", description = "Login API Test with multiple data sets")
    public void TestLoginByMultiData(String email, String password) {

        LoginPayload payload = new LoginPayload(email, password);
        Response response = Login.loginByUser(payload);
        Allure.parameter("Email", email);  // to appear the parameter in Allure Report
        Allure.parameter("Password", password);
        System.out.println("Testing with: " + email + " | " + password);
        System.out.println("Status Code: " + response.getStatusCode());

        // Assertions according to reqres.in acceptance criteria in Login
        if (email.equals("eve.holt@reqres.in")) {
            // 200
            Assert.assertEquals(response.getStatusCode(), 200, "Valid email should return 200");
            Assert.assertNotNull(response.jsonPath().getString("token"), "Token should not be null");
        } else {
            // 400
            Assert.assertEquals(response.getStatusCode(), 400, "Invalid email should return 400");
            Assert.assertNotNull(response.jsonPath().getString("error"), "Error message should exist");
        }
    }
}
