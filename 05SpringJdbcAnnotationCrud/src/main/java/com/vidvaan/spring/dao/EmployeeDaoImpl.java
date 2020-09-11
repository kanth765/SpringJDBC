package com.vidvaan.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.vidvaan.spring.bean.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Employee employee) {
		System.out.println("employee dao is called");
		jdbcTemplate.update("insert into employee values(?,?,?,?)",
				new Object[] { employee.getEid(), employee.getEmail(), employee.getEname(), employee.getEsal(), });

	}

	public List<Employee> getAllEmps() {
		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		return jdbcTemplate.query("select * from employee", rowMapper);
	}
}