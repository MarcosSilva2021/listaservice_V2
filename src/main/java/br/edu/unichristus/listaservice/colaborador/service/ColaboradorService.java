package br.edu.unichristus.listaservice.colaborador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.listaservice.cliente.dozer.DozerConverter;
import br.edu.unichristus.listaservice.cliente.exception.CommonsException;
import br.edu.unichristus.listaservice.colaborador.data.dto.ColaboradorDTO;
import br.edu.unichristus.listaservice.colaborador.data.dto.ColaboradorLowDTO;
import br.edu.unichristus.listaservice.colaborador.data.model.Colaborador;
import br.edu.unichristus.listaservice.colaborador.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository repository;
	
	// do chatgpt
	public ColaboradorLowDTO save(ColaboradorDTO colabDTO) {
	    // Verifica se colabDTO é nulo
	    if (colabDTO == null) {
	        throw new CommonsException(
	                HttpStatus.BAD_REQUEST,
	                "unichristus.backend.service.colaborador.badrequest.exception",
	                "Dados do colaborador não podem ser nulos!"
	        );
	    }
	    
	    // Converte o DTO para o modelo
	    var colabModel = DozerConverter.parseObject(colabDTO, Colaborador.class);
	    
	    // Verifica se o nome não é nulo e o comprimento é válido
	    if (colabModel.getNome().length() > 150) {
	        throw new CommonsException(
	                HttpStatus.BAD_REQUEST,
	                "unichristus.backend.service.colaborador.badrequest.exception",
	                "Limite de caracteres excedido!"
	        );
	    }

	    // Verifica se já existe um colaborador com o mesmo login
	    var userFind = repository.findByLogin(colabModel.getLogin());
	    if (!userFind.isEmpty()) {
	        throw new CommonsException(
	                HttpStatus.CONFLICT,
	                "unichristus.backend.service.colaborador.conflict.exception",
	                "O Login informado já existe!"
	        );
	    }
	    
	    // Salva o modelo no repositório
	    var colabSaved = repository.save(colabModel);
	    
	    // Converte o modelo salvo para o DTO de retorno
	    var colabLowDTO = DozerConverter.parseObject(colabSaved, ColaboradorLowDTO.class);
	    
	    // Retorna o DTO de retorno
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
