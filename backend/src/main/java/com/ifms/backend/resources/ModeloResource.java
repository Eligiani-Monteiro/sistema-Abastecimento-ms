package com.ifms.backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ifms.backend.dto.ModeloDto;
import com.ifms.backend.services.ModeloService;
import java.net.URI;

public class ModeloResource {
	
	@Autowired
	private ModeloService service;

	public ResponseEntity<List<ModeloDto>> findAll() {
		List<ModeloDto> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ModeloDto> findById(@PathVariable Long id) {
		ModeloDto dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<ModeloDto> insert(@RequestBody ModeloDto dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ModeloDto> update(@PathVariable Long id, @RequestBody ModeloDto dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ModeloDto> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

}
}