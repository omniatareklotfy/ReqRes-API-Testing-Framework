package Tests;

import Base.BaseTest;
import Endpoints.ListResources;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static TestData.ListResourcesData.*;


public class ListResourcesTest extends BaseTest {

    @Test(description = "Test List Resources Status Code is 200")
    @Feature("Resources")
    @Owner("Omnia")
    @Story("Get Resources REQ-38")
    public void TestListResourcesStatusCode() {
        Response response = ListResources.listResourcesApi();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Test List Resources Status Line")
    @Feature("Resources")
    @Owner("Omnia")
    @Story("List Resources REQ-38")
    public void TestListResourcesStatusLine() {
        Response response = ListResources.listResourcesApi();
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test(description = "Test List Resources page Number")
    @Feature("Resources")
    @Owner("Omnia")
    @Story("List Resources REQ-38")
    public void TestListResourcesPageNumber() {
        Response response = ListResources.listResourcesApi();
        Assert.assertEquals(response.jsonPath().getInt("page"), 1);
    }

    @Test(description = "Test List Resources Total Pages")
    @Feature("Resources")
    @Owner("Omnia")
    @Story("List Resources REQ-38")
    public void TestListResourcesTotalPages() {
        Response response = ListResources.listResourcesApi();
        Assert.assertEquals(response.jsonPath().getInt("total"), 12);
    }

    @Test(description = "Test List Resources First Resource Data")
    @Feature("Resources")
    @Owner("Omnia")
    @Story("List Resources REQ-38")
    public void TestListResourcesFirstResourceData() {
        Response response = ListResources.listResourcesApi();
        Assert.assertEquals(response.jsonPath().getInt("data[0].id"), COLOR1_ID);
        Assert.assertEquals(response.jsonPath().get("data[0].name"), COLOR1_NAME);
        Assert.assertEquals(response.jsonPath().getInt("data[0].year"), COLOR1_YEAR);
        Assert.assertEquals(response.jsonPath().getString("data[0].color"), COLOR1_NAME);
        Assert.assertEquals(response.jsonPath().get("data[0].pantone_value"), COLOR1_PANTONE);

    }

    @Test(description = "Test List Resources Second Resource Data")
    @Feature("Resources")
    @Owner("Omnia")
    @Story("List Resources REQ-38")
    public void TestListResourcesSecondResourceData() {
        Response response = ListResources.listResourcesApi();
        Assert.assertEquals(response.jsonPath().getInt("data[0].id"), COLOR2_ID);
        Assert.assertEquals(response.jsonPath().getString("data[0].name"), COLOR2_NAME);
        Assert.assertEquals(response.jsonPath().getInt("data[0].year"), COLOR2_YEAR);
        Assert.assertEquals(response.jsonPath().getString("data[0].color"), COLOR2_NAME);
        Assert.assertEquals(response.jsonPath().getString("data[0].pantone_value"), COLOR2_PANTONE);

    }
}
