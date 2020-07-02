package com.web.lojaChocolate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome", length = 48)
	@NotNull
	private String nome;
	
	@Column(name = "usuario", length = 16)
	@NotNull
	private String usuario;
	
	@Column(name = "senha")
	@NotNull
	private String senha;
	
	@Column(name = "documento")
	@NotNull
	private String documento;
	
	@Column(name = "celular")
	@NotNull
	private String celular;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "email")
	@NotNull
	private String email;
	
	@Column(name = "endereco")
	@NotNull
	private String endereco;
	
	@Column(name = "complemento")
	private String complemento;

	@Column(name = "bairro")
	@NotNull
	private String bairro;
	
	@Column(name = "uf")
	@NotNull
	private String uf;
	
	@Column(name = "municipio")
	@NotNull
	private String municipio;
	
	@Column(name = "cep")
	@NotNull
	private String cep;
	
}
