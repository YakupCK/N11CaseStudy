package com.n11.stepDefs;

import com.google.gson.Gson;
import com.n11.utility.PropertyReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Map;

public class APIStepDef {

	private static Response response;
	private static RequestSpecification request;
	private static String expectedName;
	private static Map responseMapTaskOne;
	private static Map responseMapTaskTwo;
	private static Map responseMapTaskThree;
	private static String expectedMessage;
	private static long id;

	@Given("I connected to Base URI")
	public void i_connected_to_Base_URI() {
		RestAssured.baseURI = PropertyReader.getProperty("base_URI");
	}

	@Given("Endpoint is {string}")
	public void endpoint_is(String endpoint) {
		RestAssured.basePath = "/" + endpoint;
	}

	@Given("Content-type is {string}")
	public void content_type_is(String contentType) {
		request = RestAssured.given();
		request.header("Content-Type", contentType);
	}

	@Given("Accept is {string}")
	public void accept_is(String string) {
		request.header("Accept", "application/json");
	}

	@When("I send a POST request with the following JSON model")
	public void i_send_a_POST_request_with_the_following_JSON_model(String jsonRequest) {
		Gson gson = new Gson();
		Map map = gson.fromJson(jsonRequest, Map.class);
		expectedName = (String) map.get("name");
		response = request.body(map).post();
		id = response.path("id");

	}

	@Then("the status code must be {int}")
	public void the_status_code_must_be(int statusCode) {
		Assert.assertEquals(statusCode, response.statusCode());
	}

	@Then("Response body must have an id")
	public void response_body_must_have_an_id() {
		JsonPath jsonPath = response.jsonPath();
		Assert.assertNotNull(jsonPath.getString("id"));
		System.out.println(jsonPath.getString("id"));
	}

	@Then("Created name should be equal to the posted name")
	public void created_name_should_be_equal_to_the_posted_name() {

		String actualName1 = response.path("name");

		JsonPath jsonPath = response.jsonPath();
		String actualName2 = jsonPath.getString("name");

		responseMapTaskOne = response.body().as(Map.class);
		String actualName3 = (String) responseMapTaskOne.get("name");

		Assert.assertEquals(expectedName, actualName1);
		Assert.assertEquals(expectedName, actualName2);
		Assert.assertEquals(expectedName, actualName3);
	}

	@Then("Content-type should be {string}")
	public void content_type_should_be(String expectedContentType) {
		Assert.assertEquals(expectedContentType, response.contentType());
	}

	@Then("Response header should has a date value")
	public void response_header_should_has_a_value() {
		Assert.assertTrue(response.headers().hasHeaderWithName("Date"));
	}


	@When("I send a GET request with pet id")
	public void i_send_a_GET_request_with_pet_id() {
		response = request.pathParam("id", id)
				.get("/{id}");
		response.prettyPrint();
	}

	@Then("Response body must be the same as Task-1")
	public void response_body_must_be_the_same_as_Task_1() {
		responseMapTaskTwo = response.body().as(Map.class);

		System.out.println(responseMapTaskOne);
		System.out.println(responseMapTaskTwo);

		Assert.assertEquals(responseMapTaskOne, responseMapTaskTwo);
	}

	@When("I send a DELETE request with pet id")
	public void i_send_a_DELETE_request_with_pet_id() {
		expectedMessage = String.valueOf(id);

		response = request.pathParam("id", id)
				.delete("/{id}");
	}

	@Then("Message in the response body must be the same as id")
	public void message_in_the_response_body_must_be_the_same_as_id() {
//		responseMapTaskThree = response.body().as(Map.class);
//		String actualMessage = (String) responseMapTaskThree.get("message");
		String actualMessage = response.path("message");
		Assert.assertEquals(expectedMessage,actualMessage);
	}

	@Then("Type in the response body must be {string}")
	public void type_in_the_response_body_must_be(String expectedType) {
//		Assert.assertEquals(expectedType,responseMapTaskThree.get("type"));
		Assert.assertEquals(expectedType,response.path("type"));
	}



}
