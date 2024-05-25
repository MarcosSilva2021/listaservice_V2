package br.edu.unichristus.listaservice.pagamento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.listaservice.pagamento.data.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
	
	
	public Optional<Pagamento> findByNome(String numero);

}
