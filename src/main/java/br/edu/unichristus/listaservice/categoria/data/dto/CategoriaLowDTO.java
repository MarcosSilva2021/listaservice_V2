package br.edu.unichristus.listaservice.categoria.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaLowDTO {
	
	private Long id;
	
	@JsonProperty("nome")
	private String nome;
	private String descricao;
	private String status;

}