package br.edu.unichristus.listaservice.categoria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.listaservice.categoria.data.dto.CategoriaDTO;
import br.edu.unichristus.listaservice.categoria.data.dto.CategoriaLowDTO;
import br.edu.unichristus.listaservice.categoria.data.model.Categoria;
import br.edu.unichristus.listaservice.categoria.repository.CategoriaRepository;
import br.edu.unichristus.listaservice.cliente.dozer.DozerConverter;
import br.edu.unichristus.listaservice.cliente.exception.CommonsException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public CategoriaLowDTO save(CategoriaDTO categoriaDTO) {
		var categoriaModel =  DozerConverter.parseObject(categoriaDTO, Categoria.class);
		if(categoriaModel.getNome().length() > 150) {
			 throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.categoria.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}
		
		//var categoriaFind = repository.findByLogin(categoriaModel.getNome());
		var categoriaFind = repository.findByNome(categoriaModel.getNome());
		if(!categoriaFind.isEmpty()) {
				throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.categoria.conflict.exception",
					"A Categoria informado já existe!"
					);
		}
		
		var categoriaSaved = repository.save(categoriaModel);
		
		var categoriaLowDTO = DozerConverter.parseObject(categoriaSaved, CategoriaLowDTO.class);
		
		return categoriaLowDTO;
	}
	
	public List<CategoriaLowDTO> listAll(){
		var listCategoriaLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listCategoriaLow, CategoriaLowDTO.class);
		
		return listConverted;
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Categoria findById(Long id) {
		var categoria = repository.findById(id);
		if(categoria.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.categoria.notfound.exception",
					"O Serviço com a ID informada, não foi encontrado."
					);
		}
		return categoria.get();
	}	
}