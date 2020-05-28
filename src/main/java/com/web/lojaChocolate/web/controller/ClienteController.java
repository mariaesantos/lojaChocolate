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

import com.web.lojaChocolate.model.Cliente;
import com.web.lojaChocolate.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> get() {
		try {
			return clienteService.findAll();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping(value = { "/{id}" })
	public Cliente getCliente(@PathVariable("id") Long id) {
		try {
			return clienteService.find(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping(value = { "/nome/{nome}" })
	public List<Cliente> getByNome(@PathVariable("nome") String nome) {
		try {
			return clienteService.findByNome(nome);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping(value = { "/usuario/{usuario}" })
	public Cliente getByUsuario(@PathVariable("usuario") String usuario) {
		try {
			return clienteService.findByUsuario(usuario);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping(value = { "/{id}" })
	public void deleteCliente(@PathVariable("id") Long id) {
		try {
			clienteService.delete(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping
	public void delete() {
		try {
			clienteService.deleteAll();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PostMapping
	public Cliente saveCliente(@RequestBody Cliente cliente) {
		try {
			return clienteService.save(cliente);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PutMapping(value = "/updateNome")
	public Cliente updateNome(@RequestParam Long id, @RequestParam String nome) {
		try {
			return clienteService.updateNome(id, nome);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PutMapping(value = "/updateSenha")
	public Cliente updateSenha(@RequestParam Long id, @RequestParam String senha) {
		try {
			return clienteService.updateSenha(id, senha);
		} catch (Exception e) {
			throw e;
		}
	}
}
