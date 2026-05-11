package org.serratec.aula02.controller;

import org.serratec.aula02.model.Mensagem;
import org.serratec.aula02.entity.Usuario;
import org.serratec.aula02.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {

    @Value("${application.saudacao}")
    private String saudacao;

    @Autowired // instanciar (new) a classe/interface
    private UsuarioRepository usuarioRepository;

    @GetMapping("/saudacao")
    public ResponseEntity<Mensagem> saudacao() {
        return ResponseEntity.status(HttpStatus.OK)
                .header("application","aula-02")
                .body(new Mensagem("Saudação concluida"));
    }

    @PostMapping()
    public ResponseEntity<Void> inserirUsuario(@RequestBody Usuario usuario) {
        usuario.setId(UUID.randomUUID());
        this.usuarioRepository.save(usuario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build(); // 201
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> listaUsuarios(@RequestParam(required = false) String nome) {
        List<Usuario> usuarios;
        if (nome == null || nome.isBlank()) {
            usuarios = this.usuarioRepository.findAll();
        } else {
            usuarios = this.usuarioRepository.findByNomeLike(nome);
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable String id) {
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findById(UUID.fromString(id));

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioOpt.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String id) {
        if (!this.usuarioRepository.existsById(UUID.fromString(id))){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.usuarioRepository.deleteById(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizaUsuario(@PathVariable String id, @RequestParam String email) {
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findById(UUID.fromString(id));

        if (usuarioOpt.isEmpty()) { // == null
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Usuario usuario = usuarioOpt.get();
        usuario.setEmail(email); // update no codigo
        this.usuarioRepository.save(usuario);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
