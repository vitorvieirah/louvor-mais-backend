package com._ipr.plataforma_louvor_100.entrypoint.controller.middleware;

import com._ipr.plataforma_louvor_100.aplication.exceptions.integrante.IntegranteJaCadastradoException;
import com._ipr.plataforma_louvor_100.aplication.exceptions.integrante.IntegranteNaoEncontradoException;
import com._ipr.plataforma_louvor_100.entrypoint.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class IntegranteHandlerController {

    @ExceptionHandler(IntegranteJaCadastradoException.class)
    public ResponseEntity<ResponseDto> integranteJaCadastradaExceptionHandler(IntegranteJaCadastradoException exception) {
        ResponseDto.ErroDto erroDto = ResponseDto.ErroDto.builder().mensagens(List.of(exception.getMessage())).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDto.comErro(erroDto));
    }

    @ExceptionHandler(IntegranteNaoEncontradoException.class)
    public ResponseEntity<ResponseDto> integranteNaoEncontradoExceptionHandler(IntegranteNaoEncontradoException exception) {
        ResponseDto.ErroDto erroDto = ResponseDto.ErroDto.builder().mensagens(List.of(exception.getMessage())).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseDto.comErro(erroDto));
    }

}
