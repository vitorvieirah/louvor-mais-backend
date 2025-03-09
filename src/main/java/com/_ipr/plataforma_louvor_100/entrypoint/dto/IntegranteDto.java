package com._ipr.plataforma_louvor_100.entrypoint.dto;

import com._ipr.plataforma_louvor_100.domain.FuncaoIntegrante;
import lombok.Builder;

import java.util.UUID;

@Builder
public record IntegranteDto (UUID idIntegrante, String nome, FuncaoIntegrante funcao){}
