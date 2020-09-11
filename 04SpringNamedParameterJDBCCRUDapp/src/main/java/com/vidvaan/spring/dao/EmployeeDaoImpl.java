package com.vidvaan.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vidvaan.spring.bean.Employee;

@Repository("dao")
public class EmployeeDaoImpl implements EmployeeDAO {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void insert(Employee employee) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("eid", employee.getEid());
		map.put("email", employee.getEmail());
		map.put("ename", employee.getEname());
		map.put("esal", employee.getEsal());

		namedParameterJdbcTemplate.update("insert into employee values(:empid, :email, :ename, :esal)", map);

	}

	public void update(Employee employee) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("eid", employee.getEid());
		map.put("mail", employee.getEmail());
		map.put("name", employee.getEname());

		namedParameterJdbcTemplate.update("update  employee set email=:mail ,ename=:name where empid=:eid", map);

	}

	public List<Employee> findAllEmps() {
		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		return namedParameterJdbcTemplate.query("Select * from Employee", rowMapper);
	}
}
