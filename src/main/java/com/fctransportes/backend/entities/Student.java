package com.fctransportes.backend.entities;

import com.fctransportes.backend.entities.enums.Turno;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private String bairro;
    private String faculdade;
    private Turno turno;
    private Integer ordemRota;

    public Student(String nome, String telefone, String endereco, String bairro, String faculdade, Turno turno, Integer ordemRota) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.bairro = bairro;
        this.faculdade = faculdade;
        this.turno = turno;
        this.ordemRota = ordemRota;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(String faculdade) {
        this.faculdade = faculdade;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Integer getOrdemRota() {
        return ordemRota;
    }

    public void setOrdemRota(Integer ordemRota) {
        this.ordemRota = ordemRota;
    }

    @Override
    public String toString() {
        return getNome() + " - Bairro " + getBairro() + " - " + getTurno();
    }

    
}
