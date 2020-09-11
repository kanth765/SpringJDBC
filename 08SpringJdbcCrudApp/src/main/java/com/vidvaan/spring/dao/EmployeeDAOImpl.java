package com.vidvaan.spring.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.vidvaan.spring.bean.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public List<Employee> getAll() {
		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		return jdbcTemplate.query("SELECT * FROM EMPLOYEE", rowMapper);
	}

	public Employee getById(int id) {
		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		Employee employee = jdbcTemplate.queryForObject("select  * from employee where empid=?", rowMapper, id);
		return employee;
	}

	public void save(Employee employee) {
		jdbcTemplate.update("insert into employee values(?,?,?,?)",
				new Object[] { employee.getEid(), employee.getEmail(), employee.getEname(), employee.getEsal() });

	}

	public void update(Employee employee) {
		jdbcTemplate.update("update employee set ename=?, esal=? where empid=?",
				new Object[] { employee.getEname(), employee.getEsal(), employee.getEid() });

	}

	public void delete(int eid) {
		jdbcTemplate.update("delete employee where empid=?", new Object[] { eid });
	}

	public Map<String, Float> getEmpMap() {
		return jdbcTemplate.query("Select * from Employee", new EmployeeBeanRowMapper());
	}

	public Employee findById(int eid) {
		return jdbcTemplate.queryForObject("select * from employee where empid=?", new Object[] { eid },
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}

}
