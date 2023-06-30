package com.tcs.APIFramework_T;

import org.junit.Test;

import com.tcs.resources.XcelIntegration;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AppTest 
{    
	@Test
    public void test() throws IOException {
    	RestAssured.baseURI="http://216.10.245.166";
    	
    	XcelIntegration obj=new XcelIntegration();
    	ArrayList<String> li=obj.getData("RestAddBook");
    	
    	
        Map<String,Object> hm=new HashMap<>();
        Map<String,Object> hm2=new HashMap<>();
        hm2.put("lat", "12");
        hm2.put("lng", "34");
        
        hm.put("name",li.get(1));
        hm.put("isbn",li.get(2));
        hm.put("aisle",li.get(3));
        hm.put("author",li.get(4));
        hm.put("location",hm2);
//        
        
//        String body="""
//				{
//
//    "name":"Learn Appium Automation with Java",
//    "isbn":"joseph",
//    "aisle":"2407",
//    "author":"Yousuf mohammad"
//        		}
//				
//				""";
        
        Response resp=given()
        		.header("Content-Type","application/json")
        		.body("")//U can alternatively provide text block string
        		.when()
        		.post("/Library/Addbook.php")
        		.then().assertThat().statusCode(200).extract().response();
        
        JsonPath jp=new JsonPath(resp.toString());
        System.out.println(jp.getString("ID"));
    }
}

