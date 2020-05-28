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

import com.web.lojaChocolate.model.Marca;
import com.web.lojaChocolate.service.MarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaController {
	
	@Autowired
	private MarcaService marcaService;
	
	@GetMapping
	public List<Marca> get() {
		try {
			return marcaService.findAll();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping(value = { "/{id}" })
	public Marca getMarca(@PathVariable("id") Long id) {
		try {
			return marcaService.find(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping(value = { "/nome/{nome}" })
	public Marca getByNome(@PathVariable("nome") String nome) {
		try {
			return marcaService.findByNome(nome);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping(value = { "/{id}" })
	public void deleteMarca(@PathVariable("id") Long id) {
		try {
			marcaService.delete(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping
	public void deleteAll() {
		try {
			marcaService.deleteAll();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PostMapping
	public Marca saveMarca(@RequestBody Marca marca) {
		try {
			return marcaService.save(marca);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PutMapping
	public Marca updateNome(@RequestParam Long id, @RequestParam String nome) {
		try {
			return marcaService.updateNome(id, nome);
		} catch (Exception e) {
			throw e;
		}
	}
	
}
