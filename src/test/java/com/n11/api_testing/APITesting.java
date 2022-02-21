package com.n11.api_testing;

import com.google.gson.Gson;
import com.n11.api_testing.pojo_classes.POJO;
import com.n11.utility.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class APITesting {


	@Before
	public void before(){
		RestAssured.baseURI = PropertyReader.getProperty("base_URI");
		RestAssured.basePath = "/pet";
	}

	private static long id;
	private static POJO pojoResponse1;
	private static POJO pojoResponse2;
	private static Gson gson;

	/*
	BaseURI: https://petstore.swagger.io/v2

	Task-1:
	● Set the Content-type=application/json
	● Set path “pet”
	● Create one pet with the following JSON model

	{
		"category": {
			"id": 0,
			"name": "Pets"
		},
		"name": "Scout",
		"photoUrls": [
			"scout.png"
		],
		"tags": [
			{
				"id": 0,
				"name": "pet-dog"
			}
		],
		"status": "available"
	}

	● Verify the below requested in the response
		- Status code should be 200
		- Response should has an id
		- Created name should be equal to the posted name
		- Content-type should be application/json
		- Response header should has a date value
	*/

	@Test
	public void task1(){

		String requestBody = "{\n" +
				"\"category\": {\n" +
				"\"id\": 0,\n" +
				"\"name\": \"Rocky\"\n" +
				"},\n" +
				"\"name\": \"Rocky\",\n" +
				"\"photoUrls\": [\n" +
				"\"rocky.png\"\n" +
				"],\n" +
				"\"tags\": [\n" +
				"{\n" +
				"\"id\": 0,\n" +
				"\"name\": \"tiger\"\n" +
				"}\n" +
				"],\n" +
				"\"status\": \"available\"\n" +
				"}";


		//De-serialization for POST request body to POJO
		gson = new Gson();
		POJO requestPojo = gson.fromJson(requestBody, POJO.class);

		//save the name in post request body as expectedName
		String expectedName = requestPojo.getName();

		//get the response,accept and content type are application/json
		Response response = RestAssured.given().accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.and().body(requestPojo)
							.when().post();

		//De-serialization for response body to POJO
		pojoResponse1 = gson.fromJson(response.body().asString(), POJO.class);

		//extract id value for further tests
		id = pojoResponse1.getId();

		//verify status code
		Assert.assertEquals(response.statusCode(),200);

		//verify response has an "id" field
		Assert.assertNotNull(pojoResponse1.getId());

		//verify the field "name" in response body is the same as request body
		Assert.assertEquals(expectedName, pojoResponse1.getName());

		//verify content-type is application/json
		Assert.assertEquals("application/json",response.contentType());

		//verify response header has a "date" value
		Assert.assertTrue(response.headers().hasHeaderWithName("date"));


	}


	/**************************************************************
		Task-2
		● Set the Content-type=application/json
		● Set path “pet”
		● Set id as a path parameters (You can use the id from the response of the Task-1)
		● Retrieve the pet information that you requested
		● Verify the response
			- Status code should be 200
			- Response body should be equal to the Task-1’s response body
			- Content-type should be application/json
			- Response header should has a date value
	 */

	@Test
	public void task2(){
		//get the response
		Response response = RestAssured.given().accept(ContentType.JSON)
							.and().contentType(ContentType.JSON)
							.and().pathParam("id", id)
							.when().get("/{id}");

		//De-serialization for response body to POJO
		pojoResponse2 = gson.fromJson(response.body().asString(),POJO.class);

		//verify if status code is 200
		Assert.assertEquals(200,response.statusCode());

		//verify if response body is equal to the Task-1’s response body
		System.out.println(pojoResponse1.toString());
		System.out.println(pojoResponse2.toString());
		Assert.assertEquals(pojoResponse1.toString(), pojoResponse2.toString());

		//verify content-type is application/json
		Assert.assertEquals("application/json",response.contentType());

		//verify response header has a "date" value
		Assert.assertTrue(response.headers().hasHeaderWithName("date"));

	}




	/**************************************************************
	 Task-3
	 ● Set the Content-type=application/json
	 ● Set path “pet”
	 ● Set id as a path parameters (You can use the id from the response of the Task-2)
	 ● Delete the pet that you searched
	 ● Verify the response
		 - Status code should be 200
		 - Content-type should be application/json
		 - Response body message should equal to id
		 - Message should be equal to “unknown”
	 */

	@Test
	public void task3(){
		//get the response
		RestAssured.given().accept(ContentType.JSON)
				.and().contentType(ContentType.JSON)
				.and().pathParam("id", id)
				.when().delete("/{id}")
				.then()
				.assertThat().statusCode(200)
				.assertThat().contentType("application/json")
				.assertThat().body("message", Matchers.equalTo(String.valueOf(id)),
						"type", Matchers.equalTo("unknown"));
	}


	@Test
	public void task4(){
		//get the response
		Response response = RestAssured.given().accept(ContentType.JSON)
				.and().contentType(ContentType.JSON)
				.and().pathParam("id", id)
				.when().delete("/{id}");

		//De-serialization for response body to Map
//		Map<String,Object> responseMap = response.body().as(Map.class);
		Map<String,Object> responseMap = gson.fromJson(response.body().asString(),Map.class);

		//verify content-type is application/json
		Assert.assertEquals("application/json",response.contentType());

		//verify if response body message is equal to id value
		Assert.assertEquals(String.valueOf(id),responseMap.get("message"));

		//verify if type is equal to “unknown”
		Assert.assertEquals("unknown",responseMap.get("type"));

	}



}
