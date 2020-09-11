package com.vidvaan.spring.service;

import java.util.List;

import com.vidvaan.spring.bean.Employee;

public interface EmployeeService {

	void save(Employee employee);
	List<Employee> getAllEmps();
}