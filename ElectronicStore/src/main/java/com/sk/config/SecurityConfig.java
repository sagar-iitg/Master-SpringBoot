/**
 * @author
 * Sagar Kumar
 */
package com.sk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.sk.services.impl.CustomUserDetailService;

@Configuration

public class SecurityConfig {

	
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	
	
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		
//		
//		UserDetails normal=User.builder()
//		.username("Sagar").password(passwordEncoder().encode("test123")).roles("NORMAL").build();
//		
//		
//
//		UserDetails admin=User.builder().
//		username("Kumar").
//		password(passwordEncoder().encode("test1234")).
//		roles("ADMIN").
//		build();
//		
//		
//		//create users
//		
//		  
//		return new InMemoryUserDetailsManager(normal,admin);
//	}
	
	
//	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
//	{
//	
//		
//		
//			http.authorizeRequests().anyRequest().authenticated().and().	
//			formLogin().loginPage("login.html").loginProcessingUrl("/process")
//			.defaultSuccessUrl("/dashboard").failureUrl("error").and().logout().logoutUrl("/logput");
//			
//		
//			return http.build();
//			
//		
//	}
	
	
	
	
	
	
	
	
	
	
	

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
	
		
		http.
		csrf().
		disable().		
		cors().disable().		
		authorizeRequests().
		anyRequest().
		authenticated().
		and()
		.httpBasic();
		
		
		return http.build();
			
		
	}
	
	
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.customUserDetailService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
		
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		
		return new BCryptPasswordEncoder();
		
	}
	
}
