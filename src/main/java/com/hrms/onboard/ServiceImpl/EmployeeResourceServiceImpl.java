package com.hrms.onboard.ServiceImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.onboard.Repository.DesignationRepository;
import com.hrms.onboard.Repository.EmployeeRepository;
import com.hrms.onboard.Repository.EmployeeResourceRepository;
import com.hrms.onboard.Repository.SystemTypeRepository;
import com.hrms.onboard.entity.Designation;
import com.hrms.onboard.entity.Employee;
import com.hrms.onboard.entity.EmployeeResources;
import com.hrms.onboard.entity.SystemType;
import com.hrms.onboard.exception.EmployeeResourceException;
import com.hrms.onboard.service.EmployeeResourceService;
import com.hrms.onboard.utils.EmployeeResourcesUtils;

@Service
public class EmployeeResourceServiceImpl implements EmployeeResourceService {

	@Autowired
	private EmployeeResourceRepository Repo;

	@Autowired
	private DesignationRepository designationRepo;

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private SystemTypeRepository systemTypeRepository;

	Logger logger = LoggerFactory.getLogger(EmployeeResourceServiceImpl.class);

	@Override
	public List<EmployeeResources> getAllResources() {
		logger.debug(EmployeeResourcesUtils.METHOD_START);
		List<EmployeeResources> getAll = null;
		try {
			logger.info(EmployeeResourcesUtils.FETCHING_ALL);
			getAll = Repo.findAll();
		} catch (Exception e) {
			logger.error(EmployeeResourcesUtils.NOT_FOUND);
			throw new EmployeeResourceException(e.getMessage());
		}
		return getAll;
	}

	@Override
	public EmployeeResources addEmpResources(EmployeeResources addemployee) {
		logger.debug(EmployeeResourcesUtils.METHOD_START);
		EmployeeResources addJob = null;
		try {
			logger.info(EmployeeResourcesUtils.ADD_HISTORY);
			addJob = Repo.save(addemployee);
		} catch (Exception e) {
			logger.error(EmployeeResourcesUtils.NOT_FOUND);
			throw new EmployeeResourceException(e.getMessage());
		}
		return addJob;
	}

	@Override
	public EmployeeResources editEmpResources(EmployeeResources empresource) {
		logger.debug(EmployeeResourcesUtils.METHOD_START);
		try {
			Optional<EmployeeResources> id = Repo.findById(empresource.getId());
			if (id.isPresent()) {
				logger.info(EmployeeResourcesUtils.EDIT_JOB);
				EmployeeResources resource = id.get();
				resource.setEmpName(empresource.getEmpName());
				resource.setKeyBoard(empresource.getKeyBoard());
				resource.setMouse(empresource.getMouse());
				resource.setDesignationId(empresource.getDesignationId());
				resource.setSysId(empresource.getSysId());
				resource.setLanCable(empresource.getLanCable());
				Repo.save(resource);
				return resource;
			}

		} catch (Exception e) {
			throw new EmployeeResourceException(EmployeeResourcesUtils.INCORRECT_ID + e.getMessage());
		}
		return null;
	}

	@Override
	public boolean deleteEmpResources(int Id) {
		logger.debug(EmployeeResourcesUtils.METHOD_START);
		try {
			Optional<EmployeeResources> findById = Repo.findById(Id);
			if (findById.isPresent()) {
				logger.info(EmployeeResourcesUtils.DELETE_BYID);
				Repo.deleteById(Id);
				return true;
			}
		} catch (Exception e) {
			throw new EmployeeResourceException(EmployeeResourcesUtils.INCORRECT_ID + e.getMessage());
		}
		return false;
	}

	@Override
	public EmployeeResources getById(int getId) {
		logger.debug(EmployeeResourcesUtils.METHOD_START);
		try {
			Optional<EmployeeResources> findById = Repo.findById(getId);
			if (findById.isPresent()) {
				logger.info(EmployeeResourcesUtils.GET_BYID);
				EmployeeResources itAdmin = findById.get();
				return itAdmin;
			}
		} catch (Exception e) {
			throw new EmployeeResourceException(EmployeeResourcesUtils.INCORRECT_ID + e.getMessage());
		}
		return null;
	}

	@Override
	public Map<Integer,String> getAllDesignation() {

		logger.info(EmployeeResourcesUtils.GET_BYID);
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		try {
			List<Designation> list = designationRepo.findAll();
			list.forEach(designation -> {
				map.put(designation.getDesignationId(), designation.getDesignationType());
			});
		} catch (Exception e) {
			e.getMessage();
		}

		return map;
	}

	@Override
	public Map<String,Integer> getAllEmployees() {

		logger.info(EmployeeResourcesUtils.GET_BYID);
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		try {
			List<Employee> list = empRepo.findAll();
			list.forEach(employee -> {
				map.put(employee.getEmpName(), employee.getEmpId());
			});
		} catch (Exception e) {
			e.getMessage();
		}

		return map;
	}

	public Map<Integer,String> getAllSystemType() {
		logger.info(EmployeeResourcesUtils.GET_BYID);
		Map<Integer,String> map = new LinkedHashMap<Integer,String>();
		try {
			List<SystemType> list = systemTypeRepository.findAll();
			list.forEach(systemType -> {
				map.put(systemType.getSysId(), systemType.getSystemType());
			});
		} catch (Exception e) {
			e.getMessage();
		}

		return map;
	}
}
