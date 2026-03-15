package com.fctransportes.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fctransportes.backend.entities.Faculdade;

@Repository
public interface FaculdadeRepository extends JpaRepository<Faculdade, Integer> {

}
