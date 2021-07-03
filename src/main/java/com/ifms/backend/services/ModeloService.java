package com.ifms.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.backend.dto.ModeloDto;
import com.ifms.backend.entities.Modelo;
import com.ifms.backend.repositories.ModeloRepository;
import com.ifms.backend.services.exceptions.DataBaseException;
import com.ifms.backend.services.exceptions.ResourceNotFoundException;

public class ModeloService {

	@Autowired
	private ModeloRepository repository;
	

	@Transactional(readOnly = true)
	public List<ModeloDto> findAll() {
		List<Modelo> list = repository.findAll();
		return list.stream().map(modelo -> new ModeloDto(modelo)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ModeloDto findById(Long id) {
		Optional<Modelo> obj = repository.findById(id);
		Modelo modelo = obj
				.orElseThrow(() -> new ResourceNotFoundException("A lotação solicitada não foi encontrado"));
		return new ModeloDto(modelo);
	}
	@Transactional
	public ModeloDto insert(ModeloDto dto) {
		Modelo entity = new Modelo();
		entity.setDescricao(dto.getDescricao());
		return new ModeloDto(entity);
	}

	@Transactional
	public ModeloDto update(Long id, ModeloDto dto) {
		try {
			Modelo entity = repository.getOne(id);
			entity.setDescricao(dto.getDescricao());
			entity.setMarca(dto.getMarca());
			return new ModeloDto(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id da Marca solicitada não foi localizada");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível deletar, id da marca não foi localizada");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar pois está em uso");
		}
	}
}
