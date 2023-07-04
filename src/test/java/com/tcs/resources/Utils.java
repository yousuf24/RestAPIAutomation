package com.tcs.resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	public static RequestSpecification rs ;
public RequestSpecification requestSpec() throws IOException {
	
	
	//RestAssured.baseURI="https://rahulshettyacademy.com";	
	if (rs == null) {
		PrintStream log = new PrintStream(new FileOutputStream("output.txt"));
		rs = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
	}
	return rs;
}
public ResponseSpecification responseSpec(int statusCode) {
	return new ResponseSpecBuilder().expectStatusCode(statusCode).expectContentType(ContentType.JSON).build();
}
public String getGlobalValue(String key) throws IOException {
	Properties prop=new Properties();
	FileInputStream fi=new FileInputStream("C:\\Users\\HI\\My_Items\\Job\\Softwares\\EclipseIDE\\eclipseIDE_ws\\APIFramework\\RestAPIAutomation\\src\\test\\java\\com\\tcs\\resources\\global.properties");
	prop.load(fi);
	String value=prop.getProperty(key);
	return value;
}
}
