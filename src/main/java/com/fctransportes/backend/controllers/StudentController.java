package com.fctransportes.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fctransportes.backend.entities.Student;
import com.fctransportes.backend.entities.StudentRepository;
import com.fctransportes.backend.entities.enums.Turno;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    // A Injeção de Dependência (O Spring traz o repository pronto pra cá)
    @Autowired
    private StudentRepository repository;

    // Método 1: GET (Buscar todos)
    // Quando alguém acessar http://localhost:8080/students, roda isso:
    @GetMapping
    public List<Student> findAll() {
        return repository.findAll();
    }

    // Método 2: POST (Salvar novo)
    // Quando o React mandar um JSON pra cá, roda isso:
    @PostMapping
    public Student insert(@RequestBody Student student) {
        return repository.save(student);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public Student update(@PathVariable Integer id, @RequestBody Student obj) {
        Student entity = repository.getReferenceById(id);
        entity.setNome(obj.getNome());
        entity.setTelefone(obj.getTelefone());
        entity.setEndereco(obj.getEndereco());
        entity.setBairro(obj.getBairro());
        entity.setFaculdade(obj.getFaculdade());
        entity.setTurno(obj.getTurno());
        return repository.save(entity);
    }

    @GetMapping(value = "/search")
    public List<Student> searchByName(@RequestParam String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping(value = "/filter/turno")
    public List<Student> searchByTurno(@RequestParam Turno turno) {
        return repository.findByTurno(turno);
    }

    @GetMapping(value = "/filter/faculdade")
    public List<Student> searchByFaculdade(@RequestParam String faculdade) {
        return repository.findByFaculdadeContainingIgnoreCase(faculdade);
    }

    @GetMapping(value = "/filter/bairro")
    public List<Student> searchByBairro(@RequestParam String bairro) {
        return repository.findByBairroContainingIgnoreCase(bairro);
    }
}
