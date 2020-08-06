package com.ig.test;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import iginterview.genericlib.BaseLib;
import iginterview.genericlib.IEndPoints;
import iginterview.genericlib.JsonUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiTest extends BaseLib {
	
	@Test
	public void validateStatusCode() {
		
		given().contentType(ContentType.JSON)
		.when().get(IEndPoints.API_TEST)
		.then().statusCode(200);	
	}
	
	@Test
	public void validateResponseHeader() {
		given().contentType(ContentType.JSON)
		.when().get(IEndPoints.API_TEST)
		.then().header("Content-Type", "application/json; charset=UTF-8");	
	}
	
	@Test
	public void validateResponseBody() {
		Response response = given().contentType(ContentType.JSON)
		.when().get(IEndPoints.API_TEST);
		Assert.assertEquals(200,Integer.parseInt(JsonUtil.getJsonString(response, "status")));
		Assert.assertEquals(25, Integer.parseInt(JsonUtil.getJsonString(response, "employeeData[0].age")));
		Assert.assertEquals("QA Automation Developer", JsonUtil.getJsonString(response, "employeeData[0].role"));
		Assert.assertEquals("25-02-1994",JsonUtil.getJsonString(response, "employeeData[0].dob"));
		Assert.assertEquals("data retrieved successful",JsonUtil.getJsonString(response, "message"));
		

	}

	@Test
	public void validareResponseBodyWithInvalidData() {
		Response response = given().contentType(ContentType.JSON)
				.when().get(IEndPoints.API_TEST);
				Assert.assertEquals(JsonUtil.getJsonString(response, "employeeData[0].company"),"ABC Infotech");
		
	}
}
