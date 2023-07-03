package com.tcs.dnd;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.util.Arrays;
import com.tcs.resources.APIResources;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class EcomAPITest {

	public static void main(String[] args) {
		RequestSpecification rs=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		LoginRequest lr=new LoginRequest();
		lr.setUserEmail("aqieb.javed1996@gmail.com");
		lr.setUserPassword("aqieb*MD*9");
		
		RequestSpecification requestLogin=given().spec(rs).body(lr);
		LoginResponse responseObj=requestLogin.when().post(APIResources.loginAPI.GetResource()).then().extract().response().as(LoginResponse.class);
		String token= responseObj.getToken();//eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NGEyNzM5OTcyNDQ0OTBmOTU3MzJjOGYiLCJ1c2VyRW1haWwiOiJhcWllYi5qYXZlZDE5OTZAZ21haWwuY29tIiwidXNlck1vYmlsZSI6ODMzMjgxMTA5NSwidXNlclJvbGUiOiJjdXN0b21lciIsImlhdCI6MTY4ODM3NzA2MiwiZXhwIjoxNzE5OTM0NjYyfQ.tKGpFMlWRzsoTsvfN00K6-EfOQP88JTKxBA9jHO8PuU
		String userId= responseObj.getUserId();//64a273997244490f95732c8f
		
		//CreateProduct
		RequestSpecification createProdRequestSpec=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).build();
		RequestSpecification createProdRs=given().log().all()
		.spec(createProdRequestSpec)
		.param("productName", "macBook")
		.param("productAddedBy",userId )
		.param("productCategory", "fashion")
		.param("productSubCategory", "shirts")
		.param("productPrice", "11500")
		.param("productDescription", "Adidas Originals")
		.param("productFor", "women")
		.multiPart("productImage",new File("C:\\Users\\HI\\Postman\\files\\CreateProduct.png"));		
		CreateProduct createProdObj=createProdRs.when().post(APIResources.CreateProductAPI.GetResource())
		.then().log().all()
		.extract().response().as(CreateProduct.class);		
		String productId=createProdObj.getProductId();		
		Addr objInner=new Addr();
		objInner.setProductOrderedId(productId);
		objInner.setCountry("India");
		Orders orderObj=new Orders();		
		orderObj.setOrderList(Arrays.asList(objInner));
		
		
		//CreateOrder
		RequestSpecification rs1=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).setContentType(ContentType.JSON).build();
		RequestSpecification createOrderSpec=given().spec(rs1).body(orderObj);
		ResponseSpecification respSpec=new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		
		CreateOrderResp createOrderRespObj=createOrderSpec.when().post(APIResources.CreateOrderAPI.GetResource())
		.then().log().all()
		.spec(respSpec)
		.extract().response().as(CreateOrderResp.class);
		String orderId=createOrderRespObj.getOrders().get(0);
		
		
		//ViewOrderDetails
		RequestSpecification getOrderRs=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).build();
		RequestSpecification getOrderSpec=given().spec(getOrderRs).queryParam("id", orderId);		
		GetOrderResp getOrderRespObj=getOrderSpec.when().get(APIResources.getOrderAPI.GetResource())
		.then().log().all()
		.extract().response().as(GetOrderResp.class);
		System.out.println(getOrderRespObj.getMessage());
		
		
		//Delete Order
		//RequestSpecification deleteOrderRs=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).build();
		RequestSpecification deleteOrderSpec=given().spec(getOrderRs).pathParam("orderId", orderId);//Reuse		
		DeleteOrderResp deleteOrderRespObj=deleteOrderSpec.when().delete(APIResources.deleteOrderAPI.GetResource()+"/{orderId}")
		.then().log().all()
		.extract().response().as(DeleteOrderResp.class);
		System.out.println(deleteOrderRespObj.getMessage());
		
		//DeleteProduct
		RequestSpecification deleteProductSpec=given().spec(getOrderRs).pathParam("productId", productId);//Reuse		
		DeleteOrderResp deleteProductRespObj=deleteProductSpec.when().delete(APIResources.deleteProductAPI.GetResource()+"/{productId}")
		.then().log().all()
		.extract().response().as(DeleteOrderResp.class);
		System.out.println(deleteProductRespObj.getMessage());
		
		

	}

}
