package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class LoginAPITest {

	@Test(description = "Check if login API works!")
	public void loginTest() {
//		Response response = given().baseUri("http://64.227.160.186:8080").header("Content-Type", "application/json")
//				.body("{\r\n" + "  \"username\": \"uday1234\",\r\n" + "  \"password\": \"uday1234\"\r\n" + "}")
//				.post("/api/auth/login");

		LoginRequest loginRequest = new LoginRequest("uday1234", "uday1234");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		System.out.println(response.asPrettyString());

		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println("Id = " + loginResponse.getId());
		
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getId(), 3);
	}

}
