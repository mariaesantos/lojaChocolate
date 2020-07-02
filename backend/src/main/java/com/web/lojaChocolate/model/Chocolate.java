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
public class Chocolate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome", length = 48)
	@NotNull
	private String nome;
	
	@Column(name = "descricao", length = 200)
	@NotNull
	private String descricao;
	
	@Column(name = "preco")
	@NotNull
	private Double preco;
	
	@Column(name = "marcaId")
	@NotNull
	private Long marcaId;
	
	@Column(name = "tipoId")
	@NotNull
	private Long tipoId;
	
	@Column(name = "tamanho")
	@NotNull
	private Long tamanho;
	
}
