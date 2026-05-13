package org.serratec.aula04.exception;

import org.serratec.aula04.model.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice // que esta classe é gerenciada pelo spring e que retorna as exceões customizadas pro usuário
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String mensagem = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(i -> i.getField() + " " + i.getDefaultMessage())
                .collect(Collectors.joining(","));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(mensagem, LocalDateTime.now()));
    }

    @ExceptionHandler(ProdutoNaoEncontrado.class)
    public ResponseEntity<ErrorMessage> handleProdutoNaoEncontrado(ProdutoNaoEncontrado ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(ex.getMessage(), LocalDateTime.now()));
    }

}
