package com.mindtree.shopping.dto;

import java.util.List;

import com.mindtree.shopping.embed.ProductInfo;

public class OrderDto {
	private long customer_Id;
	List<ProductInfo> productList;
	public long getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(long customer_Id) {
		this.customer_Id = customer_Id;
	}
	public List<ProductInfo> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductInfo> productList) {
		this.productList = productList;
	}
}
