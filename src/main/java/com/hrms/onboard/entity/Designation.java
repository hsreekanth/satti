package com.hrms.onboard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="designation")
@Data
public class Designation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer designationId;
	private String designationType;
	public Integer getDesignationId() {
		return designationId;
	}
	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}
	public String getDesignationType() {
		return designationType;
	}
	public void setDesignationType(String designationType) {
		this.designationType = designationType;
	}
 
	
}
