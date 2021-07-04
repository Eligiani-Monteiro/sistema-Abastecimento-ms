package com.ifms.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.backend.dto.AbastecimentoDto;
import com.ifms.backend.entities.Abastecimento;
import com.ifms.backend.repositories.AbastecimentoRepository;
import com.ifms.backend.services.exceptions.DataBaseException;
import com.ifms.backend.services.exceptions.ResourceNotFoundException;
@Service
public class AbastecimentoService {
	
	@Autowired
	private AbastecimentoRepository repository;

	@Transactional(readOnly = true)
	public List<AbastecimentoDto> findAll() {
		List<Abastecimento> list = repository.findAll();
		return list.stream().map(abastecimento -> new AbastecimentoDto(abastecimento)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public AbastecimentoDto findById(Long id) {
		Optional<Abastecimento> obj = repository.findById(id);
		Abastecimento abastecimento = obj
				.orElseThrow(() -> new ResourceNotFoundException("O abastecimento requerido não foi localizado"));
		return new AbastecimentoDto(abastecimento);
	}

	@Transactional
	public AbastecimentoDto insert(AbastecimentoDto dto) {
		Abastecimento entity = new Abastecimento();
		entity.setCpfMotorista(dto.getCpfMotorista());
		entity.setDataDoAbastecimento(dto.getDataDoAbastecimento());
		entity.setQuilometragem(dto.getQuilometragem());
		entity.setCombustivel(dto.getCombustivel());
		entity.setQuantidadeEmLitros(dto.getQuantidadeEmLitros());
		entity.setValorPorLitro(dto.getValorPorLitro());
		entity = repository.save(entity);
		return new AbastecimentoDto(entity);
	}

	@Transactional
	public AbastecimentoDto update(Long id, AbastecimentoDto dto) {
		try {
			Abastecimento entity = repository.getOne(id);
			entity.setCpfMotorista(dto.getCpfMotorista());
			entity.setDataDoAbastecimento(dto.getDataDoAbastecimento());
			entity.setQuilometragem(dto.getQuilometragem());
			entity.setCombustivel(dto.getCombustivel());
			entity.setQuantidadeEmLitros(dto.getQuantidadeEmLitros());
			entity.setValorPorLitro(dto.getValorPorLitro());
			entity = repository.save(entity);
			return new AbastecimentoDto(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id do abastecimento não foi encontrado");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível deletar, id do abastecimento não foi encontrado");
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar o abastecimento pois está sendo utilizado");
		}
	}
     
     
	


}
