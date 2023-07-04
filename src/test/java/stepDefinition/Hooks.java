package stepDefinition;

import io.cucumber.java.Before;

public class Hooks {
@Before("@tag")
public void setUp() {
	//once placeId is captured , dont run this method again
	StepDefinition _sd=new StepDefinition();
	
	}
	
}

