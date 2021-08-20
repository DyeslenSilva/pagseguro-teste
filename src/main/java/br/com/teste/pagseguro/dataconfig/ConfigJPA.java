package br.com.teste.pagseguro.dataconfig;

import java.beans.JavaBean;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@JavaBean
public class ConfigJPA {

	private EntityManager entityManager;
	
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("");
		return dataSource;
	}
	
	
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManager.getEntityManagerFactory());
		return transactionManager;
	}
	
	
	
}
