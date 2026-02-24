package com.fctransportes.backend.config; // Ajuste seu pacote se necessário

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fctransportes.backend.entities.Student;
import com.fctransportes.backend.entities.StudentRepository;
import com.fctransportes.backend.entities.enums.Turno;

@Configuration // Avisa ao Spring: "Isso aqui é uma classe de configuração"
public class TestConfig implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        
        // Aqui dentro roda tudo quando o servidor sobe.
        // Vamos criar dois alunos para testar:

        // Lembra do construtor? (Nome, Telefone, Endereco, Bairro, Faculdade, Turno)
        // OBS: O ID (primeiro campo) não entra aqui porque o banco gera sozinho!

        if (studentRepository.count() == 0) {
            Student s1 = new Student(
                "Mariazinha", 
                "999998888", // O 'L' no final indica que é Long
                "Rua das Flores, 123", 
                "Centro", 
                "Unitri", 
                Turno.MANHA,
                null
            );

            Student s2 = new Student(
                "Joaozinho", 
                "988887777", 
                "Av. Rondon, 500", 
                "Santa Monica", 
                "UFU", 
                Turno.TARDE,
                null
            );

            // Salvar no banco de dados
            studentRepository.saveAll(Arrays.asList(s1, s2));
            
            System.out.println("Massa de dados de teste inserida com sucesso!");
        } else {
            System.out.println("O banco já tem dados, não vou fazer nada.");
        }
        
    }
}