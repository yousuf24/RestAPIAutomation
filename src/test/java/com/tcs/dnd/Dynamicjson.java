package com.tcs.dnd;

import org.testng.annotations.Test;

import com.tcs.resources.PayLoad;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;

public class Dynamicjson {
  @Test(dataProvider = "dp")
  public void f(String n, String s) {
	  //Addbook api
	  RestAssured.baseURI="https://rahulshettyacademy.com";//"http://216.10.245.166";
		
		String body=PayLoad.getPayLoadAddBook(n, s);
		
		Response addBookResp=given()//.log().all()
				.header("Content-Type","Application/json").body(body)
		.when().post("/Library/Addbook.php")//.asString()
		.then().log().all()
		.assertThat().statusCode(200).extract().response();
		
		System.out.println(addBookResp.body().asString());
//		JsonPath jp=Utility.rawToJson(addBookResp);
//		String id=jp.getString("ID");
//		System.out.println(id);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "monica", "1" },
      new Object[] { "phoebe", "2" },
      new Object[] { "rachel", "3" }
    };
  }
}
