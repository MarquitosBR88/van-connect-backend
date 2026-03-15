package com.fctransportes.backend.entities.dto;

import com.fctransportes.backend.entities.Student;
import com.fctransportes.backend.entities.enums.Turno;

public class StudentDTO {
    private Integer id;
    private String nome;
    private String telefone;
    private String endereco;
    private String bairro;
    private String faculdade;
    private Turno turno;
    private Integer ordemRota;

    public StudentDTO() {}

    public StudentDTO(Student entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.telefone = entity.getTelefone();
        this.endereco = entity.getEndereco();
        this.bairro = entity.getBairro();
        this.faculdade = (entity.getFaculdade() != null) ? entity.getFaculdade().getNome() : null;
        this.turno = entity.getTurno();
        this.ordemRota = entity.getOrdemRota();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public String getFaculdade() {
        return faculdade;
    }

    public Turno getTurno() {
        return turno;
    }

    public Integer getOrdemRota() {
        return ordemRota;
    }
}
