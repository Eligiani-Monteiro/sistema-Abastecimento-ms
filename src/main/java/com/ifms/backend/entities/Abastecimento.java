package com.ifms.backend.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
	@Entity
public class Abastecimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long cpfMotorista;
	private Date dataDoAbastecimento;
	private String quilometragem;
	private Combustivel combustivel;
	private Integer quantidadeEmLitros;
	private Double valorPorLitro;

	@ManyToOne
	@JoinColumn(name = "fk_veiculo")
	private Veiculo veiculo;

	@ManyToOne
	@JoinColumn(name = "fk_autoposto")
	private AutoPosto autoposto;

	public Abastecimento() {
	}

	public Abastecimento(long id, long cpfMotorista, Date dataDoAbastecimento, String quilometragem,
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
	

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public AutoPosto getAutoposto() {
		return autoposto;
	}

	public void setAutoposto(AutoPosto autoposto) {
		this.autoposto = autoposto;
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
		Abastecimento other = (Abastecimento) obj;
		if (id != other.id)
			return false;
		return true;
	}

}