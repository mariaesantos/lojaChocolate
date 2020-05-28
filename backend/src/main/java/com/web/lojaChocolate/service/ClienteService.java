package com.web.lojaChocolate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.lojaChocolate.model.Cliente;
import com.web.lojaChocolate.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	public Cliente find(Long idCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		if(cliente.isPresent()) {
			return cliente.get();
		}
		
		return null;
	}
	
	public List<Cliente> findByNome(String nome) {
		return clienteRepository.findByNome(nome);
	}
	
	public Cliente findByUsuario(String usuario) {
		return clienteRepository.findByUsuario(usuario);
	}
	
	public void delete(Long idCliente) {
		clienteRepository.deleteById(idCliente);
	}
	
	public void deleteAll() {
		clienteRepository.deleteAll();
	}
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente updateNome(Long idCliente, String nome) {
		Cliente cliente = find(idCliente);
		cliente.setNome(nome);
		
		return clienteRepository.save(cliente);
	}
	
	public Cliente updateSenha(Long idCliente, String senha) {
		Cliente cliente = find(idCliente);
		cliente.setSenha(senha);
		
		return clienteRepository.save(cliente);
	}
}
