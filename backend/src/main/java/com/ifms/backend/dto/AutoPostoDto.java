package com.ifms.backend.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import com.ifms.backend.entities.AutoPosto;

public class AutoPostoDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	@Size(min = 8, max = 125,message = " O tamanho mínimo é 8 e o tamanho máximo é 125 caracteres")
	@NotBlank(message = " O campo é o obrigatório")
	private String nomeFantasia;
	@NotBlank (message = "O campo é o obrigatório")
	private String telefone;
	@Email
	private String email;
	@CNPJ
	private String cnpj;
	@NotBlank(message = "O campo é o obrigatório")
	private String endereco;
	
	public AutoPostoDto() {
		
	}
	public AutoPostoDto(long id, String nomeFantasia, String telefone, String email, String cnpj, String endereco) {
		super();
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.telefone = telefone;
		this.email = email;
		this.cnpj = cnpj;
		this.endereco = endereco;
		
	
	}
	
	public AutoPostoDto(AutoPosto entity) {
		
		this.id = entity.getId();
		this.nomeFantasia = entity.getNomeFantasia() ;
		this.telefone = entity.getTelefone();
		this.email = entity.getEmail();
		this.cnpj= entity.getCnpj();
		this.endereco = entity.getEndereco();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
}
