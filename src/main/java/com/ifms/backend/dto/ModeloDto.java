package com.ifms.backend.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.ifms.backend.entities.Marca;
import com.ifms.backend.entities.Modelo;

public class ModeloDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	@NotBlank(message = "O campo é o obrigatório")
	private String descricao;
	@NotBlank(message = "O campo é o obrigatório")
	private Marca marca;
	
	
	public ModeloDto() {}
	public ModeloDto(Long id, String descricao,Marca marca) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	public ModeloDto(Modelo entity) {
		
		this.id =entity.getId();
		this.descricao = entity.getDescricao();
		this.marca = entity.getMarca();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	
}
