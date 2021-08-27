package br.com.teste.pagseguro;

import java.lang.reflect.InvocationTargetException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import com.sun.org.slf4j.internal.Logger;


@SpringBootApplication
@EntityScan(basePackages = {"br.com.teste.pagseguro.model"})
@ComponentScan(basePackages = {"br.com.teste.pagseguro.cotroller",
		"br.com.teste.pagseguro.config","br.com.teste.pagseguro.service"})
@EnableJpaRepositories(basePackages = "br.com.teste.pagseguro.repo")
public class TestePagseguroApplication  {

	public static void main(String[] args) throws InvocationTargetException {
		
		SpringApplication.run(TestePagseguroApplication.class, args);
		//	ApplicationContext appContext =new ClassPathXmlApplicationContext("application-context.xml");
	
	
	
	}

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		AnnotationConfigApplicationContext root = 
//				new AnnotationConfigApplicationContext();
//		root.register(WebSecurity.class);
//		servletContext.addListener(new ContextLoaderListener((WebApplicationContext) root));
//		servletContext.addFilter("securityFilter", new DelegatingFilterProxy("SpringSecurityFilterChain"))
//			.addMappingForUrlPatterns(null, false, "/+");
//	}

}
