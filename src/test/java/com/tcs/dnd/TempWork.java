package com.tcs.dnd;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.tcs.resources.PayLoad;

public class TempWork {

	public static void main(String[] args) {
		String body=PayLoad.getPayLoad();
		//given when input details are given
		//when  when the request is submitted
		//then expected outcome
		
		//Add placeAPI
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String resp=given()
		//.log().all()
		.queryParams("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(body)
		.when().post("/maps/api/place/add/json")
		.then()
		.assertThat()//wtever u provide post this it will be validation
		.body("scope", equalTo("APP")) //validating a key, value in response
		.header("server", "Apache/2.4.52 (Ubuntu)") //validating the headers in response
		.statusCode(200).extract().response().asString();
		//System.out.println(resp);
		JsonPath jp=new JsonPath( resp);
		String place_id=jp.getString("place_id");
		System.out.println(place_id);
		
		//UpdatePlace API
		String addr="WestMinster Tesla City, Starx EthanHawks";
		String updateResp=given().log().all()
		.queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(PayLoad.getPayLoadForPut(place_id,addr))
		.when().put("/maps/api/place/update/json")
		.then().log().all()
		.assertThat().statusCode(200)
		.extract().response().asString();
		System.out.println(updateResp);
		
//		//Get API
//		String getResp=given().log().all()
//		.queryParam("key", "qaclick123")
//		.queryParam("place_id", place_id)
//		.when().get("/maps/api/place/get/json")
//		.then().log().all()
//		.assertThat().statusCode(200).extract().response().asString();
//		JsonPath jp2=new JsonPath(getResp);
//		String actualAddr=jp2.get("address");
//		System.out.println(actualAddr);
		

	}

}
