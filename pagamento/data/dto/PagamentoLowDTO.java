package br.edu.unichristus.listaservice.pagamento.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagamentoLowDTO {
	
	private Long id;	
	
	@JsonProperty("nome")
	private String nome;
	private String numero;
	private String agencia;
	

}
