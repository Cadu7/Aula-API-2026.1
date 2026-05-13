package org.serratec.aula04.controller;

import jakarta.validation.Valid;
import org.serratec.aula04.entity.Produto;
import org.serratec.aula04.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody @Valid Produto produto) {
        this.produtoService.inserir(produto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable UUID id){
        Produto produto = this.produtoService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

}
