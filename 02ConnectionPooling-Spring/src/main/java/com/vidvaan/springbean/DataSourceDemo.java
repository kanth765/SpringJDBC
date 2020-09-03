package com.vidvaan.springbean;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceDemo {

	public static void main(String[] args) throws SQLException, PropertyVetoException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
	    DataSource dataSource1 = (DataSource) applicationContext.getBean("basicDataSource");
	    System.out.println(dataSource1.getConnection());
	    
	    DataSource dataSource2 = (DataSource) applicationContext.getBean("driverManagerDataSource");
	    System.out.println(dataSource2.getConnection());
	}

}
