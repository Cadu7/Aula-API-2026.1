package org.serratec.aula01.model;

import java.util.UUID;

public class Usuario {

    private UUID id;
    private String nome;
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