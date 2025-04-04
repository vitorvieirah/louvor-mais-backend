package com._ipr.plataforma_louvor_100.infrastructure.dataprovider;

import com._ipr.plataforma_louvor_100.aplication.gateways.SetlistGateway;
import com._ipr.plataforma_louvor_100.domain.Setlist;
import com._ipr.plataforma_louvor_100.infrastructure.dataprovider.exceptions.DataProviderException;
import com._ipr.plataforma_louvor_100.infrastructure.mapper.SetlistMapper;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.SetlistRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.SetlistEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class SetlistDataProvider implements SetlistGateway {

    private final SetlistRepository repository;
    private final String MENSAGEM_ERRO_SALVAR_SETLIST = "Erro ao salvar setlist.";
    private final String MENSAGEM_ERRO_LISTAR_SETLIST = "Erro ao listar setlist.";
    private final String MENSAGEM_ERRO_DELETAR_SETLIST = "Erro ao deletar setlist.";
    private final String MENSAGEM_ERRO_CONSULTAR_SETLIST_POR_ID = "Erro ao consultar setlist pelo id.";

    @Override
    public Setlist salvar(Setlist setlist) {
        SetlistEntity setlistEntity;

        try {
            setlistEntity = repository.save(SetlistMapper.paraEntity(setlist));
        } catch (Exception ex) {
            log.error(MENSAGEM_ERRO_SALVAR_SETLIST, ex);
            throw new DataProviderException(MENSAGEM_ERRO_SALVAR_SETLIST, ex.getCause());
        }

        return SetlistMapper.paraDomain(setlistEntity);
    }

    @Override
    public Page<Setlist> listar(Pageable pageable) {
        Page<SetlistEntity> setlistEntities;

        try {
            setlistEntities = repository.findAll(pageable);
        } catch (Exception ex) {
            log.error(MENSAGEM_ERRO_LISTAR_SETLIST, ex);
            throw new DataProviderException(MENSAGEM_ERRO_LISTAR_SETLIST, ex.getCause());
        }

        return setlistEntities.map(SetlistMapper::paraDomain);
    }

    @Override
    public void deletar(UUID idSetlist) {
        try {
            repository.deleteById(idSetlist);
        } catch (Exception ex) {
            log.error(MENSAGEM_ERRO_DELETAR_SETLIST, ex);
            throw new DataProviderException(MENSAGEM_ERRO_DELETAR_SETLIST, ex.getCause());
        }
    }

    @Override
    public Optional<Setlist> consultarPorId(UUID idSetlist) {
        Optional<SetlistEntity> setlistEntity;

        try {
            setlistEntity = repository.findById(idSetlist);
        } catch (Exception ex) {
            log.error(MENSAGEM_ERRO_CONSULTAR_SETLIST_POR_ID, ex);
            throw new DataProviderException(MENSAGEM_ERRO_CONSULTAR_SETLIST_POR_ID, ex.getCause());
        }

        return setlistEntity.map(SetlistMapper::paraDomain);
    }
}
