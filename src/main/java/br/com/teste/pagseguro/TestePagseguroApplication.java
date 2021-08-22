package br.com.teste.pagseguro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class TestePagseguroApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(TestePagseguroApplication.class, args);
		//ApplicationContext appContext =new ClassPathXmlApplicationContext("application-context.xml");
		
	}

}
