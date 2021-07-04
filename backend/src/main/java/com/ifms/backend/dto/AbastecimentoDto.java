package com.ifms.backend.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.ifms.backend.entities.Abastecimento;
import com.ifms.backend.entities.Combustivel;

public class AbastecimentoDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	@CPF
	@NotBlank(message="O campo é obrigatorio")
	private long cpfMotorista;
	@NotBlank(message="O campo é obrigatorio")
	private Date dataDoAbastecimento;
	@NotBlank(message="O campo é obrigatorio")
	private String quilometragem;
	@NotBlank(message="O campo é obrigatorio")
	private Combustivel combustivel;
	@NotBlank(message="O campo é obrigatorio")
	private Integer quantidadeEmLitros;
	@NotBlank(message="O campo é obrigatorio")
	private Double valorPorLitro;
	
	
	public AbastecimentoDto() {
		
	}
	public AbastecimentoDto(long id, long cpfMotorista, Date dataDoAbastecimento, String quilometragem,
			Combustivel combustivel, Integer quantidadeEmLitros, Double valorPorLitro) {
		super();
		this.id = id;
		this.cpfMotorista = cpfMotorista;
		this.dataDoAbastecimento = dataDoAbastecimento;
		this.quilometragem = quilometragem;
		this.combustivel = combustivel;
		this.quantidadeEmLitros = quantidadeEmLitros;
		this.valorPorLitro = valorPorLitro;
	}
	
	
	
	public AbastecimentoDto(Abastecimento entity) {
		
		this.id = entity.getId();
		this.cpfMotorista = entity.getCpfMotorista();
		this.dataDoAbastecimento = entity.getDataDoAbastecimento();
		this.quilometragem = entity.getQuilometragem();
		this.combustivel = entity.getCombustivel();
		this.quantidadeEmLitros = entity.getQuantidadeEmLitros();
		this.valorPorLitro = entity.getValorPorLitro();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCpfMotorista() {
		return cpfMotorista;
	}
	public void setCpfMotorista(long cpfMotorista) {
		this.cpfMotorista = cpfMotorista;
	}
	public Date getDataDoAbastecimento() {
		return dataDoAbastecimento;
	}
	public void setDataDoAbastecimento(Date dataDoAbastecimento) {
		this.dataDoAbastecimento = dataDoAbastecimento;
	}
	public String getQuilometragem() {
		return quilometragem;
	}
	public void setQuilometragem(String quilometragem) {
		this.quilometragem = quilometragem;
	}
	public Combustivel getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	public Integer getQuantidadeEmLitros() {
		return quantidadeEmLitros;
	}
	public void setQuantidadeEmLitros(Integer quantidadeEmLitros) {
		this.quantidadeEmLitros = quantidadeEmLitros;
	}
	public Double getValorPorLitro() {
		return valorPorLitro;
	}
	public void setValorPorLitro(Double valorPorLitro) {
		this.valorPorLitro = valorPorLitro;
	}
	

}
