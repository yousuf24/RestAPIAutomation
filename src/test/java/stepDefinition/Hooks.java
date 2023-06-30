package stepDefinition;

import org.junit.Before;

public class Hooks {
//@Before("@tag")
public void setUp() {
	//once placeId is captured , dont run this method again
	StepDefinition _sd=new StepDefinition();
	if(StepDefinition.PlaceId==null) {
	_sd.add_place_payload("rahul Shetty", "Indian", "Asia");
	_sd.user_calls_httpRequest("addPlaceAPI", "POST");
	_sd.verify_placeId_created_mapsto("rahul Shetty", "getPlaceAPI");
	}
	
}
}
