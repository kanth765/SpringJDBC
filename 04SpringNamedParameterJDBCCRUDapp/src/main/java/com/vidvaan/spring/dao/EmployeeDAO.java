package com.vidvaan.spring.dao;

import java.util.List;
import java.util.Map;

import com.vidvaan.spring.bean.Employee;

public interface EmployeeDAO {

	void insert(Employee employee);

	void update(Employee employee);

//	Map<String, Float> getAllEmps();

	List<Employee> findAllEmps();

	// queryforobject

}
