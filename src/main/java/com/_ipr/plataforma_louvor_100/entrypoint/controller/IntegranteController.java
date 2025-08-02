package com._ipr.plataforma_louvor_100.entrypoint.controller;

import com._ipr.plataforma_louvor_100.aplication.IntegranteUseCase;
import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.entrypoint.dto.IntegranteDto;
import com._ipr.plataforma_louvor_100.entrypoint.dto.ResponseDto;
import com._ipr.plataforma_louvor_100.entrypoint.mapper.IntegranteMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<ResponseDto<Page<IntegranteDto>>> listar(@PageableDefault Pageable pageable) {
        Page<Integrante> integrantes = useCase.listar(pageable);
        Page<IntegranteDto> resposta = integrantes.map(IntegranteMapper::paraDto);
        ResponseDto<Page<IntegranteDto>> responseDto = new ResponseDto<>(resposta);
        return ResponseEntity.ok(responseDto);
    }
}
