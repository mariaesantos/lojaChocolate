package com.web.lojaChocolate.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.lojaChocolate.model.Empresa;
import com.web.lojaChocolate.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping
	public List<Empresa> get() {
		try {
			return empresaService.findAll();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping(value = { "/{id}" })
	public Empresa getEmpresa(@PathVariable("id") Long id) {
		try {
			return empresaService.find(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping(value = { "/nome/{nome}" })
	public Empresa getByNome(@PathVariable("nome") String nome) {
		try {
			return empresaService.findByNome(nome);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping(value = { "/{id}" })
	public void deleteEmpresa(@PathVariable("id") Long id) {
		try {
			empresaService.delete(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping
	public void delete() {
		try {
			empresaService.deleteAll();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PostMapping
	public Empresa save(@RequestBody Empresa empresa) {
		try {
			return empresaService.save(empresa);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PutMapping
	public Empresa updateEmpresa(@RequestParam Long id, @RequestParam String nome) {
		try {
			return empresaService.updateNome(id, nome);
		} catch (Exception e) {
			throw e;
		}
	}
}
