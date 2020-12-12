package com.hrms.onboard.service;

import java.util.List;
import java.util.Map;

import com.hrms.onboard.entity.EmployeeResources;

public interface EmployeeResourceService {

	public List<EmployeeResources> getAllResources();

	public EmployeeResources addEmpResources(EmployeeResources itAdmin);

	public EmployeeResources editEmpResources(EmployeeResources itAdmin);

	public boolean deleteEmpResources(int itAdminId);

	public EmployeeResources getById(int itAdminId);
	
	public Map<Integer,String> getAllDesignation();
	
	public Map<String,Integer> getAllEmployees();
	
	public Map<Integer,String> getAllSystemType();
}
