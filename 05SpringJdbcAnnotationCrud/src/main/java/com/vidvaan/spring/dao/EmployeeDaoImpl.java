package com.vidvaan.spring.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.vidvaan.spring.bean.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	@Autowired
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

	public int findTotalEmps() {
		String sql = "select count(*) from employee";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	public int findTotalEmployeesByEsal(float sal) {
		String sql = "select count(*) from employee where esal=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, sal);
		return count;
	}

	public boolean isEmployeeExits(String name) {
		String sql = "select count(*) from employee where ename=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, name);
		if (count > 1)
			return true;
		return false;
	}

	public void insertRecords(List<Employee> employeeList) {
		String sql = "insert into employee values(?,?,?,?)";
		List<Object[]> batchEmps = new ArrayList<Object[]>();
		for (Employee employee : employeeList) {
			Object[] objArray = { employee.getEid(), employee.getEmail(), employee.getEname(), employee.getEsal() };
			batchEmps.add(objArray);

		}
		jdbcTemplate.batchUpdate(sql, batchEmps);

	}

	public int[] batchUpdate(final List<Employee> employeeList) {
		String sql = "insert into employee values(?,?,?,?)";
		int [] insertRecords=jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, employeeList.get(i).getEid());
				ps.setString(2, employeeList.get(i).getEmail());
				ps.setString(3, employeeList.get(i).getEname());
				ps.setFloat(4, employeeList.get(i).getEsal());

			}

			public int getBatchSize() {
				return 2;
			}
		});
		return insertRecords;
	}

}