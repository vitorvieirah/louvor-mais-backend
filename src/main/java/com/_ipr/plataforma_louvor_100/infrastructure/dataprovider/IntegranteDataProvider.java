package com._ipr.plataforma_louvor_100.infrastructure.dataprovider;

import com._ipr.plataforma_louvor_100.aplication.gateways.IntegranteGateway;
import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.infrastructure.dataprovider.exceptions.DataProviderException;
import com._ipr.plataforma_louvor_100.infrastructure.mapper.IntegranteMapper;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.IntegranteRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.IntegranteEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class IntegranteDataProvider implements IntegranteGateway {

    private final IntegranteRepository repository;
    private final String MENSAGEM_ERRO_CONSULTAR_INTEGRANTE_POR_ID = "Erro ao consultar integrante pelo id.";

    @Override
    public Optional<Integrante> consultarPorId(UUID idIntegrante) {
        Optional<IntegranteEntity> integranteEntity;

        try {
            integranteEntity = repository.findById(idIntegrante);
        } catch (Exception ex) {
            log.error(MENSAGEM_ERRO_CONSULTAR_INTEGRANTE_POR_ID, ex);
            throw new DataProviderException(MENSAGEM_ERRO_CONSULTAR_INTEGRANTE_POR_ID, ex.getCause());
        }

        return integranteEntity.map(IntegranteMapper::paraDomain);
    }
}
