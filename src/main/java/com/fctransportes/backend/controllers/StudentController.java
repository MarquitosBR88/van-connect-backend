package com.fctransportes.backend.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fctransportes.backend.entities.Student;
import com.fctransportes.backend.entities.enums.Turno;
import com.fctransportes.backend.services.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        List<Student> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody Student obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Student> update(@PathVariable Integer id, @RequestBody Student obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @GetMapping(value = "/search")
    public ResponseEntity<List<Student>> searchByName(@RequestParam String nome) {
        List<Student> obj = service.searchByName(nome);
        return ResponseEntity.ok().body(obj);
    }

    public ResponseEntity<List<Student>> searchByTurno(@RequestParam Turno turno) {
        List<Student> obj = service.searchByTurno(turno);
        return ResponseEntity.ok().body(obj);
    }

    public ResponseEntity<List<Student>> searchByFaculdade(@RequestParam String faculdade) {
        List<Student> obj = service.searchByFaculdade(faculdade);
        return ResponseEntity.ok().body(obj);
    }

    public ResponseEntity<List<Student>> searchByBairro(@RequestParam String bairro) {
        List<Student> obj = service.searchByFaculdade(bairro);
        return ResponseEntity.ok().body(obj);
    }
    
}
