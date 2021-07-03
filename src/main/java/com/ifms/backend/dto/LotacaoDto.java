package com.ifms.backend.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.ifms.backend.entities.Lotacao;

public class LotacaoDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	@NotBlank(message = "O campo é o obrigatório")
	private String descricao;
	@NotBlank(message = "O campo é o obrigatório")
	private String endereco;
	@NotBlank(message = "O campo é o obrigatório")
	private String site;
	@Email
	private String email;
	@NotBlank(message = "O campo é o obrigatório")
	private String telefone;
	
	public LotacaoDto() {}
	
	public LotacaoDto(long id, String descricao, String endereco, String site, String telefone, String email) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.endereco = endereco;
		this.site = site;
		this.telefone = telefone;
		this.email= email;
		
	}

	public LotacaoDto(Lotacao entity) {
		
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.endereco = entity.getEndereco();
		this.site =entity.getSite();
		this.telefone = entity.getTelefone();
		this.email = entity.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}

