package com.ifms.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.backend.dto.TipoDto;
import com.ifms.backend.entities.Tipo;
import com.ifms.backend.repositories.TipoRepository;
import com.ifms.backend.services.exceptions.DataBaseException;
import com.ifms.backend.services.exceptions.ResourceNotFoundException;

public class TipoService {

	@Autowired
	private TipoRepository repository;
	
	@Transactional(readOnly = true)
	public List<TipoDto> findAll() {
		List<Tipo> list = repository.findAll();
		return list.stream().map(tipo -> new TipoDto(tipo)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public TipoDto findById(Long id) {
		Optional<Tipo> obj = repository.findById(id);
		Tipo tipo = obj
				.orElseThrow(() -> new ResourceNotFoundException("A marca solicitada não foi encontrado"));
		return new TipoDto(tipo);
	}
	@Transactional
	public TipoDto insert(TipoDto dto) {
		Tipo entity = new Tipo();
		entity.setDescricao(dto.getDescricao());
		return new TipoDto(entity);
	}

	@Transactional
	public TipoDto update(Long id, TipoDto dto) {
		try {
			Tipo entity = repository.getOne(id);
			entity.setDescricao(dto.getDescricao());
			return new TipoDto(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id do tipo solicitado não foi encontrda");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível deletar, id do tipo não foi encontrada");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar pois está sendo utilizado");
		}
	}
}
