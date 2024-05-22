package br.edu.unichristus.listaservice.colaborador.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.listaservice.colaborador.data.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long > {
	
	public Optional<Colaborador> findByLogin(String login);

}
