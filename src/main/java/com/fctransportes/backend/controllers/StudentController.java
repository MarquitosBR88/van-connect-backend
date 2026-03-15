package com.fctransportes.backend.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import com.fctransportes.backend.entities.dto.StudentDTO;
import com.fctransportes.backend.entities.enums.Turno;
import com.fctransportes.backend.services.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() {
        List<Student> list = service.findAll();
        List<StudentDTO> listDto = list.stream().map(StudentDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
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
    public ResponseEntity<List<StudentDTO>> searchByName(@RequestParam String nome) {
        List<Student> list = service.searchByName(nome);
        List<StudentDTO> listDto = list.stream().map(StudentDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
    
    @GetMapping(value = "/search/turno")
    public ResponseEntity<List<StudentDTO>> searchByTurno(@RequestParam Turno turno) {
        List<Student> list = service.searchByTurno(turno);
        List<StudentDTO> listDto = list.stream().map(StudentDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/search/faculdade")
    public ResponseEntity<List<StudentDTO>> searchByFaculdade(@RequestParam String faculdade) {
        List<Student> list = service.searchByFaculdade(faculdade);
        List<StudentDTO> listDto = list.stream().map(StudentDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/search/bairro")
    public ResponseEntity<List<StudentDTO>> searchByBairro(@RequestParam String bairro) {
        List<Student> list = service.searchByBairro(bairro);
        List<StudentDTO> listDto = list.stream().map(StudentDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
    
}
