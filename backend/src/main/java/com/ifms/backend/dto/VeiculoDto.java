package com.ifms.backend.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.ifms.backend.entities.Combustivel;
import com.ifms.backend.entities.Veiculo;

public class VeiculoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long id;
	@Size(min = 4, max = 4,message = " O tamanho mínimo é 4 e o tamanho máximo é 4 caracteres")
	@NotBlank(message="O campo é obrigatorio")
	private Integer ano;
	@NotBlank(message="O campo é obrigatorio")
	private String renavan;
	@NotBlank(message="O campo é obrigatorio")
	private String patrimonio;
	@NotBlank(message="O campo é obrigatorio")
	private String chassi;
	@NotBlank(message="O campo é obrigatorio")
	private String versao;
	@NotBlank(message="O campo é obrigatorio")
	private String placa;
	@NotBlank(message="O campo é obrigatorio")
	private String capacidadeTanque;
	@NotBlank(message="O campo é obrigatorio")
	private Combustivel tipoCombustivel;
	
	public VeiculoDto() {
		
	}
	public VeiculoDto(long id, Integer ano, String renavan, String patrimonio, String chassi, String versao,  
			String capacidadeTanque, String placa, Combustivel tipoCombustivel) {
		super();
		this.id = id;
		this.ano = ano;
		this.renavan = renavan;
		this.patrimonio = patrimonio;
		this.chassi = chassi;
		this.versao = versao;
		this.capacidadeTanque = capacidadeTanque;
		this. placa = placa;
		this.tipoCombustivel = tipoCombustivel;
	}
	public VeiculoDto(Veiculo entity) {
		
		this.id = entity.getId();
		this.ano = entity.getAno();
		this.renavan =entity.getRenavan();
		this.patrimonio = entity.getPatrimonio();
		this.chassi = entity.getChassi();
		this.versao = entity.getVersao();
		this.capacidadeTanque = entity.getCapacidadeTanque();
		this.placa = entity.getPlaca();
		this. tipoCombustivel= entity.getTipoCombustivel();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getRenavan() {
		return renavan;
	}
	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}
	public String getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getCapacidadeTanque() {
		return capacidadeTanque;
	}
	public void setCapacidadeTanque(String capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Combustivel getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(Combustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	
	
	
	
	
	

}
