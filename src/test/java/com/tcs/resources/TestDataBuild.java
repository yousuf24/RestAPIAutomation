package com.tcs.resources;

import java.util.Arrays;
import java.util.List;

import com.tcs.pojo.AddPlace;
import com.tcs.pojo.Location;

public class TestDataBuild {
	public AddPlace addPlacePayLoad(String name,String language,String address) {
		AddPlace ap=new AddPlace();
		ap.setAccuracy(50);
		ap.setAddress(address);
		ap.setLanguage(language);
		ap.setPhoneNumber("(+91) 833 281 1095");
		ap.setWebsite("https://rahulshetttyacademy.com");
		ap.setName(name);
		
		Location l=new Location();
		l.setLat(30.0987);
		l.setLon(-45.186345);
		ap.setLocation(l);
		List<String> types=Arrays.asList("ball park","estimation");
		ap.setTypes(types);
		return ap;
	}
	
}
