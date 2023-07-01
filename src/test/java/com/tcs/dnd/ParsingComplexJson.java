package com.tcs.dnd;

import java.text.MessageFormat;

import com.tcs.Utility.Utility;
import com.tcs.resources.PayLoad;

import io.restassured.path.json.JsonPath;

public class ParsingComplexJson {

	public static void main(String[] args) {
		JsonPath js=new JsonPath(PayLoad.getPayLoadComplex());
		System.out.println(js.getInt("courses.size()")+ ":"+ js.getInt("dashboard.size()"));
		System.out.println(js.getInt("dashboard.purchaseAmount"));
		System.out.println(js.getString("dashboard.IsPremiumAvailable"));
		
		//Print all courses title
		int noOfCourses=js.getInt("courses.size()");
		for(int i=0;i<noOfCourses;i++) {
			String t=js.getString(MessageFormat.format("courses[{0}].title", i));
			System.out.print(t+"\t");
		}

	}

}
