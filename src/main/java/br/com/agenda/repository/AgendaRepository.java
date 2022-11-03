package br.com.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda.model.Cliente;


@Repository
public interface AgendaRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findBynomeCliente(String nomeCliente);
	
}
