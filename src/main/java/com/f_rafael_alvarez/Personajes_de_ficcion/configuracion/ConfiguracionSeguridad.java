package com.f_rafael_alvarez.Personajes_de_ficcion.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad {
	
	@Autowired
	private UserDetailsService userDetailsService; 
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.
		authorizeHttpRequests(auth -> auth.anyRequest().permitAll()).
		userDetailsService(userDetailsService).
		formLogin(login->login.permitAll()).
        httpBasic(Customizer.withDefaults()).
        csrf(csrf -> csrf.disable());
		
		return http.build();
	}
	/*
	@Bean
	@Autowired
	AuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder) {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		
		return provider;
	}*/

}
