package com.cts.springboot.web.springbootfirstwebapplication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "training")
public class Training {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	
	private String training;

	public Training() {
	}

	public Training(String training) {

		this.training = training;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTraining() {
		return training;
	}

	public void setTraining(String training) {
		this.training = training;
	}
	

}
