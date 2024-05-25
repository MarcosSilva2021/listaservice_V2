package br.edu.unichristus.listaservice.pagamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.listaservice.cliente.dozer.DozerConverter;
import br.edu.unichristus.listaservice.cliente.exception.CommonsException;
import br.edu.unichristus.listaservice.pagamento.data.dto.PagamentoDTO;
import br.edu.unichristus.listaservice.pagamento.data.dto.PagamentoLowDTO;
import br.edu.unichristus.listaservice.pagamento.data.model.Pagamento;
import br.edu.unichristus.listaservice.pagamento.repository.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository repository;
	
	public PagamentoLowDTO save(PagamentoDTO pagamentoDTO) {
		var pagamentoModel =  DozerConverter.parseObject(pagamentoDTO, Pagamento.class);
		if(pagamentoModel.getNome().length() > 150) {
			 throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.pagamento.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}
		
		//var pagamentoFind = repository.findByLogin(pagamentoModel.getNome());
		var pagamentoFind = repository.findByNome(pagamentoModel.getNome());
		if(!pagamentoFind.isEmpty()) {
				throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.pagamento.conflict.exception",
					"O numero da forma de Pagamento informado já existe!"
					);
		}
		
		var pagamentoSaved = repository.save(pagamentoModel);
		
		var pagamentoLowDTO = DozerConverter.parseObject(pagamentoSaved, PagamentoLowDTO.class);
		
		return pagamentoLowDTO;
	}
	
	public List<PagamentoLowDTO> listAll(){
		var listPagamentoLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listPagamentoLow, PagamentoLowDTO.class);
		
		return listConverted;
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Pagamento findById(Long id) {
		var pagamento = repository.findById(id);
		if(pagamento.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.pagamento.notfound.exception",
					"O Pagamento com a ID informada, não foi encontrado."
					);
		}
		return pagamento.get();
	}	
}