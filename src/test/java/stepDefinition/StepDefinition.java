package stepDefinition;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.tcs.Utility.Utility;
import com.tcs.resources.APIResources;
import com.tcs.resources.TestDataBuild;
import com.tcs.resources.Utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinition extends Utils {
	RequestSpecification rs,addPlaceRs;
	ResponseSpecification respS;
	Response resp;
	TestDataBuild data=new TestDataBuild();
	@Given("addPlace payload provided with {string},{string} and {string} ")
	public void add_place_payload_is_provided(String name,String language,String address) throws IOException {		
		
		rs =requestSpec();						
		addPlaceRs=given()
				.spec(rs)
				.body(data.addPlacePayLoad(name,language,address));
	}

	@When("User calls the {string} using {string} http request")
	public void user_calls_the_using_post_http_request(String string,String httpReq) {
		respS=responseSpec(200);
		APIResources apiR=APIResources.valueOf(string);
		
		if(httpReq.equalsIgnoreCase("post")) {
			resp=addPlaceRs.when().post(apiR.GetResource());
		}else if(httpReq.equalsIgnoreCase("get")) {
			resp=addPlaceRs.when().get(apiR.GetResource());
		}
		resp= resp
				.then()
				.spec(respS)
				.extract().response();
	}

	@Then("API call should be successful and returns {int} status code")
	public void api_call_should_be_successful_and_returns_status_code(Integer int1) {
	   assertEquals(resp.getStatusCode(),int1.intValue());
	}

	@Then("{string} body in the response payload is {string}")
	public void body_in_the_response_payload_is(String string, String string2) {
//		AddPlaceResp addPlaceResp=resp.as(AddPlaceResp.class);
//		addPlaceResp.getStatus().equalsIgnoreCase(string2);
		String respStr=resp.asString();		
		assertEquals(Utility.getJsonValuebasedOnKey(respStr,string),string2);
	   
	}
	
	@Then("Verify placeId created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String name, String apiResource) throws IOException {
		String placeId=Utility.getJsonValuebasedOnKey(resp.asString(),"place_id");
		
		String apiRes=APIResources.valueOf(apiResource).GetResource();
	    
		rs=given().spec(requestSpec()).queryParam("place_id", placeId);
	    
//	    if(apiResource.contains("get")) {
//	    	resp=rs.when().get(apiRes);
//	    }else if(apiResource.contains("post")) {
//	    	resp=rs.when().post(apiRes);
//	    }else if(apiResource.contains("delete")) {
//	    	resp=rs.when().delete(apiRes);
//		resp=resp
//			    .then()
//			    .spec(respS)
//			    .extract().response();
//	    }
		//Reuse the method which is in place instead of writing code
		user_calls_the_using_post_http_request(apiResource,"get");
		String nameFromJson=Utility.getJsonValuebasedOnKey(resp.asString(), "name");
		assertEquals(nameFromJson,name);
	    
	    
	}
	

}
