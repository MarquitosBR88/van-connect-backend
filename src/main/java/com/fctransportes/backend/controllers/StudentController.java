package com.fctransportes.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fctransportes.backend.entities.Student;
import com.fctransportes.backend.entities.StudentRepository;

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
}
