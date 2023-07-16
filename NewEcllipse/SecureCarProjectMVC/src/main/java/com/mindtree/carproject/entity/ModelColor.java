package com.mindtree.carproject.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.carproject.embed.ModelColorKey;

@Entity
@Table(name = "model_color_price_table")
public class ModelColor {
	@EmbeddedId
	private ModelColorKey key;
	@JsonIgnore
	@ManyToOne
	@MapsId("color")
	@JoinColumn(name = "color_name")
	private Color color;
	@JsonIgnore
	@ManyToOne
	@MapsId("model")
	@JoinColumn(name = "model_name")
	private Model model;
	
	

	@Column(name = "price")
	private double price;

	public ModelColorKey getKey() {
		return key;
	}

	public void setKey(ModelColorKey key) {
		this.key = key;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ModelColor [key=" + key + ", color=" + color + ", model=" + model + ", price=" + price + "]";
	}
	
}
