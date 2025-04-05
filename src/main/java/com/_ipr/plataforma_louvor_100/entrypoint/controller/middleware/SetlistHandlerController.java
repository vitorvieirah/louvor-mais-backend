package com._ipr.plataforma_louvor_100.entrypoint.controller.middleware;

import com._ipr.plataforma_louvor_100.aplication.exceptions.SetlistNaoEncontradoException;
import com._ipr.plataforma_louvor_100.entrypoint.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class SetlistHandlerController {

    @ExceptionHandler(SetlistNaoEncontradoException.class)
    public ResponseEntity<ResponseDto> setlistNaoEncontradoException(SetlistNaoEncontradoException exception) {
        ResponseDto.ErroDto erroDto = ResponseDto.ErroDto.builder().mensagens(List.of(exception.getMessage())).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseDto.comErro(erroDto));
    }

}
