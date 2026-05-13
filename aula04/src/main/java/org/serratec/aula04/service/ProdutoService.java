package org.serratec.aula04.service;

import org.serratec.aula04.entity.Produto;
import org.serratec.aula04.exception.ProdutoNaoEncontrado;
import org.serratec.aula04.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service // @RestController
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void inserir(Produto produto) {
        this.produtoRepository.save(produto);
        System.out.println("O produto foi salvo com suceso");
    }

    public Produto buscar(UUID id){
        Optional<Produto> produtoOpt = this.produtoRepository.findById(id);

        if (produtoOpt.isEmpty()) {
            // lançar execeção customizada
            throw new ProdutoNaoEncontrado("O produto não foi encontrado pelo id: " + id);
        }
        return produtoOpt.get();
    }

}
