package com.f_rafael_alvarez.Personajes_de_ficcion.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad {
	
	/*
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.
		csrf(csrf -> csrf.disable()).
		authorizeHttpRequests(auth -> auth.anyRequest().authenticated().
				requestMatchers("/login").permitAll())
		.headers(headers -> headers.frameOptions().sameOrigin())
        .httpBasic(Customizer.withDefaults());
		
		return http.build();
	}*/

}
