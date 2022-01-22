package br.com.iteris.universidade.adocaoanimais.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AdocaoNaoEncontradaException extends RuntimeException {
    public AdocaoNaoEncontradaException() {
        super("Não foi encontrado Adocão para a entrada");
    }
}
