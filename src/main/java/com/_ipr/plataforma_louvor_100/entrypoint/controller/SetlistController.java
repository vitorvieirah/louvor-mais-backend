package com._ipr.plataforma_louvor_100.entrypoint.controller;

import com._ipr.plataforma_louvor_100.aplication.SetlistUseCase;
import com._ipr.plataforma_louvor_100.domain.Setlist;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.entrypoint.dto.ResponseDto;
import com._ipr.plataforma_louvor_100.entrypoint.dto.SetlistDto;
import com._ipr.plataforma_louvor_100.entrypoint.mapper.SetlistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("setlists")
@RequiredArgsConstructor
public class SetlistController {

    private final SetlistUseCase useCase;

    @PostMapping
    public ResponseEntity<ResponseDto<SetlistDto>> cadastrar(@RequestBody SetlistDto novoSetlist) {
        Setlist setlist = SetlistMapper.paraDomain(novoSetlist);
        setlist = useCase.cadastrar(setlist);
        SetlistDto resposta = SetlistMapper.paraDto(setlist);
        ResponseDto<SetlistDto> responseDto = new ResponseDto<>(resposta);

        return ResponseEntity
                .created(UriComponentsBuilder
                        .newInstance()
                        .path("setlists/{id}")
                        .buildAndExpand(resposta.idSetlist())
                        .toUri()
                ).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<ResponseDto<Page<SetlistDto>>> listar(@PageableDefault Pageable pageable) {
        Page<Setlist> setlists = useCase.listar(pageable);
        Page<SetlistDto> resposta = setlists.map(SetlistMapper::paraDto);

        ResponseDto<Page<SetlistDto>> responseDto = new ResponseDto<>(resposta);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") UUID idSetlist) {
        useCase.deletar(idSetlist);
        return ResponseEntity.noContent().build();
    }

}
