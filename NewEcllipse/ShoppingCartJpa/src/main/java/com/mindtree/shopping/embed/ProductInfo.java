package com.mindtree.shopping.embed;

import javax.persistence.Embeddable;

@Embeddable

public class ProductInfo {
	// @Embedded

	private long productId;
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
}
