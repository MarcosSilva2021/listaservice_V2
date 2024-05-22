package br.edu.unichristus.listaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
		        title = "Backend da API entrega np2",
		        version = "1.0",
		        description = "Trata-se da Documentação da API construída para a avaliação da NP2",
		        contact = @Contact(
		        	    name = "Admin webadmin",
		        	    email = "admin123@webadmin.com.br",
		        	     url = "https://www.site.com.br")
		    )
		)
public class ListaserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListaserviceApplication.class, args);
	}

}
