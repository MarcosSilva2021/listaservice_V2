package br.edu.unichristus.listaservice.servico.controller;

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

import br.edu.unichristus.listaservice.servico.data.dto.ServicoDTO;
import br.edu.unichristus.listaservice.servico.data.dto.ServicoLowDTO;
import br.edu.unichristus.listaservice.servico.data.model.Servico;
import br.edu.unichristus.listaservice.servico.service.ServicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/v1/servico")
public class ServicoController {
	
	@Autowired
	private ServicoService service;	
	
	@Operation(summary = "Cadastrar Serviço | role: [ADMIN]", 
			tags = "Serviço", description = "Possibilita "
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
	public ServicoLowDTO save(@RequestBody ServicoDTO servico) {
		return service.save(servico);
	}
	
	@Operation(summary = "Atualizar Serviço | role: [ADMIN]", 
			tags = "Serviço", description = "Possibilita "
					+ "atualizar um serviço a "
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
	@PutMapping
	public ServicoLowDTO update(@RequestBody ServicoDTO servico) {
		return service.save(servico);
	}
	
	@Operation(summary = "Exibir Serviços | role: [ADMIN]", 
			tags = "Serviço", description = "Possibilita "
					+ "exibir todos os serviços a "
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
	@GetMapping("/all")
	public List<ServicoLowDTO> listAll(){
		return service.listAll();
	}
	
	@Operation(summary = "Exibir Serviço | role: [ADMIN]", 
			tags = "Serviço", description = "Possibilita "
					+ "exibir um serviço a "
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
	@GetMapping
	public Servico findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
	@Operation(summary = "Excluir Serviço | role: [ADMIN]", 
			tags = "Serviço", description = "Possibilita "
					+ "excluir um serviço a "
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
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	

}
