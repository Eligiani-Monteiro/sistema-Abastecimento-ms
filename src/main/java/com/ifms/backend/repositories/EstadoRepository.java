package com.ifms.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.backend.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}


