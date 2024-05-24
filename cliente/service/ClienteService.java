package br.edu.unichristus.listaservice.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.listaservice.cliente.data.dto.ClienteDTO;
import br.edu.unichristus.listaservice.cliente.data.dto.ClienteLowDTO;
import br.edu.unichristus.listaservice.cliente.data.model.Cliente;
import br.edu.unichristus.listaservice.cliente.dozer.DozerConverter;
import br.edu.unichristus.listaservice.cliente.exception.CommonsException;
import br.edu.unichristus.listaservice.cliente.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
    private ClienteRepository repository;
	
	public ClienteLowDTO save(ClienteDTO clienteDTO) {
		var clienteModel = DozerConverter.parseObject(clienteDTO, Cliente.class);
		if(clienteModel.getNome().length() > 150) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.user.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}
		var userFind = repository.findByLogin(clienteModel.getLogin());
		if(!userFind.isEmpty()) {
			throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.user.conflict.exception",
					"O Login informado já existe!"
					);
		}
		
		
		var userSaved = repository.save(clienteModel);
		
		var userLowDTO = DozerConverter.parseObject(userSaved, ClienteLowDTO.class);
		
		return userLowDTO;
	}
	
	public List<ClienteLowDTO> listAll(){
		var listUserLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listUserLow, ClienteLowDTO.class);
		
		return listConverted;
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Cliente  findById(Long id) {
		var cliente = repository.findById(id);
		if(cliente.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.user.notfound.exception",
					"O usuário com a ID informada, não foi encontrado."
					);
		}
		return cliente.get();
	}

   

}
