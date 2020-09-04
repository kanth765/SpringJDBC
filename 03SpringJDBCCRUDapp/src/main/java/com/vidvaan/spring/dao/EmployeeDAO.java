package com.vidvaan.spring.dao;

import java.util.List;

import com.vidvaan.spring.bean.Employee;

public interface EmployeeDAO {
	
	void insert(Employee employee);
	
	List<Employee> getAllEmps();
	
	//queryforobject

}
