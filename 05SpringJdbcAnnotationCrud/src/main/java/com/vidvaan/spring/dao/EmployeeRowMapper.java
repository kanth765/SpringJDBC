package com.vidvaan.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vidvaan.spring.bean.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEid(rs.getInt(1));
		employee.setEmail(rs.getString(2));
		employee.setEsal(rs.getFloat(4));
		employee.setEname(rs.getString(3));
		return employee;
	}

}
