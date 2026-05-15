package org.serratec.aula05.controller;

import org.serratec.aula05.entity.Cliente;
import org.serratec.aula05.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody Cliente client) {
        this.clienteService.inserir(client);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
