package com.vidvaan.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.vidvaan.spring.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(Employee employee) {
		jdbcTemplate.update("insert into employee values(?,?,?,?)",
				new Object[] { employee.getEid(), employee.getEmail(), employee.getEname(), employee.getEsal() });

	}

	public List<Employee> getAllEmps() {
		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		return jdbcTemplate.query("select * from employee", rowMapper);
	}
}