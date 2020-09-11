package com.vidvaan.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.vidvaan.spring.bean.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
//	private JdbcTemplate jdbcTemplate;
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Employee> getAll() {
//		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
//		RowMapper<Employee> rowMapper = BeanPropertyRowMapper.newInstance(Employee.class);
		return jdbcTemplate.query("SELECT * FROM EMPLOYEE", rowMapper);
	}

}
