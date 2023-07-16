package com.mindtree.carproject.embed;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ModelColorKey implements Serializable{
	
	@Column(name = "color_name")
	private String color;

	@Column(name = "model_name")
	private String model;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "[color=" + color + ", model=" + model + "]";
	}
}
