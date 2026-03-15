package com.fctransportes.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fctransportes.backend.entities.Faculdade;
import com.fctransportes.backend.repositories.FaculdadeRepository;

@Service
public class FaculdadeService {
    @Autowired
    private FaculdadeRepository repository;

    public List<Faculdade> findAll() {
        return repository.findAll();
    }

    public Faculdade insert(Faculdade faculdade) {
        return repository.save(faculdade);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Faculdade update(Integer id, Faculdade obj) {
        Faculdade entity = repository.getReferenceById(id);
        entity.setNome(obj.getNome());
        return repository.save(entity);
    }

}
