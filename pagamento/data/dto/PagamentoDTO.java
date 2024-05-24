package br.edu.unichristus.listaservice.pagamento.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagamentoDTO {
	
	private Long id;	

	private String nome;
	private String numero;
	private String agencia;
	private String codigoSegurança;

}
