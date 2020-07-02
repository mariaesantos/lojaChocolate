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

import com.web.lojaChocolate.dto.ChocolateDTO;
import com.web.lojaChocolate.mapper.ChocolateMapper;
import com.web.lojaChocolate.model.Chocolate;
import com.web.lojaChocolate.service.ChocolateService;

@RestController
@RequestMapping("/chocolate")
public class ChocolateController {
	
	@Autowired
	private ChocolateService chocolateService;
	
	@Autowired
	private ChocolateMapper chocolateMapper;
	
	@GetMapping
	public List<ChocolateDTO> get() {
		try {
			return chocolateMapper.domainToDtoList(chocolateService.findAll());
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping(value = { "/{id}" })
	public Chocolate getChocolate(@PathVariable("id") Long id) {
		try {
			return chocolateService.find(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping(value = { "/nome/{nome}" })
	public Chocolate getByNome(@PathVariable("nome") String nome) {
		try {
			return chocolateService.findByNome(nome);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping(value = { "/marca/{marcaId}" })
	public List<Chocolate> getByMarca(@PathVariable("marcaId") Long marcaId) {
		try {
			return chocolateService.findAllByMarcaId(marcaId);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping(value = { "/tipo/{tipoId}" })
	public List<Chocolate> getByTipo(@PathVariable("tipoId") Long tipoId) {
		try {
			return chocolateService.findAllByTipoId(tipoId);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping(value = { "/{id}" })
	public void deleteChocolate(@PathVariable("id") Long id) {
		try {
			chocolateService.delete(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping
	public void deleteAll() {
		try {
			chocolateService.deleteAll();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PostMapping
	public Chocolate saveChocolate(@RequestBody Chocolate chocolate) {
		try {
			return chocolateService.save(chocolate);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PutMapping(value = "/updateDescricao")
	public Chocolate updateChocolate(@RequestParam Long id, @RequestParam String descricao) {
		try {
			return chocolateService.updateDescricao(id, descricao);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PutMapping(value = "/updatePreco")
	public Chocolate updateChocolate(@RequestParam Long id, @RequestParam Double preco) {
		try {
			return chocolateService.updatePreco(id, preco);
		} catch (Exception e) {
			throw e;
		}
	}
	
}
