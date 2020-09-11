package com.vidvaan.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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

	public Map<String, Float> getAllEmps() {
		ResultSetExtractor<Map<String, Float>> resulstSet = new EmployeeResultsetExtractor();
		return jdbcTemplate.query("select * from employee", resulstSet);
	}

	public List<Employee> findAllEmps() {
		RowMapper<Employee> beanRowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		return jdbcTemplate.query("Select * from Employee", beanRowMapper);
	}
}