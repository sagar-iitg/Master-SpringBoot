package com.sagar.springsecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails normalUser=User.
                withUsername("sagar").
                password(passwordEncoder().encode("sagar123")).
                roles("NORMAL").
                build();



        UserDetails adminUser=User.
                withUsername("admin").
                password(passwordEncoder().encode("admin123")).
                roles("ADMIN").
                build();

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(normalUser,adminUser);

        return inMemoryUserDetailsManager;




    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http.csrf().disable()
               .authorizeHttpRequests().
               requestMatchers("/home/admin").hasRole("ADMIN").
               requestMatchers("/home/normal").hasRole("NORMAL").
               requestMatchers("/home/public").
               permitAll()
               .anyRequest()
               .authenticated()
               .and().
               formLogin();
       return http.build();

    }


}
