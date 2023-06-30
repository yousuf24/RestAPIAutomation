package stepDefinition;

import com.tcs.resources.APIResources;
import com.tcs.resources.Utils;

public class StepDefinition extends Utils {
	public static String PlaceId;
//@When("user Calls {string} with {string} https method")
public void user_calls_httpRequest(String resource,String method) {
	APIResources _apiR=APIResources.valueOf(resource);
	_apiR.GetResource();
	
}
//@When("")
public void add_place_payload(String str1,String str2,String str3) {
	
	
}
public void verify_placeId_created_mapsto(String Expected,String method) {
	
}
}
