package com.fctransportes.backend.entities.dto;

import com.fctransportes.backend.entities.Faculdade;

public class FaculdadeDTO {
    private Integer id;
    private String nome;

    public FaculdadeDTO() {}

    public FaculdadeDTO(Faculdade entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
