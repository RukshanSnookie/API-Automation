package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class LoginAPITest {

	@Test(description = "Check if login API works!")
	public void loginTest() {
//		Response response = given().baseUri("http://64.227.160.186:8080").header("Content-Type", "application/json")
//				.body("{\r\n" + "  \"username\": \"uday1234\",\r\n" + "  \"password\": \"uday1234\"\r\n" + "}")
//				.post("/api/auth/login");
		
		
		AuthService authService = new AuthService();
		Response response = authService
				.login("{\r\n" + "  \"username\": \"uday1234\",\r\n" + "  \"password\": \"uday1234\"\r\n" + "}");

		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
