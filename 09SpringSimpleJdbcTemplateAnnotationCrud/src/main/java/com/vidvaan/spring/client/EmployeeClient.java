package com.vidvaan.spring.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vidvaan.spring.bean.Employee;
import com.vidvaan.spring.controller.EmployeeController;

public class EmployeeClient {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeController controller = (EmployeeController) context.getBean("employeeController");
//		List<Employee> employeeList = new ArrayList<Employee>();
//		Employee employee = new Employee();
//		employee.setEid(150);
//		employee.setEname("Dhiraj");
//		employee.setEmail("Dhiraj@gamil.com");
//		employee.setEsal(20000.0f);
//
//		Employee employee2 = new Employee();
//		employee2.setEid(151);
//		employee2.setEname("laxmi");
//		employee2.setEmail("laxmi@gamil.com");
//		employee2.setEsal(20000.0f);
//		employeeList.add(employee);
//		employeeList.add(employee2);
//		controller.batchUpdate(employeeList);

		List<Employee> allEmps = controller.getAllEmps();
		for (Employee employee : allEmps) {
			System.out.println(employee);
		}

//		System.out.println(controller.getById(131));
	}

}
