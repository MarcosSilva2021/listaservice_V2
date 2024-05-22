package br.edu.unichristus.listaservice.colaborador.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColaboradorDTO {

	private Long id;	
	
	private String nome;	
	private String matricula;
	private String status;	
	private String login;	
	private String password;
}
