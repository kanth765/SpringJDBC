package com.vidvaan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidvaan.spring.bean.Employee;
import com.vidvaan.spring.dao.EmployeeDAOImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAOImpl employeeDAOImpl;

	public List<Employee> getAll() {
		return employeeDAOImpl.getAll();
	}

}
