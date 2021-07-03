package com.ifms.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.backend.dto.MarcaDto;
import com.ifms.backend.entities.Marca;
import com.ifms.backend.repositories.MarcaRepository;
import com.ifms.backend.services.exceptions.DataBaseException;
import com.ifms.backend.services.exceptions.ResourceNotFoundException;

public class MarcaService {
	
	@Autowired
	private MarcaRepository repository;
	

	@Transactional(readOnly = true)
	public List<MarcaDto> findAll() {
		List<Marca> list = repository.findAll();
		return list.stream().map(marca -> new MarcaDto(marca)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public MarcaDto findById(Long id) {
		Optional<Marca> obj = repository.findById(id);
		Marca marca = obj
				.orElseThrow(() -> new ResourceNotFoundException("A marca solicitada não foi encontrada"));
		return new MarcaDto(marca);
	}
	@Transactional
	public MarcaDto insert(MarcaDto dto) {
		Marca entity = new Marca();
		entity.setDescricao(dto.getDescricao());
		return new MarcaDto(entity);
	}

	@Transactional
	public MarcaDto update(Long id, MarcaDto dto) {
		try {
			Marca entity = repository.getOne(id);
			entity.setDescricao(dto.getDescricao());
			return new MarcaDto(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id da marca solicitada não foi encontrada");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível deletar, id da marca não foi encontrada");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar pois está sendo utilizado");
		}
	}

}
