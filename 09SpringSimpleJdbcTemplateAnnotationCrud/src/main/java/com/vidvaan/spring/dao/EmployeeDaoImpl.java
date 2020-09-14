package com.vidvaan.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vidvaan.spring.bean.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;

//	public void save(Employee employee) {
//		System.out.println("employee dao is called");
//		jdbcTemplate.update("insert into employee values(?,?,?,?)",
//				new Object[] { employee.getEid(), employee.getEmail(), employee.getEname(), employee.getEsal(), });
//
//	}
	public void insert(Employee employee) {
		System.out.println("employee dao is called");
		String sql = "insert into employee values(:empid,:email,:ename,:esal)";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("empid", employee.getEid());
		parameters.put("email", employee.getEmail());
		parameters.put("ename", employee.getEname());
		parameters.put("esal", employee.getEsal());
		simpleJdbcTemplate.update(sql, parameters);

	}

	public Employee getById(int id) {
//		String SELECT_BY_ID = "select * from employee where empid=?";
		String SELECT_BY_ID = "select * from employee where empid=:eid";

//		SqlParameterSource namedParameters = new MapSqlParameterSource("eid", Integer.valueOf(id));
//		Map<String, Integer> parameters = new HashMap<String, Integer>();
//		parameters.put("eid", id);
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("eid", id);

		return simpleJdbcTemplate.queryForObject(SELECT_BY_ID, new EmployeeRowMapper(), namedParameters);
	}

	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	public int[] batchUpdate(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return null;
	}
// first approach
	/*
	 * RowMapper<Employee> rowMapper = new EmployeeRowMapper(); return
	 * simpleJdbcTemplate.queryForObject(SELECT_BY_ID, rowMapper, id);
	 */

	public void save(Employee employee) {
		simpleJdbcTemplate.update("insert into employee values(?,?,?,?)", employee.getEid(), employee.getEmail(),
				employee.getEname(), employee.getEsal());

	}

// second approach

//		return simpleJdbcTemplate.queryForObject(SELECT_BY_ID,
//				ParameterizedBeanPropertyRowMapper.newInstance(Employee.class), id);
}
