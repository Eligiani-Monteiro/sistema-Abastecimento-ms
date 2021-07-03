package com.ifms.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.backend.dto.EstadoDto;
import com.ifms.backend.entities.Estado;
import com.ifms.backend.repositories.EstadoRepository;
import com.ifms.backend.services.exceptions.DataBaseException;
import com.ifms.backend.services.exceptions.ResourceNotFoundException;

public class EstadoService {
	
	@Autowired
	private EstadoRepository repository;
	

	@Transactional(readOnly = true)
	public List<EstadoDto> findAll() {
		List<Estado> list = repository.findAll();
		return list.stream().map(estado -> new EstadoDto(estado)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public EstadoDto findById(Long id) {
		Optional<Estado> obj = repository.findById(id);
		Estado estado = obj
				.orElseThrow(() -> new ResourceNotFoundException("A cidade solicitada não foi localizado"));
		return new EstadoDto(estado);
	}
	@Transactional
	public EstadoDto insert(EstadoDto dto) {
		Estado entity = new Estado();
		entity.setUf(dto.getUf());
		return new EstadoDto(entity);
	}

	@Transactional
	public EstadoDto update(Long id, EstadoDto dto) {
		try {
			Estado entity = repository.getOne(id);
			entity.setUf(dto.getUf());
			entity = repository.save(entity);
			return new EstadoDto(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id do estado solicitado não foi encontrado");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível deletar, id do estado não foi encontrado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar pois está sendo utilizado");
		}

}
}