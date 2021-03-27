package com.github.eduardoshibukawa.totvsagro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "fazenda", uniqueConstraints = @UniqueConstraint(columnNames = "CNPJ", name = "cnpj_uk"))
public class Fazenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Length(max = 200, message = "O campo deve possuir pelo menos 200 caracteres")
	@Column
	private String nome;

	@CNPJ
	@Column(unique = true)	
	private String cnpj;
		
	@OneToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	public Fazenda() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
}
