package com.tcs.dnd;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.tcs.Utility.Utility;
import com.tcs.resources.PayLoad;

public class TempWork {
	public static void main2() {
		RestAssured.baseURI="http://216.10.245.166";
		//
		String body=PayLoad.getPayLoadAddBook("Jon", "123456");
		//AddBook
		String addBookResp=given().header("Content-Type","application/json").body(body)
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(addBookResp);
//		JsonPath jp=Utility.rawToJson(addBookResp);
//		String id=jp.getString("ID");
//		System.out.println(id);
		
		//getBook
//				String getBookResp=given()//.log().all()
//						.queryParam("ID", "joseph24071996")
//						.get("/Library/GetBook.php")
//						.then()//.log().all()
//						.assertThat().statusCode(200).extract().response().asString();
//						System.out.println(getBookResp);
//						JsonPath jp3=Utility.rawToJson(getBookResp);
//						System.out.println(jp3.getString("author"));
						
		//DeleteBook
//		String bodyforDelete=PayLoad.getPayLoadDeleteBook(id);	
//		String deleteBookResp=given().header("Contenty-Type","application/json").body(bodyforDelete)
//		.delete("/Library/DeleteBook.php")
//		.then().assertThat().statusCode(200)
//		.extract().response().asString();
//		System.out.println(deleteBookResp);
//		JsonPath jp2=Utility.rawToJson(deleteBookResp);
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		//String body=PayLoad.getPayLoad();
		String body=new String (Files.readAllBytes(Paths.get("C:\\Users\\HI\\My_Items\\Job\\Softwares\\EclipseIDE\\eclipseIDE_ws\\APIFramework\\RestAPIAutomation\\src\\test\\java\\com\\tcs\\resources\\sample.json")));
				
		//given when input details are given
		//when  when the request is submitted
		//then expected outcome
		main2();
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		//Add placeAPI		
		Response resp=given()
		//.log().all()
		.queryParams("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(body)
		.when().post("/maps/api/place/add/json")
		.then()
		.assertThat()//wtever u provide post this it will be validation
		.body("scope", equalTo("APP")) //validating a key, value in response
		.header("server", "Apache/2.4.52 (Ubuntu)") //validating the headers in response
		.statusCode(200).extract().response();
		
		JsonPath jp=Utility.rawToJson(resp);
		String place_id=jp.getString("place_id");
		System.out.println(place_id);
		
		//UpdatePlace API
//		String addr="WestMinster Tesla City, Starx EthanHawk";
//		String updatedPayLoad=PayLoad.getPayLoadForPut("192d797e258309713a0cc41755199856",addr);
//		
//		String updateResp=given()
//		.queryParam("key", "qaclick123").header("Content-Type","application/json")
//		.body(updatedPayLoad)
//		.when().post("/maps/api/place/update/json")
//		.then()
//		.assertThat().statusCode(200)
//		.extract().response().asString();
//		System.out.println(updateResp);
		
		
//		//Get API
//		String getResp=given()//.log().all()
//		.queryParam("key", "qaclick123")
//		.queryParam("place_id", place_id)
//		.when().get("/maps/api/place/get/json")
//		.then()//.log().all()
//		.assertThat().statusCode(200).extract().response().asString();
//		System.out.println(getResp);
//		JsonPath jp2=Utility.rawToJson(getResp);
//		String actualAddr=jp2.get("address");
//		System.out.println(actualAddr);
		

	}

}
