package com.ifms.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.backend.dto.CidadeDto;
import com.ifms.backend.dto.EstadoDto;
import com.ifms.backend.entities.Cidade;
import com.ifms.backend.repositories.CidadeRepository;
import com.ifms.backend.services.exceptions.DataBaseException;
import com.ifms.backend.services.exceptions.ResourceNotFoundException;

public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;

	@Transactional(readOnly = true)
	public List<CidadeDto> findAll() {
		List<Cidade> list = repository.findAll();
		return list.stream().map(cidade -> new CidadeDto(cidade)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public CidadeDto findById(Long id) {
		Optional<Cidade> obj = repository.findById(id);
		Cidade cidade = obj
				.orElseThrow(() -> new ResourceNotFoundException("A cidade solicitada não foi encontrado"));
		return new CidadeDto(cidade);
	}

	@Transactional
	public CidadeDto insert(CidadeDto dto) {
		Cidade entity = new Cidade();
		entity.setNome(dto.getNome());
		return new CidadeDto(entity);
	}

	@Transactional
	public CidadeDto update(Long id, CidadeDto dto) {
		try {
			Cidade entity = repository.getOne(id);
			entity.setNome(dto.getNome());
			entity.setEstado(dto.getEstado());
			entity = repository.save(entity);
			return new CidadeDto(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id de cidade requerido não foi encontrado");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível deletar, id da cidade não foi encontrado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar a cidade pois está sendo utilizado");
		}

}
}