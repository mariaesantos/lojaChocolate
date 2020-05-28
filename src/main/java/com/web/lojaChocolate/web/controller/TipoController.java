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

import com.web.lojaChocolate.model.Tipo;
import com.web.lojaChocolate.service.TipoService;

@RestController
@RequestMapping("/tipo")
public class TipoController {
	
	@Autowired
	private TipoService tipoService;
	
	@GetMapping
	public List<Tipo> get() {
		try {
			return tipoService.findAll();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping(value = { "/{id}" })
	public Tipo getTipo(@PathVariable("id") Long id) {
		try {
			return tipoService.find(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping(value = { "/nome/{nome}" })
	public Tipo getByNome(@PathVariable("nome") String nome) {
		try {
			return tipoService.findByNome(nome);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping(value = { "/{id}" })
	public void deleteTipo(@PathVariable("id") Long id) {
		try {
			tipoService.delete(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping
	public void deleteAll() {
		try {
			tipoService.deleteAll();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PostMapping
	public Tipo saveTipo(@RequestBody Tipo tipo) {
		try {
			return tipoService.save(tipo);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PutMapping
	public Tipo updateTipo(@RequestParam Long id, @RequestParam String nome) {
		try {
			return tipoService.updateNome(id, nome);
		} catch (Exception e) {
			throw e;
		}
	}
	
}
