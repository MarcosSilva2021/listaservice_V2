package br.edu.unichristus.listaservice.categoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.listaservice.categoria.data.dto.CategoriaDTO;
import br.edu.unichristus.listaservice.categoria.data.dto.CategoriaLowDTO;
import br.edu.unichristus.listaservice.categoria.data.model.Categoria;
import br.edu.unichristus.listaservice.categoria.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;	
	
	@Operation(summary = "Cadastrar Categoria | role: [ADMIN]", 
			tags = "Categoria", description = "Possibilita "
					+ "cadastrar um serviço a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Serviço retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Serviço informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PostMapping
	public CategoriaLowDTO save(@RequestBody CategoriaDTO Categoria) {
		return service.save(Categoria);
	}
	
	@Operation(summary = "Atualizar Categoria | role: [ADMIN]", 
			tags = "Categoria", description = "Possibilita "
					+ "atualizar uma categoria a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Categoria retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"A categoria informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PutMapping
	public CategoriaLowDTO update(@RequestBody CategoriaDTO categoria) {
		return service.save(categoria);
	}
	
	@Operation(summary = "Exibir todas as categorias | role: [ADMIN]", 
			tags = "Categoria", description = "Possibilita "
					+ "exibir todos as categorias a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Categoria retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"A categoria informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@GetMapping("/all")
	public List<CategoriaLowDTO> listAll(){
		return service.listAll();
	}
	
	@Operation(summary = "Exibir Serviço | role: [ADMIN]", 
			tags = "Categoria", description = "Possibilita "
					+ "exibir uma categoria a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Categoria retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"A categoria informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@GetMapping
	public Categoria findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
	@Operation(summary = "Excluir Categoria | role: [ADMIN]", 
			tags = "Categoria", description = "Possibilita "
					+ "excluir um Categoria a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Categoria retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Categoria informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
