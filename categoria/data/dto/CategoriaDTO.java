package br.edu.unichristus.listaservice.categoria.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaDTO {

		private Long id;
		
		
		private String nome;
		private String descricao;
		private String status;
		private String adicional;
}

