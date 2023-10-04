package com.example.securitybasicauth.sconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityconfig {
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails adminUser = User.withUsername("rishabh")
				.password(passwordEncoder().encode("rishabh"))
				.roles("ADMIN").build();
		 UserDetails user1 = User.withUsername("user1")
		            .password(passwordEncoder().encode("user1"))
		            .roles("USER")
		            .build();
		return new InMemoryUserDetailsManager(user1,adminUser);
		
	}
	
	 
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		 http
		 		.csrf((csrf) -> csrf.disable())

	            .authorizeHttpRequests(authorize -> authorize
	                    .requestMatchers("v1/**").hasRole("ADMIN")
	                    .requestMatchers("ad/**").hasRole("USER")
	                    .anyRequest().authenticated()
	                    )
	           
	            .formLogin(formLogin -> formLogin
	              //      .loginPage("/login")
	            		.permitAll()
                );
	        return http.build();
	    }
	 @Bean 
	 public PasswordEncoder passwordEncoder() { 
	 
	     return new BCryptPasswordEncoder(); 
	 }
}
