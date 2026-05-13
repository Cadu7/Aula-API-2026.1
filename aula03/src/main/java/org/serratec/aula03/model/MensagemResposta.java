package org.serratec.aula03.model;

// o record é a mesma coisa que a classe declarada abaixo, mas escrido de forma mais simples
public record MensagemResposta(String mensagem) {

}
//public class MensagemResposta {
//
//    private final String mensagem;
//
//    public MensagemResposta(String mensagem) {
//        this.mensagem = mensagem;
//    }
//
//    public String getMensagem() {
//        return mensagem;
//    }
//
//}