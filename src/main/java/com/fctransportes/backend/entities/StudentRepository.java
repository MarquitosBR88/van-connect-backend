package com.fctransportes.backend.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fctransportes.backend.entities.enums.Turno;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {   
    List<Student> findByNomeContainingIgnoreCase(String nome);
    List<Student> findByTurno(Turno turno);
    List<Student> findByFaculdadeContainingIgnoreCase(String faculdade);
    List<Student> findByBairroContainingIgnoreCase(String bairro);
}
