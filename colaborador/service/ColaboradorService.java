package br.edu.unichristus.listaservice.colaborador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import br.edu.unichristus.listaservice.cliente.exception.CommonsException;
import br.edu.unichristus.listaservice.colaborador.data.dto.ColaboradorDTO;
import br.edu.unichristus.listaservice.colaborador.data.dto.ColaboradorLowDTO;
import br.edu.unichristus.listaservice.colaborador.data.model.Colaborador;
import br.edu.unichristus.listaservice.colaborador.dozer.DozerConverter;
import br.edu.unichristus.listaservice.colaborador.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository repository;
	
	public ColaboradorLowDTO save(ColaboradorDTO colabDTO) {
		var colabModel = DozerConverter.parseObject(colabDTO, Colaborador.class);
		if(colabModel.getNome().length() > 150) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.colaborador.badrequest.exception",
					"Limite de caracteres excedido!"
					);
			
		}
		var colabFind = repository.findByLogin(colabModel.getLogin());
		if(!colabFind.isEmpty()) {
			throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.colaborador.conflict.exception",
					"O Login informado já existe!"
					);
		}
		
		var colabSaved = repository.save(colabModel);
		
		var colabLowDTO = DozerConverter.parseObject(colabSaved, ColaboradorLowDTO.class);
		
		return colabLowDTO;
	}
	
	public List<ColaboradorLowDTO> listAll(){
		var listColabLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listColabLow, ColaboradorLowDTO.class);
		
		return listConverted;
	}
	
	public void delete(long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Colaborador findById(Long id) {
		var colab = repository.findById(id);
		if(colab.isEmpty()){
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.colaborador.notfound.exception",
					"O usuário com a ID informada, não foi encontrado."
					);
		}
		return colab.get();		
	}
}
