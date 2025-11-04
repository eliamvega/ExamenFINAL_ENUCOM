package com.mx.Videojuego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Accesorio1Application {

	public static void main(String[] args) {
		SpringApplication.run(Accesorio1Application.class, args);
	}

}
