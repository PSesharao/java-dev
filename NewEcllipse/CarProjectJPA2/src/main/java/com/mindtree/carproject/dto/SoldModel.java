package com.mindtree.carproject.dto;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.mindtree.carproject.embed.ModelColorKey;

@Embeddable
public class SoldModel {
	@Embedded
	private ModelColorKey modelColorKey;
	
	private int frequency;
	
	private double totalPrice;
	
	public ModelColorKey getModelColorKey() {
		return modelColorKey;
	}
	public void setModelColorKey(ModelColorKey modelColorKey) {
		this.modelColorKey = modelColorKey;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
