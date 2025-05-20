package com.bitsnbyte_product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "bits_nbyte_product_list",
				description = "A robust Spring Boot CRUD architecture with JWT authentication, file handling, pagination, and " +
						"exception management — ideal for scalable backend development.",
				version = "v-1.1",
				contact = @Contact(
						name = "Abu Huzaifa",
						email = "abuhuzaifaw7@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Full project documentation and Postman collection (e.g., GitHub repo, Postman collection & swagger-ui with APIS) ",
				url = "https://github.com/iuzaifa/spring-crud-architecture"
		)
)
@SpringBootApplication
public class ProductListsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductListsApplication.class, args);
		System.out.println(" ----------------- Application run successfully ----------------- ");



	}

}
