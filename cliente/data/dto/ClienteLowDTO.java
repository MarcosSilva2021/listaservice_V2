package br.edu.unichristus.listaservice.cliente.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteLowDTO {

	private Long id;
	
	@JsonProperty("nome")
	private String nome;
	private String email;
	private String endereco;

}
