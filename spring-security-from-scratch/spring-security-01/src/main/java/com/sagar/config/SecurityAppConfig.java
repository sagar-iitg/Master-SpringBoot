package com.sagar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity(debug=true) // this annoation help us to create security filter chain
public class SecurityAppConfig {
	
	

}
