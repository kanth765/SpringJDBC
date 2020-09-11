package com.vidvaan.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vidvaan.spring.bean.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//	public void save(Employee employee) {
//		System.out.println("employee dao is called");
//		jdbcTemplate.update("insert into employee values(?,?,?,?)",
//				new Object[] { employee.getEid(), employee.getEmail(), employee.getEname(), employee.getEsal(), });
//
//	}

	public void save(Employee employee) {
		System.out.println("employee dao is called");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("empid", employee.getEid());
		map.put("email", employee.getEmail());
		map.put("ename", employee.getEname());
		map.put("esal", employee.getEsal());
		namedParameterJdbcTemplate.update("insert into employee values(:empid,:email,:ename,:esal)", map);

	}

	public List<Employee> getAllEmps() {
		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		return namedParameterJdbcTemplate.query("select * from employee", rowMapper);
	}
}