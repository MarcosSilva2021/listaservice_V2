package br.edu.unichristus.listaservice.colaborador.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_colaborador")
public class Colaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Column(name = "nome", nullable = false, length = 150)
    //@NotNull(message = "Nome não pode ser nulo")
    //@Size(max = 150, message = "Nome não pode exceder 150 caracteres")
    private String nome;
	
	@Column(nullable = false, length = 150)
	private String matricula;
	private String status;
	
	@Column(unique = true)
	private String login;	
	private String password;
	
	
}
