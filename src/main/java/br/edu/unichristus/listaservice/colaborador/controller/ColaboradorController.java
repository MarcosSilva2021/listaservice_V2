package br.edu.unichristus.listaservice.colaborador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.listaservice.colaborador.data.dto.ColaboradorDTO;
import br.edu.unichristus.listaservice.colaborador.data.dto.ColaboradorLowDTO;
import br.edu.unichristus.listaservice.colaborador.data.model.Colaborador;
import br.edu.unichristus.listaservice.colaborador.service.ColaboradorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/colaborador")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService service;
	
	
	@Operation(summary = "Cadastrar um colaborador | role: [ADMIN]", 
			tags = "Colaborador", description = "Possibilita "
					+ "cadastrar um colaborador a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Colaborador retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PostMapping
	public ColaboradorLowDTO save(@RequestBody ColaboradorDTO colab) {
		return service.save(colab);
	}
	//PostMapping
	//public ClienteLowDTO save(@RequestBody ClienteDTO cliente) {
//			return service.save(cliente);
	
	@Operation(summary = "Atualizar um colaborador | role: [ADMIN]", 
			tags = "Colaborador", description = "Possibilita "
					+ "Atualizar um colaborador a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Colaborador retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PutMapping
	public ColaboradorLowDTO update(@RequestBody ColaboradorDTO colab) {
		return service.save(colab);
	}
	
	@Operation(summary = "Listar todos os colaboradores | role: [ADMIN]", 
			tags = "Colaborador", description = "Possibilita "
					+ "Listar colaboradores")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Colaborador retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@GetMapping("/all")
	public List<ColaboradorLowDTO> listAll(){
		return service.listAll();
	}
	
	@Operation(summary = "Excluir um colaborador | role: [ADMIN]", 
			tags = "Colaborador", description = "Possibilita "
					+ "Excluir um colaborador a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Colaborador retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@Operation(summary = "Exibir um colaborador | role: [ADMIN]", 
			tags = "Colaborador", description = "Possibilita "
					+ "Exibir um colaborador a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Colaborador retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@GetMapping
	public Colaborador findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
	
	

}
