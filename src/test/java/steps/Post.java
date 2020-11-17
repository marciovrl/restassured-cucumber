package steps;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class Post {

    private RequestSpecification request;
    private Response response;

    @Given("use endpoint posts")
    public void use_endpoint_posts() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.basePath = "posts";
    }

    @When("ready all Post item")
    public void ready_all_Post_item() {
        request = given().contentType(ContentType.JSON);
        response = request.when().get();
    }

    @Then("I view all Post items")
    public void i_view_all_Post_items() {
        response.then().statusCode(200);
    }

    @When("add new Post item")
    public void add_new_Post_item() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("title", "Testing");
        params.put("body", "Testing API example");

        request = given().contentType(ContentType.JSON).body(params);
        response = request.when().post();
    }

    @Then("^I view the new Item$")
    public void i_view_the_new_Item() {
        response.then().statusCode(201).body("title", is("Testing"));
    }

    @When("delete new Post item")
    public void delete_new_Post_item() {
        request = given().contentType(ContentType.JSON);
        response = request.when().delete("/1");
    }

    @Then("Item was delete")
    public void item_was_delete() {
        response.then().statusCode(200);
    }
}