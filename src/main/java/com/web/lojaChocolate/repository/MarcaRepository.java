package com.web.lojaChocolate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.lojaChocolate.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
