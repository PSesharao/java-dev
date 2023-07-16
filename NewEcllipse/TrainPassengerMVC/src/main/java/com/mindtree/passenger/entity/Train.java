package com.mindtree.passenger.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "train_table")
@SequenceGenerator(name = "trainseq", initialValue = 1990220, allocationSize = 1)
public class Train {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainseq")
	@Column(name = "train_id")
	private long id;

	@Column(name = "train_name")
	private String name;

	@Column(name = "train_source")
	private String source;

	@Column(name = "train_destination")
	private String destination;

	@Column(name = "date_of_journey")
	private String date;
}
