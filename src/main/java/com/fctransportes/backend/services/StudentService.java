package com.fctransportes.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fctransportes.backend.entities.Student;
import com.fctransportes.backend.entities.enums.Turno;
import com.fctransportes.backend.repositories.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student insert(Student student) {
        return repository.save(student);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Student update(Integer id, Student obj) {
        Student entity = repository.getReferenceById(id);
        entity.setNome(obj.getNome());
        entity.setTelefone(obj.getTelefone());
        entity.setEndereco(obj.getEndereco());
        entity.setBairro(obj.getBairro());
        entity.setFaculdade(obj.getFaculdade());
        entity.setTurno(obj.getTurno());
        entity.setOrdemRota(obj.getOrdemRota());
        return repository.save(entity);
    }

    public List<Student> searchByName(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Student> searchByTurno(Turno turno) {
        return repository.findByTurno(turno);
    }

    public List<Student> searchByFaculdade(String faculdade) {
        return repository.findByFaculdadeContainingIgnoreCase(faculdade);
    }

    public List<Student> searchByBairro(String bairro) {
        return repository.findByBairroContainingIgnoreCase(bairro);
    }
}
