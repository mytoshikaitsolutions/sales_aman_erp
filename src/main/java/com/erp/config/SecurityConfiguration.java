package com.erp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.inMemoryAuthentication()
//		.withUser("user").password("{noop}test").roles("USER")
//		.and()
//		.withUser("admin").password("{noop}test1").roles("ADMIN");
//
//	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring()
		.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/image/**","/assets/**","/assets1/**");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

//		httpSecurity
//		.authorizeRequests()
//		.antMatchers("**/api/erp/**")
//		.fullyAuthenticated()
//		.and()
//		.httpBasic();
		httpSecurity.csrf().disable();
	}

//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http.authorizeRequests().antMatchers("/api/erp/**").hasRole("USER")
//	            .antMatchers("/index**").permitAll()
//	            .antMatchers("/login**").permitAll()
//	            .and()
//	            .formLogin();
//	        //.authorizeRequests()
//			//.anyRequest()
//			//.fullyAuthenticated();
//	            //.loginPage( "/login" )
//	            //.loginProcessingUrl( "/login" )
//	            //.defaultSuccessUrl( "/index" );
//	        http.csrf().disable();
//	    }

	

}



