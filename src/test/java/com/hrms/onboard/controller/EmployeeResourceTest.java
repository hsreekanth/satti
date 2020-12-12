package com.hrms.onboard.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrms.onboard.entity.EmployeeResources;
import com.hrms.onboard.service.EmployeeResourceService;

@WebMvcTest(EmployeeResourceController.class)
public class EmployeeResourceTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	EmployeeResourceService ServiceMock;

	@Test
	public void getByIdTest() throws Exception {
		EmployeeResources resource1 = new EmployeeResources(1, true, false, true, 1, "satish", 1);
		Mockito.when(ServiceMock.getById(1)).thenReturn(resource1);

		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/getoneresource/1");
		MvcResult result = mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
 
	}

	@Test
	public void getAllTest() throws Exception {
		List<EmployeeResources> resource = new ArrayList<>();
		EmployeeResources resource1 = new EmployeeResources(1, true, false, true, 1, "satish", 1);
		EmployeeResources resource2 = new EmployeeResources(1, true, false, true, 1, "satish", 1);
		resource.add(resource1);
		resource.add(resource2);
		Mockito.when(ServiceMock.getAllResources()).thenReturn(resource);
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/getallresources");
		MvcResult result = mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}

	@Test
	public void deleteAcademicsByIdTest() throws Exception {

		when(ServiceMock.deleteEmpResources(1)).thenReturn(true);

		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.delete("/deleteresource/1");
		MvcResult result = mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		System.err.println(response.getContentAsString());
		int status = response.getStatus();
		assertEquals(200, status);

	}

	@Test
	public void addJobHistoryTest() throws Exception {
		EmployeeResources resource1 = new EmployeeResources(1, true, false, true, 1, "satish", 1);
		when(ServiceMock.addEmpResources(Mockito.any(EmployeeResources.class))).thenReturn(resource1);

		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString = mapper.writeValueAsString(resource1);
		MockHttpServletRequestBuilder postReq = MockMvcRequestBuilders.post("/saveresource")
				.accept(MediaType.APPLICATION_JSON).content(writeValueAsString).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(postReq).andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);

	}

	@Test
	public void editJobHistoryTest() throws Exception {
		EmployeeResources resource1 = new EmployeeResources(1, true, false, true, 1, "satish", 1);
		when(ServiceMock.editEmpResources(Mockito.any(EmployeeResources.class))).thenReturn(resource1);
		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString = mapper.writeValueAsString(resource1);
		MockHttpServletRequestBuilder postReq = MockMvcRequestBuilders.put("/editresource")
				.accept(MediaType.APPLICATION_JSON).content(writeValueAsString).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(postReq).andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	} 
 
}
