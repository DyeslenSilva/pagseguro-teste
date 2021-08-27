package br.com.teste.pagseguro.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.teste.pagseguro.service.ArquivoService;

@Configuration
@EnableConfigurationProperties
public class PagSeguroSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ArquivoService arquivoService;
	private UserDetailsService detailsService;
	
	protected void configure(HttpSecurity httpSecurity) throws 	Exception {
		httpSecurity.httpBasic().and().authorizeRequests()
			.antMatchers("/h2-console/").permitAll()
			.antMatchers("/").permitAll().antMatchers("/arquivo").hasRole("root")
			.antMatchers("/arquivo2").hasRole("root").and().csrf().disable().headers()
			.frameOptions().disable();
	}
	
//	
//	protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
//		managerBuilder.userDetailsService(detailsService)
//				.passwordEncoder(new BCryptPasswordEncoder());
//	}
	
}
