package com.hrms.onboard.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.onboard.entity.EmployeeResources;
import com.hrms.onboard.exception.EmployeeResourceException;
import com.hrms.onboard.service.EmployeeResourceService;
import com.hrms.onboard.utils.EmployeeResourcesUtils;

@RestController
/* @Controller */
public class EmployeeResourceController {
	Logger logger = LoggerFactory.getLogger(EmployeeResourceController.class);

	@Autowired
	private EmployeeResourceService service;
	

	@PostMapping("/saveresource")
	public ResponseEntity<EmployeeResources> createJobHistory(@ModelAttribute EmployeeResources itAdmin) {
		return ResponseEntity.ok().body(service.addEmpResources(itAdmin));
	}

	@PutMapping("/editresource")
	public EmployeeResources editJobHistory(@RequestBody EmployeeResources itAdmin) {
		return service.editEmpResources(itAdmin);
	}

	@GetMapping("/getallresources")
	public List<EmployeeResources> getAllJobs() {
		return service.getAllResources();

	}

	@DeleteMapping("/deleteresource/{id}")
	public String deleteJobHistory(@PathVariable("id") int id) {
		boolean status = service.deleteEmpResources(id);
		if (status == true) {
			return EmployeeResourcesUtils.SUCCESSFULLY_DELETED;
		} else {
			throw new EmployeeResourceException("id not found. " + id);
		}
	}

	@GetMapping("/getoneresource/{id}")
	public EmployeeResources getById(@PathVariable("id") int id) {
		return service.getById(id);
	}

	@GetMapping("/getalldesignation")
	public Map<Integer,String> getAllDesignation() {
		Map<Integer, String> designation = service.getAllDesignation();
		return designation;
	}
	@GetMapping("/getallemployees")
	public Map<String,Integer> getAllEmployees() {
		Map<String,Integer> employee = service.getAllEmployees();
		return employee;
	}
	
	@GetMapping("/getallsystemtype")
	public Map<Integer,String> getAllSystemType() {
		Map<Integer, String> employee = service.getAllSystemType();
		return employee;
	}

	/* for checking purpose */ 
/*	@GetMapping("/reg")
	public String loadForm(Model model) {


		try {
			EmployeeResources registration = new EmployeeResources();
			Map<Integer, String> allCountries = service.getAllDesignation();
			Map<String,Integer> allEmployees = service.getAllEmployees();
			Map<Integer,String> allSystemType = service.getAllSystemType();
			model.addAttribute("designation", allCountries);
			model.addAttribute("empresource", registration);
			model.addAttribute("allEmployees", allEmployees);
			model.addAttribute("allSystemType", allSystemType);
		} catch (Exception e) {
			logger.error("***execption occured while loading registration form:" + e.getMessage());
		}
		return "empresource";
	} 
	*/
	
 

}
