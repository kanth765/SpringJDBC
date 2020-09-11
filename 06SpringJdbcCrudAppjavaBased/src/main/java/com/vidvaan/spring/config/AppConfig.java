package com.vidvaan.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.vidvaan.spring.*")
@PropertySource("classpath:db.properties")
public class AppConfig {

	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("url"));
		dataSource.setDriverClassName(env.getProperty("driver"));
		dataSource.setUsername(env.getProperty("uname"));
		dataSource.setPassword(env.getProperty("password"));
		return dataSource;
	}

//	@Bean
//	public JdbcTemplate jdbcTemplate() {
//		JdbcTemplate jdbcTemplate = new JdbcTemplate();
//		jdbcTemplate.setDataSource(dataSource());
//		return jdbcTemplate;
//	}

}
