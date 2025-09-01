package Base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.ConfigManager;
import org.testng.annotations.BeforeClass;

/**
 * Base test class for setting up common RestAssured configurations.
 * <p>
 * - Reads base URI and base path from ConfigManager (config file).
 * - Builds a reusable RequestSpecification for all API tests.
 * - Ensures all requests have consistent configuration (Content-Type, base URI, etc.).
 */

public class BaseTest {
    protected static RequestSpecification reqSpec;

    /**
     * Setup method executed before any test class.
     * Initializes RestAssured configurations and default request specification.
     */
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigManager.get("base.url");
        RestAssured.basePath = ConfigManager.get("path.url");
        // Build a reusable request specification

        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

    }
}
