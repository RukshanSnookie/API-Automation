package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {

	@Test(description = "Check if login API works!")
	public void loginTest() {
		RestAssured.baseURI = "http://64.227.160.186:8080";

		Response response = RestAssured.given().header("Content-Type", "application/json")
				.body("{\r\n" + "  \"username\": \"uday1234\",\r\n" + "  \"password\": \"uday1234\"\r\n" + "}")
				.post("/api/auth/login");
		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
