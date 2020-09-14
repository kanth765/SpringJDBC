package com.vidvaan.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vidvaan.spring.bean.Employee;
import com.vidvaan.spring.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	public void addEmp(Employee employee) {
		employeeServiceImpl.save(employee);
	}

	public List<Employee> getAllEmps() {
		return employeeServiceImpl.getAllEmps();
	}
	
	public Employee getById(int id) {
		return employeeServiceImpl.getById(id);
	}
	
	public int[] batchUpdate(List<Employee> employeeList) {
		return employeeServiceImpl.batchUpdate(employeeList);
	}
}