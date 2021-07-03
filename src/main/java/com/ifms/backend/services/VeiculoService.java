package com.ifms.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.backend.dto.VeiculoDto;
import com.ifms.backend.entities.Veiculo;
import com.ifms.backend.repositories.VeiculoRepository;
import com.ifms.backend.services.exceptions.DataBaseException;
import com.ifms.backend.services.exceptions.ResourceNotFoundException;

public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repository;
	

	@Transactional(readOnly = true)
	public List<VeiculoDto> findAll() {
		List<Veiculo> list = repository.findAll();
		return list.stream().map(veiculo -> new VeiculoDto(veiculo)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public VeiculoDto findById(Long id) {
		Optional<Veiculo> obj = repository.findById(id);
		Veiculo veiculo = obj
				.orElseThrow(() -> new ResourceNotFoundException("O veículo solicitada não foi encontrado"));
		return new VeiculoDto(veiculo);
	}
	@Transactional
	public VeiculoDto insert(VeiculoDto dto) {
		Veiculo entity = new Veiculo();
		entity.setAno(dto.getAno());
		entity.setPlaca(dto.getPlaca());
		entity.setRenavan(dto.getRenavan());
		entity.setPatrimonio(dto.getPatrimonio());
		entity.setChassi(dto.getChassi());
		entity.setVersao(dto.getVersao());
		entity.setCapacidadeTanque(dto.getCapacidadeTanque());
		entity.setTipoCombustivel(dto.getTipoCombustivel());
		return new VeiculoDto(entity);
	}

	@Transactional
	public VeiculoDto update(Long id, VeiculoDto dto) {
		try {
			Veiculo entity = repository.getOne(id);
			entity.setAno(dto.getAno());
			entity.setPlaca(dto.getPlaca());
			entity.setRenavan(dto.getRenavan());
			entity.setPatrimonio(dto.getPatrimonio());
			entity.setChassi(dto.getChassi());
			entity.setVersao(dto.getVersao());
			entity.setCapacidadeTanque(dto.getCapacidadeTanque());
			entity.setTipoCombustivel(dto.getTipoCombustivel());
			return new VeiculoDto(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id do veículo solicitado não foi localizado");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível deletar, id do veículo não foi localizado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível deletar pois está em uso");
		}
	}

}
