package com.tcs.Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;

public class Utility {
public static JsonPath rawToJson(Response response) {	
	return new JsonPath(response.asPrettyString()).using(new JsonPathConfig("UTF-8"));
}
public static JsonPath rawToJson(String resp) {
	return new JsonPath(resp);
}
public static String getJsonValuebasedOnKey(String resp,String key) {
	JsonPath jp=new JsonPath(resp);
	return jp.getString(key);
}
}
