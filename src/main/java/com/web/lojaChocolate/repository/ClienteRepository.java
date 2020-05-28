package com.web.lojaChocolate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.lojaChocolate.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	public List<Cliente> findByNome(String nome);
	
	public Cliente findByUsuario(String usuario);
}
