package com.ifms.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.backend.entities.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

}


