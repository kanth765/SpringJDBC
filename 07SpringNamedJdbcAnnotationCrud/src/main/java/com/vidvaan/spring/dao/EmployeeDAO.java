package com.vidvaan.spring.dao;

import java.util.List;

import com.vidvaan.spring.bean.Employee;

public interface EmployeeDAO {

	void save(Employee employee);

	List<Employee> getAllEmps();
}