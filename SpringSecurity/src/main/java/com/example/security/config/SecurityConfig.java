package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@SuppressWarnings("deprecation")
@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	authenticationManagerBuilder.inMemoryAuthentication()	
	.withUser("pradeek")
	.password("$2a$12$r0UigrPOAT3NwTHexpZidOUk3BQryc6WwW0ez/6LO8VjwOneliP9O")
	.authorities("player")
	.and()
	.withUser("Carlo Ancelotti")
	.password("$2a$12$F/nGP.vP.dOl2BZiSpPW0.EqtZMC8OC2VnV8Au1IRHHw78u63bm7e")
	.authorities("coach")
	.and()
	.withUser("Florentino perez")
	.password("$2a$12$dr2pDKQZ4afUUD0C.a6tZ.TAXvinFP4avpDXQiCFkWG9Xsf3JlaDS")
	.authorities("president");
	
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception { // authorizan-> api's accesed by actors
		httpSecurity.authorizeRequests()
		.antMatchers("/player/**").hasAuthority("player")
		.antMatchers("/coach/**").hasAuthority("coach")
		.antMatchers("/ceo/**").hasAuthority("president")
		.antMatchers("/transfer/**").hasAnyAuthority("coach", "president")
		.antMatchers("/**").permitAll()
		.and()
		.formLogin();
		
	}
	
	@Bean
	public PasswordEncoder getPassword() {
		return new BCryptPasswordEncoder();
		
	}
	
	

}
