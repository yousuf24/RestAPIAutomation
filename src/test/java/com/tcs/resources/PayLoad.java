package com.tcs.resources;

import java.text.MessageFormat;

public class PayLoad {
public static String getPayLoadDeleteBook(String id) { 
	return System.out.format("{\r\n"
			+ "    \"ID\": \"%1$s\"\r\n"
			+ "}", id).toString();
}
public static String getPayLoadAddBook(String isbn,String aisle) {
	return System.out.format("{\r\n"
			+ "\r\n"
			+ "    \"name\":\"Learn Appium Automation with Java\",\r\n"
			+ "    \"isbn\":\"%1$s\",\r\n"
			+ "    \"aisle\":\"%2$s\",\r\n"
			+ "    \"author\":\"Yousuf mohammad\"\r\n"
			+ "}",isbn,aisle).toString();
}
public static String getPayLoad() {
	return """
			{
"location": {
    "lat": -38.383494,
    "lng": 33.427362
},
"accuracy": 50,
"name": "Rahul Shetty Academy",
"phone_number": "(+91) 983 893 3937",
"address": "29, side layout, cohen 09",
"types": [
    "shoe park",
    "shop"
],
"website": "http://rahulshettyacademy.com",
"language": "English-EN"
}
			""";
}
public static String getPayLoadForPut(String place_id,String addr) {
	String toReturn= System.out.format("{\r\n"
			+ "    \"place_id\":\"%1$s\",    \r\n"
			+ "    \"address\": \"%2$s\",\r\n"
			+ "    \"key\":\"qaclick123\"\r\n"
			+ "    \r\n"
			+ "}",place_id,addr).toString();
	return toReturn;

}
public static String getPayLoadComplex() {
	return """
			{
    "dashboard":{
        "purchaseAmount":100,
        "website":"rahulshettyacademy.com",
        "IsPremiumAvailable":true
    },
    "courses":[{
        "title":"selenium python",
        "price":40,
        "copy":5
    },{
        "title":"selenium Java",
        "price":40,
        "copy":10
    },{
        "title":"selenium JavaScript",
        "price":40,
        "copy":7
    }]
}
			""";
}
}
