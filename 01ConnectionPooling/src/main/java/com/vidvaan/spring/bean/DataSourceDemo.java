package com.vidvaan.spring.bean;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceDemo {

	public static void main(String[] args) throws SQLException, PropertyVetoException {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		basicDataSource.setUsername("test");
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setPassword("test");
		System.out.println("Basic DataSource : "+basicDataSource.getConnection());
		
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		comboPooledDataSource.setUser("test");
		comboPooledDataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
		comboPooledDataSource.setPassword("test");
		System.out.println("ComboPooledDataSource : "+comboPooledDataSource);
	
	}

}
