package org.serratec.aula02.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity // define que essa classe é uma entidade/tabela do banco @Id
@Table(name = "usuario_tb")
public class Usuario { // em minusculo

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) define que o banco vai criar os ID's (Integer)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    public Usuario() {
    }

    public Usuario(UUID id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario(" + "id=" + id + ", nome='" + nome + '\'' + ", email='" + email + '\'' + ')';
    }

}