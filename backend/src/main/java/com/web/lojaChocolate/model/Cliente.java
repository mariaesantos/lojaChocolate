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
	
}
