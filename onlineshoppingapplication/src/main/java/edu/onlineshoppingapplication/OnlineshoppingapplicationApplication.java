package edu.onlineshoppingapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@SpringBootApplication
@OpenAPIDefinition(
		info= @Info(
				title = "OnloneShoppingApplicationAPI",
				version = "1.0",
				description = "Devendra",
				contact = @Contact(
						name = "Devendra",
						email = "dmule5578@gmail.com",
						url = "abc")
				)			
	)
public class OnlineshoppingapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineshoppingapplicationApplication.class, args);
	}
	
	@Bean
	public OpenAPI getOpenApi() {
		return new OpenAPI();
	}

}
