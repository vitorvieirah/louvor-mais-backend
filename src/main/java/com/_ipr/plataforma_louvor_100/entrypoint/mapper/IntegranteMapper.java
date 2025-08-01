package com._ipr.plataforma_louvor_100.entrypoint.mapper;

import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.entrypoint.dto.IntegranteDto;

public class IntegranteMapper {

    public static Integrante paraDomain(IntegranteDto dto) {
        return Integrante.builder()
                .idIntegrante(dto.idIntegrante())
                .nome(dto.nome())
                .funcao(dto.funcao())
                .build();
    }

    public static IntegranteDto paraDto(Integrante domain) {
        return IntegranteDto.builder()
                .idIntegrante(domain.getIdIntegrante())
                .nome(domain.getNome())
                .funcao(domain.getFuncao())
                .descricaoFuncao(domain.getFuncao().getDescricao())
                .build();
    }
}
