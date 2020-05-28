package com.web.lojaChocolate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.lojaChocolate.model.Chocolate;
import com.web.lojaChocolate.repository.ChocolateRepository;

@Service
public class ChocolateService {
	
	@Autowired
	private ChocolateRepository chocolateRepository;
	
	public List<Chocolate> findAll() {
		return chocolateRepository.findAll();
	}
	
	public Chocolate find(Long id) {
		Optional<Chocolate> chocolate = chocolateRepository.findById(id);
		if(chocolate.isPresent()) {
			return chocolate.get();
		}
		
		return null;
	}
	
	public List<Chocolate> findAllByMarcaId(Long marcaId) {
		return chocolateRepository.findAllByMarcaId(marcaId);
	}
	
	public List<Chocolate> findAllByTipoId(Long tipoId) {
		return chocolateRepository.findAllByTipoId(tipoId);
	}
	
	public Chocolate findByNome(String nome) {
		return chocolateRepository.findByNome(nome);
	}
	
	public Chocolate save(Chocolate chocolate) {
		return chocolateRepository.save(chocolate);
	}
	
	public void delete(Long idChocolate) {
		chocolateRepository.deleteById(idChocolate);
	}
	
	public void deleteAll() {
		chocolateRepository.deleteAll();
	}
	
	public Chocolate updatePreco(Long idChocolate, Double preco) {
		Chocolate chocolate = find(idChocolate);
		chocolate.setPreco(preco);
		chocolateRepository.save(chocolate);
		
		return chocolate;
	}
	
	public Chocolate updateDescricao(Long idChocolate, String descricao) {
		Chocolate chocolate = find(idChocolate);
		chocolate.setDescricao(descricao);
		
		return chocolateRepository.save(chocolate);
	}
}
