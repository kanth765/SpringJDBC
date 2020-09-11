package com.vidvaan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidvaan.spring.bean.Employee;
import com.vidvaan.spring.dao.EmployeeDaoImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDaoImpl employeeDaoImpl;

	public void save(Employee employee) {
		System.out.println("employee service called");
		employeeDaoImpl.save(employee);
	}

	public List<Employee> getAllEmps() {
		return employeeDaoImpl.getAllEmps();
	}

}