package br.com.teste.pagseguro.config;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@EnableJpaRepositories
//@ComponentScan(basePackages = {"br.com.teste.pagseguro.*"})
//@EntityScan("br.com.teste.pagseguro.*")
public class AppConfig extends WebSecurityConfigurerAdapter implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -5261503485781583913L;

//	@Autowired
//	private ArquivoService arquivoService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
			.antMatchers("/arquivoController/salvarArquivo")
			.access("hasRole('root') or hasRole('cadastroArquivo')")
			.antMatchers("/arquivoController/acoes").access("hasRole(root) or hasRole(acoes)")
			.antMatchers("/home").authenticated().anyRequest().authenticated().and().formLogin()
			.loginPage("/").defaultSuccessUrl("/home",true).permitAll().and().logout().logoutSuccessUrl("/")
			.logoutUrl("/logout").permitAll();
		
		httpSecurity.exceptionHandling().accessDeniedPage("/acessoNegado");
		
		httpSecurity.authorizeRequests().antMatchers("/resources/**").permitAll()
			.anyRequest().permitAll();
	}
	
	
	
	

}
