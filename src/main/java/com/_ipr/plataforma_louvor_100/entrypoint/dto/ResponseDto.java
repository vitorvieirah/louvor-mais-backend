package com._ipr.plataforma_louvor_100.entrypoint.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDto<D> {

    private D dado;
    private ErroDto erro;

    public ResponseDto(D dado) {
        this.dado = dado;
    }

    @Getter
    @Setter
    public static class ErroDto {
        private List<String> messages;
    }

    public ResponseDto<D> comErro(ErroDto erro) {
        ResponseDto<D> responseDto = new ResponseDto<>();
        responseDto.setErro(erro);
        return responseDto;
    }
}
