package com.hrms.onboard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee_resourcesss")
@Data
public class EmployeeResources {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Boolean mouse;
	private Boolean keyBoard;
	private Boolean lanCable;
	private Integer designationId; 
	private String empName;
	private Integer sysId;
	public EmployeeResources(Integer id, Boolean mouse, Boolean keyBoard, Boolean lanCable, Integer designationId,
			String empName, Integer sysId) {
		super();
		this.id = id;
		this.mouse = mouse;
		this.keyBoard = keyBoard;
		this.lanCable = lanCable;
		this.designationId = designationId;
		this.empName = empName;
		this.sysId = sysId;
	}
	public EmployeeResources() {
		 
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getMouse() {
		return mouse;
	}
	public void setMouse(Boolean mouse) {
		this.mouse = mouse;
	}
	public Boolean getKeyBoard() {
		return keyBoard;
	}
	public void setKeyBoard(Boolean keyBoard) {
		this.keyBoard = keyBoard;
	}
	public Boolean getLanCable() {
		return lanCable;
	}
	public void setLanCable(Boolean lanCable) {
		this.lanCable = lanCable;
	}
	public Integer getDesignationId() {
		return designationId;
	}
	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getSysId() {
		return sysId;
	}
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
	
	
}
