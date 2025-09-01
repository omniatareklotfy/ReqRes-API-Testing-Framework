package Tests;

import Base.BaseTest;
import Endpoints.Register;
import Payloads.RegisterPayload;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    RegisterPayload newUser = new RegisterPayload();

    @DataProvider(name = "registerData")  // All Test Data in Register
    public Object[][] getRegisterData() {
        return new Object[][]{{"eve.holt@reqres.in", "pistol"},  // valid
                {"wrong.email@reqres.in", "pistol"}, // invalid email
                {"eve.holt@reqres.in", "wrongpass"},  // invalid password
                {"", ""}  // empty values
        };
    }

    @Test(description = "Test Register Status Code is 200")
    @Feature("Register")
    @Owner("Omnia")
    @Story("Register By email and Password REQ-32")
    public void TestRegisterStatusCode() {
        Response response = Register.registerApi(newUser);
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(description = "Test Register Status Line")
    @Feature("Register")
    @Owner("Omnia")
    @Story("Register By email and Password REQ-32")
    public void TestRegisterStatusLine() {
        Response response = Register.registerApi(newUser);
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");

    }

    @Test(description = "Test Register Login Token")
    @Feature("Register")
    @Owner("Omnia")
    @Story("Register By email and Password REQ-32")
    public void TestRegisterToken() {
        Response response = Register.registerApi(newUser);
        Assert.assertNotNull(response.jsonPath().getString("token"));
        System.out.println("Token is : " + response.jsonPath().getString("token"));

    }

    @Test(dataProvider = "registerData", description = "Register API Test with multiple data sets")
    public void TestRegisterByMultiData(String registerEmail, String registerPassword) {

        RegisterPayload newUser = new RegisterPayload(registerEmail, registerPassword);
        Response response = Register.registerApi(newUser);

        Allure.parameter("Email", registerEmail);
        Allure.parameter("Password", registerPassword);
        System.out.println("Testing with: " + registerEmail + " | " + registerPassword);
        System.out.println("Status Code: " + response.getStatusCode());

        // will be failed according to missing API key in "reqres.in"
        if (registerEmail.equals("eve.holt@reqres.in") && registerPassword.equals("pistol")) {
            // 200
            Assert.assertEquals(response.getStatusCode(), 200, "Valid email and Password should return 200");
            Assert.assertNotNull(response.jsonPath().getString("token"), "Token should not be null");
        } else {
            // 400
            Assert.assertEquals(response.getStatusCode(), 400, "Invalid email and Invalid Password should return 400");
            Assert.assertNotNull(response.jsonPath().getString("error"), "Error message should exist");
        }
    }
}
