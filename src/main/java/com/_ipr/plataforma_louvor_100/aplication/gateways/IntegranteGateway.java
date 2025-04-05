package com._ipr.plataforma_louvor_100.aplication.gateways;

import com._ipr.plataforma_louvor_100.domain.Integrante;

import java.util.Optional;
import java.util.UUID;

public interface IntegranteGateway {
    Optional<Integrante> consultarPorId(UUID idIntegrante);

    Optional<Integrante> consultarPorNome(String nome);

    Integrante salvar(Integrante novoIntegrante);
}
