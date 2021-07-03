package com.ifms.backend.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.ifms.backend.entities.Estado;

public class EstadoDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	@NotBlank(message = "O campo é o obrigatório")
	private String Uf;
	
	public EstadoDto() {
		
	}
	public EstadoDto(Long id, String Uf) {
		super();
		this.id = id;
		this.Uf = Uf;
	}
	public EstadoDto(Estado entity) {
	
		this.id = entity.getId();
		this.Uf = entity.getUf();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUf() {
		return Uf;
	}
	public void setUf(String uf) {
		Uf = uf;
	} 
	
	
	

}
