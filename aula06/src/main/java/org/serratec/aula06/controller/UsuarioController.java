package org.serratec.aula06.controller;

import jakarta.validation.Valid;
import org.serratec.aula06.entity.Usuario;
import org.serratec.aula06.model.UsuarioBuscaId;
import org.serratec.aula06.model.UsuarioCriar;
import org.serratec.aula06.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@Valid @RequestBody UsuarioCriar usuario) {
        this.usuarioService.inserir(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioBuscaId> buscar(@PathVariable UUID id) {
        UsuarioBuscaId usuario = this.usuarioService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioBuscaId>> buscar(@RequestParam(required = false) String cpf, @RequestParam(required = false) String nome) {
        List<UsuarioBuscaId> usuario = this.usuarioService.buscar(cpf, nome);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

}
