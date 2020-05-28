package com.web.lojaChocolate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.lojaChocolate.model.Tipo;
import com.web.lojaChocolate.repository.TipoRepository;

@Service
public class TipoService {
	
	@Autowired
	private TipoRepository tipoRepository;
	
	public List<Tipo> findAll() {
		return tipoRepository.findAll();
	}
	
	public Tipo find(Long idTipo) {
		Optional<Tipo> tipo = tipoRepository.findById(idTipo);
		if(tipo.isPresent()) {
			return tipo.get();
		}
		
		return null;
	}
	
	public Tipo findByNome(String nome) {
		return tipoRepository.findByNome(nome);
	}
	
	public void delete(Long idTipo) {
		tipoRepository.deleteById(idTipo);
	}
	
	public void deleteAll() {
		tipoRepository.deleteAll();
	}
	
	public Tipo save(Tipo tipo) {
		return tipoRepository.save(tipo);
	}
	
	public Tipo updateNome(Long idTipo, String nome) {
		Tipo tipo = find(idTipo);
		tipo.setNome(nome);
		tipoRepository.save(tipo);

		return tipo;
	}
}
