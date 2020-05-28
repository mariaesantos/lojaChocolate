package com.web.lojaChocolate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.lojaChocolate.model.Marca;
import com.web.lojaChocolate.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	public List<Marca> findAll() {
		return marcaRepository.findAll();
	}
	
	public Marca find(Long id) {
		Optional<Marca> marca = marcaRepository.findById(id);
		if(marca.isPresent()) {
			return marca.get();
		}
				
		return null;
	}
	
	public Marca findByNome(String nome) {
		return marcaRepository.findByNome(nome);
	}
	
	public void delete(Long id) {
		marcaRepository.deleteById(id);
	}
	
	public void deleteAll() {
		marcaRepository.deleteAll();
	}
	
	public Marca save(Marca marca) {
		return marcaRepository.save(marca);
	}
	
	public Marca updateNome(Long idMarca, String nome) {
		Marca marca = find(idMarca);
		marca.setNome(nome);
		
		return marcaRepository.save(marca);
	}
}
