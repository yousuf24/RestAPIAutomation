package stepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
@Before("@DeletePlace")
public void setUp() throws IOException {
	//once placeId is captured , don't run this method again . i.e only when placeId is null
	
	StepDefinition _sd=new StepDefinition();
	_sd.add_place_payload_is_provided("Rahul", "english", "India");
	_sd.user_calls_the_using_post_http_request("AddPlaceAPI", "POST");
	_sd.api_call_should_be_successful_and_returns_status_code(200);
	_sd.verify_place_id_created_maps_to_using("Rahul", "POST");
	}
	
}

