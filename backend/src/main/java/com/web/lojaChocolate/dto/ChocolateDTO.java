package com.web.lojaChocolate.dto;

import lombok.Data;

@Data
public class ChocolateDTO {
	private long id;
	
	private String nome;
	
	private String descricao;
	
	private Double preco;
	
	private String marca;
	
	private String tipo;
	
	private Long tamanho;
	
	public ChocolateDTO id(Long id) {
		this.id = id;
		return this;
	}
	
	public ChocolateDTO nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public ChocolateDTO descricao(String descricao) {
		this.descricao = descricao;
		return this;
	}
	
	public ChocolateDTO preco(Double preco) {
		this.preco = preco;
		return this;
	}
	
	public ChocolateDTO marca(String marca) {
		this.marca = marca;
		return this;
	}
	
	public ChocolateDTO tipo(String tipo) {
		this.tipo = tipo;
		return this;
	}
	
	public ChocolateDTO tamanho(Long tamanho) {
		this.tamanho = tamanho;
		return this;
	}
	
}
