package com.tcs.dnd;

import java.util.Arrays;
import java.util.List;

import com.tcs.resources.APIResources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class Spec {

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
		
		RequestSpecification rs =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		ResponseSpecification respS=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		Response resp=
				given().spec(rs).body(ap)
		.when().post(APIResources.AddPlaceAPI.GetResource())
		.then()
		.spec(respS)
		.extract().response();
		
		System.out.println(resp.asPrettyString());
		
		
		

	}

}
