package com.github.eduardoshibukawa.totvsagro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String cidade;

	@Length(max = 2, min = 2)
	@Column(nullable = false)
	private String uf;

	@Column
	private String logradouro;

	public Endereco() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Long getId() {
		return id;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUF() {
		return uf;
	}

	public String getLogradouro() {
		return logradouro;
	}
}
