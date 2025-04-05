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
    public final static String MENSAGEM_ERRO_CONSULTAR_INTEGRANTE_POR_ID = "Erro ao consultar integrante pelo id.";
    public final static String MENSAGEM_ERRO_CONSULTAR_INTEGRANTE_POR_NOME = "Erro ao consultar integrante pelo nome.";
    public final static String MENSAGEM_ERRO_SALVAR_INTEGRANTE = "Erro ao salvar integrante.";

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

    @Override
    public Optional<Integrante> consultarPorNome(String nome) {
        Optional<IntegranteEntity> integranteEntity;

        try {
            integranteEntity = repository.findByNome(nome);
        } catch (Exception ex) {
            log.error(MENSAGEM_ERRO_CONSULTAR_INTEGRANTE_POR_NOME, ex);
            throw new DataProviderException(MENSAGEM_ERRO_CONSULTAR_INTEGRANTE_POR_NOME, ex.getCause());
        }

        return integranteEntity.map(IntegranteMapper::paraDomain);
    }

    @Override
    public Integrante salvar(Integrante novoIntegrante) {
        IntegranteEntity integranteEntity = IntegranteMapper.paraEntity(novoIntegrante);

        try {
            integranteEntity = repository.save(integranteEntity);
        } catch (Exception ex) {
            log.error(MENSAGEM_ERRO_SALVAR_INTEGRANTE, ex);
            throw new DataProviderException(MENSAGEM_ERRO_SALVAR_INTEGRANTE, ex.getCause());
        }

        return IntegranteMapper.paraDomain(integranteEntity);
    }
}
