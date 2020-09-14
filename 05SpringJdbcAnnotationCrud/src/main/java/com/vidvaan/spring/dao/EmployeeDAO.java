package com.vidvaan.spring.dao;

import java.util.List;
import java.util.Map;

import com.vidvaan.spring.bean.Employee;

public interface EmployeeDAO {


	void save(Employee employee);

	void update(Employee employee);

	void delete(int eid);

	Employee getById(int id);

	List<Employee> getAll();

	Map<String, Float> getEmpMap();
	
	Employee findById(int eid);
	
	int findTotalEmps();
	
	int findTotalEmployeesByEsal(float sal);
	
	boolean isEmployeeExits(String name);
	
	void insertRecords(List<Employee> employeeList);
	
	int [] batchUpdate(List<Employee> employeeList);
}