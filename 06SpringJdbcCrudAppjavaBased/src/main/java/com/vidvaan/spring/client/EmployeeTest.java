package com.vidvaan.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vidvaan.spring.bean.Employee;
import com.vidvaan.spring.config.AppConfig;
import com.vidvaan.spring.controller.EmployeeController;
import com.vidvaan.spring.dao.EmployeeDAO;
import com.vidvaan.spring.dao.EmployeeDAOImpl;

public class EmployeeTest {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeController controller = (EmployeeController) context.getBean(EmployeeController.class);
		List<Employee> all = controller.findAllEmps();
		for (Employee employee : all) {
			System.out.println(employee);
		}
	}

}
