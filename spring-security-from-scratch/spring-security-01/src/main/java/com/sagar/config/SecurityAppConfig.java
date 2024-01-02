package com.sagar.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity// this annoation help us to create security filter chain
public class SecurityAppConfig {

//	@Bean
//	InMemoryUserDetailsManager setUpUser() {
//			ArrayList<GrantedAuthority> authoritiesList=new ArrayList<>();
//			authoritiesList.add(new SimpleGrantedAuthority("admin"));
//			authoritiesList.add(new SimpleGrantedAuthority("user"));
//			UserDetails sagar=new User("sagar",passwordEncoder().encode("sagar123"), authoritiesList);
//			InMemoryUserDetailsManager inMemoryUserDetailsManager=new InMemoryUserDetailsManager();
//			inMemoryUserDetailsManager.createUser(sagar);
//			return inMemoryUserDetailsManager;		
//			
//	}

	@Bean
	public InMemoryUserDetailsManager setUpUser() {

		UserDetails sagarUser = User.withUsername("sagar").password(passwordEncoder().encode("sagar123")).roles("admin", "user").build();
		UserDetails adminUser = User.withUsername("admin").password(passwordEncoder().encode("admin123")).roles("admin").build();

		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		inMemoryUserDetailsManager.createUser(sagarUser);
		inMemoryUserDetailsManager.createUser(adminUser);
		return inMemoryUserDetailsManager;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
