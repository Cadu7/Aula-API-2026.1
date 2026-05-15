package org.serratec.aula05.controller;

import org.serratec.aula05.entity.Funcionario;
import org.serratec.aula05.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody Funcionario funcionario){
        this.funcionarioService.inserir(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
