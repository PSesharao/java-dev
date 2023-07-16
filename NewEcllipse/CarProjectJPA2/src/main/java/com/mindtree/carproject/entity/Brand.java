package com.mindtree.carproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.carproject.dto.SoldModel;

@Entity
@Table(name = "brand_table")
@SequenceGenerator(name = "brandseq", initialValue = 20210000, allocationSize = 1)
public class Brand {

	/*
	 * @GeneratedValue(generator = "UUID")
	 * 
	 * @GenericGenerator( name = "UUID", strategy = "org.hibernate.id.UUIDGenerator"
	 * )
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brandseq")
	@Column(name = "brand_reg_number")
	private Long id;

	@Column(name = "brand_name")
	private String name;
	// private double budget ;
	// private double revenue;
	/*
	 * @Column(name = "soldtotal") private double soldTotal;
	 */

	@JsonIgnore
	@OneToMany(mappedBy = "brand", cascade = CascadeType.MERGE)
	private List<Model> modelList;
	@ElementCollection//(fetch = FetchType.EAGER)
	@CollectionTable(name = "brand_solditems_table", joinColumns = @JoinColumn(name = "brand_reg_number"))
	//@Column(name = "role")
	private List<SoldModel> soldModels;

	private double totalRevenue;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Model> getModelList() {
		return modelList;
	}

	public void setModelList(List<Model> modelList) {
		this.modelList = modelList;
	}

	public List<SoldModel> getSoldModels() {
		return soldModels;
	}

	public void setSoldModels(List<SoldModel> soldModels) {
		this.soldModels = soldModels;
	}

	public double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
}
