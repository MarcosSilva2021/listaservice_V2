package br.edu.unichristus.listaservice.cliente.controller;

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

import br.edu.unichristus.listaservice.cliente.data.dto.ClienteDTO;
import br.edu.unichristus.listaservice.cliente.data.dto.ClienteLowDTO;
import br.edu.unichristus.listaservice.cliente.data.model.Cliente;
import br.edu.unichristus.listaservice.cliente.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
	
	@Autowired
    private ClienteService service;	
	
	@Operation(summary = "Cadastrar cliente | role: [ADMIN]", 
			tags = "Cliente", description = "Possibilita "
					+ "cadastrar um cliente a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Cliente retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PostMapping
	public ClienteLowDTO save(@RequestBody ClienteDTO cliente) {
		return service.save(cliente);
	}
	
	@Operation(summary = "Editar cliente | role: [ADMIN]", 
			tags = "Cliente", description = "Possibilita "
					+ "Atualizar um cliente a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Cliente retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})	
	@PutMapping
	public ClienteLowDTO update(@RequestBody ClienteDTO user) {
		return service.save(user);
	}
	
	@Operation(summary = "Retornar todos os cliente | role: [ADMIN]", 
			tags = "Cliente", description = "Possibilita "
					+ "Obter uma lista dos clientes")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					" Lista de clientes retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@GetMapping("/all")
	public List<ClienteLowDTO> listAll(){
		return service.listAll();
	}
	
	@Operation(summary = "Excluir um cliente | role: [ADMIN]", 
			tags = "Cliente", description = "Possibilita "
					+ "Excluir um cliente a "
					+ "partir de um identificador(Id) de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Cliente excluido com suceso"),
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
	
	@Operation(summary = "Exibir um cliente | role: [ADMIN]", 
			tags = "Cliente", description = "Possibilita "
					+ "Exibir um cliente a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Cliente retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@GetMapping
	public Cliente findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}

}
