package br.com.teste.pagseguro.dataconfig;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@SuppressWarnings("serial")
@EnableJpaRepositories("br.com.teste.pagseguro.*")
@ComponentScan(basePackages = {"br.com.teste.pagseguro.*"})
@EntityScan("br.com.teste.pagseguro.*")
public class ConfigJPA implements Serializable{

	private EntityManager entityManager;
	
	public DataSource dataSource() {
		String url = "jdbc:mysql://localhost:3306/pagseguro";

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl(url);
		return dataSource;
	}
	 	 	 		 	 	
	
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManager.getEntityManagerFactory());
		return transactionManager;
	}
	
	
	
}
