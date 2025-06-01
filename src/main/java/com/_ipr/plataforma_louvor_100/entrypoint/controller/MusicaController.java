package com._ipr.plataforma_louvor_100.entrypoint.controller;

import com._ipr.plataforma_louvor_100.aplication.MusicaUseCase;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.entrypoint.dto.MusicaDto;
import com._ipr.plataforma_louvor_100.entrypoint.dto.MusicaResponseDto;
import com._ipr.plataforma_louvor_100.entrypoint.dto.ResponseDto;
import com._ipr.plataforma_louvor_100.entrypoint.mapper.MusicaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/musicas")
@RequiredArgsConstructor
public class MusicaController {

    private final MusicaUseCase useCase;

    @PostMapping
    public ResponseEntity<ResponseDto<MusicaResponseDto>> cadastrar(@Valid @RequestBody MusicaDto novaMusica) {
        Musica musica = MusicaMapper.paraDomain(novaMusica);
        musica = useCase.cadastrar(musica);
        MusicaResponseDto resposta = MusicaMapper.paraDto(musica);
        ResponseDto<MusicaResponseDto> responseDto = new ResponseDto<>(resposta);
        return ResponseEntity
                .created(UriComponentsBuilder
                        .newInstance()
                        .path("/musicas/{id}")
                        .buildAndExpand(resposta.idMusica())
                        .toUri())
                .body(responseDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseDto<MusicaResponseDto>> consultarPorId(@PathVariable("id") UUID musicaId) {
        Musica musica = useCase.consultarPorId(musicaId);
        MusicaResponseDto resposta = MusicaMapper.paraDto(musica);
        ResponseDto<MusicaResponseDto> response = new ResponseDto<>(resposta);
        return ResponseEntity.ok(response);
    }

        @GetMapping
        public ResponseEntity<ResponseDto<Page<MusicaResponseDto>>> listar(@PageableDefault Pageable pageable) {
            Page<Musica> musicas = useCase.listar(pageable);
            Page<MusicaResponseDto> resposta = musicas.map(MusicaMapper::paraDto);
            ResponseDto<Page<MusicaResponseDto>> responseDto = new ResponseDto<>(resposta);
            return ResponseEntity.ok(responseDto);
        }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponseDto<MusicaResponseDto>> editar(@RequestBody MusicaDto novosDados, @PathVariable("id") UUID idMusica) {
        Musica musica = MusicaMapper.paraDomain(novosDados);
        musica = useCase.editar(musica, idMusica);
        MusicaResponseDto resposta = MusicaMapper.paraDto(musica);
        ResponseDto<MusicaResponseDto> responseDto = new ResponseDto<>(resposta);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") UUID idMusica) {
        useCase.deletar(idMusica);
        return ResponseEntity.noContent().build();
    }
}
