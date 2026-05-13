package org.serratec.aula04.exception;

public class ProdutoNaoEncontrado extends RuntimeException {

    public ProdutoNaoEncontrado(String message) {
        super(message);
    }

}
