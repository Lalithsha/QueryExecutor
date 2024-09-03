package com.example.QueryExecutor;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class QueryExecutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryExecutorApplication.class, args);
	}

	/*
	 * @Bean
	 * public DataSource dataSource() {
	 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 * dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	 * dataSource.setUrl("jdbc:mysql://localhost:3306/yourdb");
	 * dataSource.setUsername("your_username");
	 * dataSource.setPassword("your_password");
	 * return dataSource;
	 * }
	 */

}
