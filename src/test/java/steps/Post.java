package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Post {

    private RequestSpecification request;
    private Response response;

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Given("use endpoint posts")
    public void use_endpoint_posts() {
        request = given().contentType(ContentType.JSON);
    }

    @When("ready all Post item")
    public void ready_all_Post_item() {
        response = request.when().get("/posts");
    }

    @Then("I view all Post items")
    public void i_view_all_Post_items() {
        response.then().statusCode(200);
    }
}