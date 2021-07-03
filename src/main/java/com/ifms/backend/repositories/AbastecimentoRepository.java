package com.ifms.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.backend.entities.Abastecimento;


@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {

}


