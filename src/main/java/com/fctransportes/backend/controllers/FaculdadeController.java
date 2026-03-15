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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fctransportes.backend.entities.Faculdade;
import com.fctransportes.backend.entities.dto.FaculdadeDTO;
import com.fctransportes.backend.services.FaculdadeService;

@RestController
@RequestMapping(value = "/faculdades")
public class FaculdadeController {

    @Autowired
    private FaculdadeService service;

    @GetMapping
    public ResponseEntity<List<FaculdadeDTO>> findAll() {
        List<Faculdade> list = service.findAll();
        List<FaculdadeDTO> listDto = list.stream().map(FaculdadeDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Faculdade> insert(@RequestBody Faculdade obj) {
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
    public ResponseEntity<Faculdade> update(@PathVariable Integer id, @RequestBody Faculdade obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
      
}
