package com.web.lojaChocolate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.lojaChocolate.model.Empresa;
import com.web.lojaChocolate.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}
	
	public Empresa find(Long idEmpresa) {
		Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
		if(empresa.isPresent()) {
			return empresa.get();
		}
		
		return null;
	}
	
	public Empresa findByNome(String nome) {
		return empresaRepository.findByNome(nome);
	}
	
	public void delete(Long idEmpresa) {
		empresaRepository.deleteById(idEmpresa);
	}
	
	public void deleteAll() {
		empresaRepository.deleteAll();
	}
	
	public Empresa save(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	public Empresa updateNome(Long idEmpresa, String nome) {
		Empresa empresa = find(idEmpresa);
		empresa.setNome(nome);
		
		return empresaRepository.save(empresa);
	}
}
