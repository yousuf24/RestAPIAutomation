package com.tcs.pojo;

import java.util.List;

public class CreateOrderResp{
	private List<String> orders,productOrderId;
	public List<String> getOrders() {
		return orders;
	}
	public void setOrders(List<String> orders) {
		this.orders = orders;
	}
	public List<String> getProductOrderId() {
		return productOrderId;
	}
	public void setProductOrderId(List<String> productOrderId) {
		this.productOrderId = productOrderId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
}