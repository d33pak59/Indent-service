package com.tracemeds.indent_service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class IndentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndentServiceApplication.class, args);
	}
	@Bean
	public ModelMapper model(){
		return new ModelMapper();
	}
}
