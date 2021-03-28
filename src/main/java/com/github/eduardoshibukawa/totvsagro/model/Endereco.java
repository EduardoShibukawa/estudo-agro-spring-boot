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

	public Endereco(String cidade, String uf, String logradouro) {
		this.cidade = cidade;
		this.uf = uf;
		this.logradouro = logradouro;
	}

	public Long getId() {
		return id;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getLogradouro() {
		return logradouro;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
}
