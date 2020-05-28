package com.web.lojaChocolate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.lojaChocolate.model.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long>{
	
	public Tipo findByNome(String nome);
}
