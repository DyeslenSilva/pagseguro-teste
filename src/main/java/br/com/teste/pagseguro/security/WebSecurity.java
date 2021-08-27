package br.com.teste.pagseguro.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("root")
			.password(passwordEnconder().encode("dsd"))
				.roles("root");	
	}
	
	private PasswordEncoder passwordEnconder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET)
			.hasRole("role").antMatchers(HttpMethod.OPTIONS).anonymous()
			.antMatchers("/login").permitAll().anyRequest().authenticated().and().formLogin()
			.loginPage("loginPage.html").loginProcessingUrl("performLogin")
			.defaultSuccessUrl("sucsess", true).failureUrl("falha.html?error=true")
			.failureHandler(authenticationFailureHandler()).and().logout()
			.logoutUrl("logout.html").deleteCookies("COOKIES")
			.logoutRequestMatcher(logoutSuccessHandler());
	}

	private RequestMatcher logoutSuccessHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	private AuthenticationFailureHandler authenticationFailureHandler() {
		// TODO Auto-generated method stub
		return null;
	}

}
