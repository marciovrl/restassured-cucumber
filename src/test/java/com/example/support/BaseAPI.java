package com.example.support;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

/**
 * Initial test setup and Constants with values ​​for RestAssured configuration
 */
public class BaseAPI {

    static String BASE_URI = "https://jsonplaceholder.typicode.com";
    static String BASE_PATH = "";
    static Long MAX_TIMEOUT = 90000L;

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH;

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(ContentType.JSON);
        RestAssured.requestSpecification = reqBuilder.build();

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        RestAssured.responseSpecification = resBuilder.build();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}