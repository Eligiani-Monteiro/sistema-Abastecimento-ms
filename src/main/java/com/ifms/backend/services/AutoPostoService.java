package com.ifms.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.backend.dto.AutoPostoDto;
import com.ifms.backend.entities.AutoPosto;
import com.ifms.backend.repositories.AutoPostoRepository;
import com.ifms.backend.services.exceptions.DataBaseException;
import com.ifms.backend.services.exceptions.ResourceNotFoundException;

public class AutoPostoService {
	@Autowired
	private AutoPostoRepository repository;

	@Transactional(readOnly = true)
	public List<AutoPostoDto> findAll() {
		List<AutoPosto> list = repository.findAll();
		return list.stream().map(autoPosto -> new AutoPostoDto(autoPosto)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public AutoPostoDto findById(Long id) {
		Optional<AutoPosto> obj = repository.findById(id);
		AutoPosto autoPosto = obj
				.orElseThrow(() -> new ResourceNotFoundException("O Auto Posto requerido não foi localizado"));
		return new AutoPostoDto(autoPosto);
	}

	@Transactional
	public AutoPostoDto insert(AutoPostoDto dto) {
		AutoPosto entity = new AutoPosto();
		entity.setNomeFantasia(dto.getNomeFantasia());
		entity.setTelefone(dto.getTelefone());
		entity.setEmail(dto.getEmail());
		entity.setCnpj(dto.getCnpj());
		entity.setEndereco(dto.getEndereco());
		entity = repository.save(entity);
		return new AutoPostoDto(entity);
	}

	@Transactional
	public AutoPostoDto update(Long id, AutoPostoDto dto) {
		try {
			AutoPosto entity = repository.getOne(id);
			entity.setNomeFantasia(dto.getNomeFantasia());
			entity.setTelefone(dto.getTelefone());
			entity.setEmail(dto.getEmail());
			entity.setCnpj(dto.getCnpj());
			entity.setEndereco(dto.getEndereco());
			entity = repository.save(entity);
			return new AutoPostoDto(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id do auto posto não foi encontrado");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível deletar, id do auto posto não foi encontrado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar o auto posto pois está sendo utilizado");
		}
	}

}
