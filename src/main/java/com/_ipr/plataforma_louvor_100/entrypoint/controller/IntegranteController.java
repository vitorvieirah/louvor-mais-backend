package com._ipr.plataforma_louvor_100.entrypoint.controller;

import com._ipr.plataforma_louvor_100.aplication.IntegranteUseCase;
import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.entrypoint.dto.IntegranteDto;
import com._ipr.plataforma_louvor_100.entrypoint.dto.ResponseDto;
import com._ipr.plataforma_louvor_100.entrypoint.mapper.IntegranteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/integrantes")
@RequiredArgsConstructor
public class IntegranteController {

    private final IntegranteUseCase useCase;

    @PostMapping
    public ResponseEntity<ResponseDto<IntegranteDto>> cadastrar(@RequestBody IntegranteDto novoIntegrante) {
        Integrante integrante = IntegranteMapper.paraDomain(novoIntegrante);
        integrante = useCase.cadastrar(integrante);
        IntegranteDto resposta = IntegranteMapper.paraDto(integrante);
        ResponseDto<IntegranteDto> responseDto = new ResponseDto<>(resposta);

        return ResponseEntity
                .created(UriComponentsBuilder
                        .newInstance()
                        .path("/integrantes/{id}")
                        .buildAndExpand(resposta.idIntegrante())
                        .toUri())
                .body(responseDto);
    }
}
