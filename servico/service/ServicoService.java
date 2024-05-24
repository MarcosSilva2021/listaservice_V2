package br.edu.unichristus.listaservice.servico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.listaservice.cliente.dozer.DozerConverter;
import br.edu.unichristus.listaservice.cliente.exception.CommonsException;
import br.edu.unichristus.listaservice.servico.data.dto.ServicoDTO;
import br.edu.unichristus.listaservice.servico.data.dto.ServicoLowDTO;
import br.edu.unichristus.listaservice.servico.data.model.Servico;
import br.edu.unichristus.listaservice.servico.repository.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository repository;
	
	public ServicoLowDTO save(ServicoDTO servicoDTO) {
		var servicoModel =  DozerConverter.parseObject(servicoDTO, Servico.class);
		if(servicoModel.getNome().length() > 150) {
			 throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.servico.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}
		
		//var servicoFind = repository.findByLogin(servicoModel.getNome());
		//var servicoFind = repository.findByNome(servicoModel.getNome());
		/**if(!servicoFind.isEmpty()) {
				throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.servico.conflict.exception",
					"O Serviço informado já existe!"
					);
		}**/
		
		var servicoSaved = repository.save(servicoModel);
		
		var servicoLowDTO = DozerConverter.parseObject(servicoSaved, ServicoLowDTO.class);
		
		return servicoLowDTO;
	}
	
	public List<ServicoLowDTO> listAll(){
		var listServicoLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listServicoLow, ServicoLowDTO.class);
		
		return listConverted;
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Servico findById(Long id) {
		var servico = repository.findById(id);
		if(servico.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.servico.notfound.exception",
					"O Serviço com a ID informada, não foi encontrado."
					);
		}
		return servico.get();
	}	
}
