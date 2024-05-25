package br.edu.unichristus.listaservice.servico.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicoDTO {

	private Long id;
	
	
	private String nome;
	private String descricao;
	private String localizacao;
	private String status;
}
