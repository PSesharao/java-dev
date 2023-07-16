package com.org.shoppingmvc.dto;

import java.util.List;
import java.util.Set;

public class OrderDto {
	private long customer;
	
	private Set<Long> cartList;
	
	private String orderDate;

	public long getCustomer() {
		return customer;
	}
	public void setCustomer(long customer) {
		this.customer = customer;
	}
	
	public Set<Long> getCartList() {
		return cartList;
	}
	public void setCartList(Set<Long> cartList) {
		this.cartList = cartList;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
}
