package com.mx.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //definir beans en el contenedor de spring 
@EnableWebSecurity //para hacer la configuracion de seguridad
public class SecurityConfig {
//METODO QUE PIDA AUTENTIFICACION BASICA PARA TODAS LAS PETICIONES 
	//@Bean
	//SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {//excepcion verificada
		//http.csrf(csrf -> csrf.disable())
		//.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()) //indica que todas las peticiones deben autentificarse
		//.formLogin(Customizer.withDefaults())//agrega un formulario para el usuario y la contraseña
		//.httpBasic(Customizer.withDefaults());//autenticacion basica
		
		//return http.build();//retorna la nueva configuracion de seguridad
	//}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(
				authorize -> authorize
				.requestMatchers("/balance").permitAll()
				.requestMatchers("/contacto").hasRole("ADMIN")
				.requestMatchers("/api/bici/editar").hasAnyRole("USER","ADMIN")
				.requestMatchers("/api/bici/eliminar").hasRole("ADMIN")
				.anyRequest().authenticated())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		return http.build();
				
	}
	
	//metodo para crear usuario con rol USER
	
	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
				User.withDefaultPasswordEncoder()
				.username("enucom")
				.password("1234")
				.roles("USER")
				.build()
				
				);
		return manager;
		}
}
