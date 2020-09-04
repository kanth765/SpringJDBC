package com.vidvaan.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vidvaan.spring.bean.Employee;
import com.vidvaan.spring.dao.EmployeeDaoImpl;

public class EmployeeTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeDaoImpl employeeImpl = (EmployeeDaoImpl) context.getBean("dao");
		List<Employee> allEmps = employeeImpl.getAllEmps();
		for (Employee employee : allEmps) {
			System.out.println(employee);
		}
//		Employee employee = new Employee(10, "raju@gmail.com", 15000.0f, "raju");
//		employeeImpl.insert(employee);
	}

}
