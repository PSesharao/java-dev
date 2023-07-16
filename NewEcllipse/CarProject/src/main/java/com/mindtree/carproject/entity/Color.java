package com.mindtree.carproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "color_table")
public class Color {
    @Id
	@Column(name = "color_name")
	private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "color",cascade = CascadeType.MERGE)
    private List<ModelColor> modelList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ModelColor> getModelList() {
		return modelList;
	}
	public void setModelList(List<ModelColor> modelList) {
		this.modelList = modelList;
	}
}
