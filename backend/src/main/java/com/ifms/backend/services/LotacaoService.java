package com.ifms.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.backend.dto.LotacaoDto;
import com.ifms.backend.entities.Lotacao;
import com.ifms.backend.repositories.LotacaoRepository;
import com.ifms.backend.services.exceptions.DataBaseException;
import com.ifms.backend.services.exceptions.ResourceNotFoundException;

public class LotacaoService {
	
	@Autowired
	private LotacaoRepository repository;
	

	@Transactional(readOnly = true)
	public List<LotacaoDto> findAll() {
		List<Lotacao> list = repository.findAll();
		return list.stream().map(lotacao -> new LotacaoDto(lotacao)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public LotacaoDto findById(Long id) {
		Optional<Lotacao> obj = repository.findById(id);
		Lotacao lotacao = obj
				.orElseThrow(() -> new ResourceNotFoundException("A lotação solicitada não foi localizado"));
		return new LotacaoDto(lotacao);
	}
	@Transactional
	public LotacaoDto insert(LotacaoDto dto) {
		Lotacao entity = new Lotacao();
		entity.setDescricao(dto.getDescricao());
		entity.setEndereco(dto.getEndereco());
		entity.setEmail(dto.getEmail());
		entity.setSite(dto.getSite());
		entity.setTelefone(dto.getTelefone());
		return new LotacaoDto(entity);
	}

	@Transactional
	public LotacaoDto update(Long id, LotacaoDto dto) {
		try {
			Lotacao entity = repository.getOne(id);
			entity.setDescricao(dto.getDescricao());
			entity.setEndereco(dto.getEndereco());
			entity.setEmail(dto.getEmail());
			entity.setSite(dto.getSite());
			entity.setTelefone(dto.getTelefone());
			return new LotacaoDto(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id da lotacao solicitada não foi encontrado");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível deletar, id da lotação não foi encontrado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar pois está sendo utilizado");
		}
	}

}
