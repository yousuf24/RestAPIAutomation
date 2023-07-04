package com.tcs.pojo;

import java.util.List;


public class Orders{
	private List<Addr> orders;

	public List<Addr> getOrders() {
		return orders;
	}

	public void setOrderList(List<Addr> orderList) {
		this.orders = orderList;
	}
}