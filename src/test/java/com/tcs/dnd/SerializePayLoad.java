package com.tcs.dnd;

import java.util.Arrays;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class SerializePayLoad {
public static void main(String[] args) {
	AddPlace ap=new AddPlace();
	ap.setAccuracy(50);
	ap.setAddress("221 Baker ST, London");
	ap.setLanguage("English-En");
	ap.setPhoneNumber("(+91) 833 281 1095");
	ap.setWebsite("https://rahulshetttyacademy.com");
	ap.setName("Scranton House");
	
	Location l=new Location();
	l.setLat(30.0987);
	l.setLon(-45.186345);
	ap.setLocation(l);
	List<String> types=Arrays.asList("ball park","estimation");
	ap.setTypes(types);
	
	RestAssured.baseURI="https://rahulshettyacademy.com";
	Response resp=given().queryParam("key", "qaclick123").body(ap).when().post("/maps/api/place/add/json").then()
	.assertThat().statusCode(200).extract().response();
	
	System.out.println(resp.asString());
	
}
}
