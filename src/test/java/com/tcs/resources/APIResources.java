package com.tcs.resources;

public enum APIResources {
AddPlaceAPI("maps/api/place/add/json"),GetPlaceAPI("maps/api/place/get/json"),UpdatePlaceAPI("maps/api/place/update/json"),
RemovePlaceAPI("maps/api/place/Remove/json"),loginAPI("/api/ecom/auth/login"),CreateProductAPI("/api/ecom/product/add-product"),
CreateOrderAPI(""),getOrderAPI(""),deleteOrderAPI(""),deleteProductAPI("");
	
private String resource;
APIResources(String str) {
	this.resource=str;
}
public String GetResource() {
	return resource;
}
	
}
