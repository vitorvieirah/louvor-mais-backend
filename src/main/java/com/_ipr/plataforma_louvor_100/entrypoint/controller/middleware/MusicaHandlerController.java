package com._ipr.plataforma_louvor_100.entrypoint.controller.middleware;

import com._ipr.plataforma_louvor_100.aplication.exceptions.MusicaJaCadastradaException;
import com._ipr.plataforma_louvor_100.aplication.exceptions.MusicaNaoEncontradaException;
import com._ipr.plataforma_louvor_100.entrypoint.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class MusicaHandlerController {

    @ExceptionHandler(MusicaJaCadastradaException.class)
    public ResponseEntity<ResponseDto> musicaJaCadastradaExceptionHandler(MusicaJaCadastradaException exception) {
        ResponseDto.ErroDto erroDto = ResponseDto.ErroDto.builder().mensagens(List.of(exception.getMessage())).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDto.comErro(erroDto));
    }

    @ExceptionHandler(MusicaNaoEncontradaException.class)
    public ResponseEntity<ResponseDto> musicaNaoEncontradaExceptionHandler(MusicaNaoEncontradaException exception) {
        ResponseDto.ErroDto erroDto = ResponseDto.ErroDto.builder().mensagens(List.of(exception.getMessage())).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseDto.comErro(erroDto));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto<Void>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        List<FieldError> erros = exception.getFieldErrors();
        List<String> mensagensErroDto = erros.stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        ResponseDto.ErroDto erroDto = ResponseDto.ErroDto.builder().mensagens(mensagensErroDto).build();

        ResponseDto<Void> responseDto = ResponseDto.comErro(erroDto);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
    }

}
