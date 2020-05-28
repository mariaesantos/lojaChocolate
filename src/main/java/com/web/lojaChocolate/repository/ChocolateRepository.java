package com.web.lojaChocolate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.lojaChocolate.model.Chocolate;

@Repository
public interface ChocolateRepository extends JpaRepository<Chocolate, Long>{
	
	public List<Chocolate> findAllByMarcaId(Long marcaId);
	
	public List<Chocolate> findAllByTipoId(Long tipoId);
	
	public Chocolate findByNome(String nome);
}
