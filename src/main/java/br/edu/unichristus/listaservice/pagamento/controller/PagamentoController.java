package br.edu.unichristus.listaservice.pagamento.controller;

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

import br.edu.unichristus.listaservice.pagamento.data.dto.PagamentoDTO;
import br.edu.unichristus.listaservice.pagamento.data.dto.PagamentoLowDTO;
import br.edu.unichristus.listaservice.pagamento.data.model.Pagamento;
import br.edu.unichristus.listaservice.pagamento.service.PagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/v1/pagamento")
public class PagamentoController {
	
	@Autowired
	private PagamentoService service;	
	
	@Operation(summary = "Cadastrar Pagamento | role: [ADMIN]", 
			tags = "Pagamento", description = "Possibilita "
					+ "cadastrar um pagamento a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					" Froma de pagamento retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Pagamento informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PostMapping
	public PagamentoLowDTO save(@RequestBody PagamentoDTO Pagamento) {
		return service.save(Pagamento);
	}
	
	@Operation(summary = "Atualizar Pagamento | role: [ADMIN]", 
			tags = "Pagamento", description = "Possibilita "
					+ "atualizar uma pagamento a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Pagamento retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"A pagamento informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PutMapping
	public PagamentoLowDTO update(@RequestBody PagamentoDTO pagamento) {
		return service.save(pagamento);
	}
	
	@Operation(summary = "Exibir todas as pagamentos | role: [ADMIN]", 
			tags = "Pagamento", description = "Possibilita "
					+ "exibir todos as pagamentos a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Pagamento retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"A pagamento informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@GetMapping("/all")
	public List<PagamentoLowDTO> listAll(){
		return service.listAll();
	}
	
	@Operation(summary = "Exibir Serviço | role: [ADMIN]", 
			tags = "Pagamento", description = "Possibilita "
					+ "exibir uma pagamento a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Pagamento retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O pagamento informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@GetMapping
	public Pagamento findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
	@Operation(summary = "Excluir Pagamento | role: [ADMIN]", 
			tags = "Pagamento", description = "Possibilita "
					+ "excluir um Pagamento a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Pagamento retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Pagamento informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
