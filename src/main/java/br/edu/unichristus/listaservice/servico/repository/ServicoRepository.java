package br.edu.unichristus.listaservice.servico.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.listaservice.servico.data.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{
	
	
	//public Optional<Servico> findByNome(String nome);

}
