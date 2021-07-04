package com.ifms.backend.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Lotacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	private String descricao;
	private String endereco;
	private String site;
	private String email;
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name = "fk_lotacao")
	private Cidade cidade;
	
	@ManyToMany
	@JoinTable( name = "tb_lotacao_veiculo", joinColumns = @JoinColumn( name = "fk_lotacao")
	,inverseJoinColumns = @JoinColumn(name = "fk_veiculo"))
	Set<Veiculo> veiculo = new HashSet<>();
	
	
	
	

	public Lotacao() {

	}

	public Lotacao(long id, String descricao, String endereco, String site, String telefone, String email) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.endereco = endereco;
		this.site = site;
		this.telefone = telefone;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Set<Veiculo> getVeiculo() {
		return veiculo;
	}
	
	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setVeiculo(Set<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Lotacao other = (Lotacao) obj;
		if (id != other.id)
			return false;
		return true;
	}

	

	

}
