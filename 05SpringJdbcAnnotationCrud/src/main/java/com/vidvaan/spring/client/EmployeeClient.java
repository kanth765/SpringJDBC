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
//		Employee employee = new Employee();
//		employee.setEid(11);
//		employee.setEname("Anil");
//		employee.setEmail("anil@gamil.com");
//		employee.setEsal(22000.0f);
//		controller.addEmp(employee);

//		List<Employee> allEmps = controller.getAllEmps();
//		for (Employee employee : allEmps) {
//			System.out.println(employee);
//		}

		Employee e1 = new Employee();
		e1.setEid(120);
		e1.setEmail("krishna@gmail.com");
		e1.setEname("krishna");
		e1.setEsal(27000.0f);
		Employee e2 = new Employee();
		e2.setEid(121);
		e2.setEmail("shrav@gmail.com");
		e2.setEname("shrav");
		e2.setEsal(23000.0f);
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(e1);
		employeeList.add(e2);
		controller.insertRecords(employeeList);

	}

}
