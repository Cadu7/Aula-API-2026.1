package org.serratec.aula01.controller;

import org.serratec.aula01.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/usuario")
@RestController // fala pro spring gerenciar esta classe e que ela é um controller
public class UsuarioController {

    private static List<Usuario> usuarios = new ArrayList<>();

    static {
        usuarios.add(new Usuario(UUID.randomUUID(),"Cadu","cadu@gmail.com"));
        usuarios.add(new Usuario(UUID.randomUUID(),"Carlos", "carlos@gmail.com"));
    }

//    // @ metodo + Mapping
//    @GetMapping("/ola")
//    public String saudacao() {
//        return "OLA";
//    }
//    // http://localhost:8080
//    // http://localhost:8080/ola
//
//    @GetMapping("")
//    public String saudacao2() {
//        return "HI";
//    }

    // {"nome":"cadu"}

    @PostMapping
    public void inserirUsuario(@RequestBody Usuario usuario) {
        System.out.println("O usuário recebido foi: " + usuario);
        usuario.setId(UUID.randomUUID());
        usuarios.add(usuario);
    }
    // /usuario POST
    // mensagem do formato json que tem que conter nome e email

    // Request Param == query param é usado para buscar ?
    @GetMapping()
    public List<Usuario> listaUsuarios(@RequestParam String nome) {
        // "    "
        // "" length == 0
        if (nome == null || nome.isBlank()) {
            return usuarios;
        }

        List<Usuario> resultado = new ArrayList<>();
        for (Usuario usuario: usuarios) {
            String nomeUsuario = usuario.getNome().toUpperCase();
            String searchNome = nome.toUpperCase();
            if (nomeUsuario.startsWith(searchNome)) {
                resultado.add(usuario);
            }
        }
        return resultado;
    }

    @DeleteMapping("/{id}") // /usuario/1f94ca47-b354-4699-ad7e-6aff80c10ed8
    public void deleteUsuario(@PathVariable String id) {
        // usuarios tem 2 usuarios
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario usuario: usuarios) {
            if (usuario.getId().equals(UUID.fromString(id))){
                continue;
            }
            resultado.add(usuario);
            // resultado vai conter tod mundo que o id for diferente do informado pelo usuario
        }
        usuarios = resultado;
    }

    // put atualizar
    @PutMapping("/{id}")
    public void atualizaUsuario(@PathVariable String id, @RequestParam String email) {
        for (Usuario usuario: usuarios) {
            if (usuario.getId().equals(UUID.fromString(id))) {
                usuario.setEmail(email);
            }
        }
    }


}
