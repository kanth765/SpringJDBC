package com.vidvaan.spring.client;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vidvaan.spring.dao.EmployeeDAOImpl;

public class EmployeeTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeDAOImpl dao = (EmployeeDAOImpl) context.getBean("dao");
		System.out.println(dao.findById(10));
//		System.out.println(dao.getEmpMap());
//		Map<String, Float> empMap = dao.getEmpMap();
//		for (Map.Entry<String, Float> entry : empMap.entrySet()) {
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}
//		List<Employee> all = dao.getEmpMap();
//		for (Employee employee : all) {
//			System.out.println(employee);
//		}
//		Employee employee = dao.getById(6);
//		System.out.println(employee);
//		Employee employee = new Employee(6, "srikanth@gmail.com", 25000.0f, "srikanth");
//		dao.save(employee);
	}

}
