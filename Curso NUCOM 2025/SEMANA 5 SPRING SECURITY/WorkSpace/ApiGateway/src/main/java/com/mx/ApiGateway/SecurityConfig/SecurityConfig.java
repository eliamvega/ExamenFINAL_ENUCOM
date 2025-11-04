package com.mx.ApiGateway.SecurityConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(
				authorize -> authorize
				.requestMatchers("/api/usuario/listar").permitAll()
				.requestMatchers("/api/usuario/guardar").hasRole("USER")
				.requestMatchers("/api/usuario/editar").hasAnyRole("USER","ADMIN")
				.requestMatchers("/api/usuario/eliminar").hasRole("USER")
				.anyRequest().permitAll())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	@Autowired
	DataSource dataSource;
	
	@Bean
	UserDetailsManager userDetailsManager() {
		
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
		manager.setUsersByUsernameQuery("SELECT USERNAME, PASSWORD, 1 AS ENABLED FROM USER_AU WHERE USERNAME = ?");
		manager.setAuthoritiesByUsernameQuery("SELECT USERNAME, ROL AS AUTHORITY FROM USER_AU WHERE USERNAME = ?");
		System.out.print("MENSAJE DESDE EL ACCESO DE LOS USUARIOS: " + manager);
		return manager;
	}
}
