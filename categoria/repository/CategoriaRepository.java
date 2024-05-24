package br.edu.unichristus.listaservice.categoria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.listaservice.categoria.data.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	
	public Optional<Categoria> findByNome(String nome);

}
