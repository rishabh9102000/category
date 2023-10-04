package com.cg.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
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
@Order(1)
@EnableWebSecurity
public class securityconfig {
	@Bean
	@Primary
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
	 @Primary
	    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		 http
		 		.csrf((csrf) -> csrf.disable())

	            .authorizeHttpRequests(authorize -> authorize
	                    .antMatchers("v1/**").hasRole("ADMIN")
	                    .antMatchers("ad/**").hasRole("USER")
	                    .anyRequest().authenticated()
	                    )
	           
	            .formLogin(formLogin -> formLogin
	              //      .loginPage("/login")
	            		.permitAll()
                )
	            .httpBasic(Customizer.withDefaults());
	        return http.build();
	    }
	 @Bean 
	 public PasswordEncoder passwordEncoder() { 
	 
	     return new BCryptPasswordEncoder(); 
	 }
}
