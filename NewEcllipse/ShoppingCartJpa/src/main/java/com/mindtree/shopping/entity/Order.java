package com.mindtree.shopping.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mindtree.shopping.embed.ProductInfo;

@Entity
@SequenceGenerator(name = "orderseq", initialValue = 10000, allocationSize = 100)
@Table(name = "order_table")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderseq")
	private long id;
	@ManyToOne
	private Customer customer;
	// @Embedded

	private double ordercost;
	
	@ElementCollection // (fetch = FetchType.LAZY)

	@CollectionTable(name = "transaction_table") // , foreignKey =
	List<ProductInfo> productList;																									// @ForeignKey(name
																										// = "order_id")
	
	// private
	/* , joinColumns = @JoinColumn(name = "transaction_id") */
	

	/*
	 * @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) private
	 * List<Product> productList;
	 * 
	 * @ElementCollection private List<Integer> quantity;
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<ProductInfo> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductInfo> productList) {
		this.productList = productList;
	}

	public double getOrdercost() {
		return ordercost;
	}

	public void setOrdercost(double ordercost) {
		this.ordercost = ordercost;
	}

	
}
