package com.vidvaan.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidvaan.spring.bean.Employee;
import com.vidvaan.spring.dao.EmployeeDaoImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDaoImpl employeeDaoImpl;

	public void save(Employee employee) {
		// TODO Auto-generated method stub

	}

	public void update(Employee employee) {
		// TODO Auto-generated method stub

	}

	public void delete(int eid) {
		// TODO Auto-generated method stub

	}

	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Float> getEmpMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee findById(int eid) {
		// TODO Auto-generated method stub
		return null;
	}

	public int findTotalEmps() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int findTotalEmployeesByEsal(float sal) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmployeeExits(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public void insertRecords(List<Employee> employeeList) {
		employeeDaoImpl.insertRecords(employeeList);

	}

	public int[] batchUpdate(List<Employee> employeeList) {
		return employeeDaoImpl.batchUpdate(employeeList);
	}

}