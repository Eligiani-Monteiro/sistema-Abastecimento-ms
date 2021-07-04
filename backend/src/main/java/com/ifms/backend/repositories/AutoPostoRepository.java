package com.ifms.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.backend.entities.AutoPosto;

@Repository
public interface AutoPostoRepository extends JpaRepository<AutoPosto, Long> {

}


