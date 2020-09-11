package com.vidvaan.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vidvaan.spring.bean.Employee;
import com.vidvaan.spring.controller.EmployeeController;

public class EmployeeClient {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeController controller = (EmployeeController) context.getBean("employeeController");
//		Employee employee = new Employee();
//		employee.setEid(12);
//		employee.setEname("Dhiraj");
//		employee.setEmail("Dhiraj@gamil.com");
//		employee.setEsal(20000.0f);
//		controller.addEmp(employee);

		List<Employee> allEmps = controller.getAllEmps();
		for (Employee employee : allEmps) {
			System.out.println(employee);
		}
	}

}
