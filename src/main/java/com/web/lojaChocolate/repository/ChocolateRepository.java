package com.web.lojaChocolate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.lojaChocolate.model.Chocolate;

@Repository
public interface ChocolateRepository extends JpaRepository<Chocolate, Long>{
	
}
