package com._ipr.plataforma_louvor_100.infrastructure.dataprovider;

import com._ipr.plataforma_louvor_100.aplication.gateways.MusicaGateway;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.infrastructure.dataprovider.exceptions.DataProviderException;
import com._ipr.plataforma_louvor_100.infrastructure.mapper.MusicaMapper;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.MusicaRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
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
public class MusicaDataProvider implements MusicaGateway {

    private final MusicaRepository repository;
    public final String MENSAGEM_ERRO_SALVAR_MUSICA = "Erro ao salvar música";
    public final String MENSAGEM_ERRO_CONSULTAR_MUSICA_ID = "Erro ao consultar música pelo id";
    public final String MENSAGEM_ERRO_LISTAR_MUSICA = "Erro ao listar músicas";
    public final String MENSAGEM_ERRO_DELETAR_MUSICA = "Erro ao deletar música";
    public final String MENSAGEM_ERRO_CONSULTAR_MUSICA_NOME = "Erro consultar música pelo nome";

    @Override
    public Musica salvar(Musica musica) {
        MusicaEntity musicaSalva;

        try {
            musicaSalva = repository.save(MusicaMapper.paraEntity(musica));
        } catch (Exception ex) {
            log.error(MENSAGEM_ERRO_SALVAR_MUSICA, ex);
            throw new DataProviderException(MENSAGEM_ERRO_SALVAR_MUSICA, ex.getCause());
        }

        return MusicaMapper.paraDomain(musicaSalva);
    }

    @Override
    public Optional<Musica> consultarPorId(UUID musicaId) {
        Optional<MusicaEntity> musica;

        try {
            musica = repository.findById(musicaId);
        } catch (Exception ex) {
            log.error(MENSAGEM_ERRO_CONSULTAR_MUSICA_ID, ex);
            throw new DataProviderException(MENSAGEM_ERRO_CONSULTAR_MUSICA_ID, ex.getCause());
        }

        return musica.map(MusicaMapper::paraDomain);
    }

    @Override
    public Page<Musica> listar(Pageable pageable) {
        Page<MusicaEntity> musicas;

        try {
            musicas = repository.findAll(pageable);
        } catch (Exception ex) {
            log.error(MENSAGEM_ERRO_LISTAR_MUSICA, ex);
            throw new DataProviderException(MENSAGEM_ERRO_LISTAR_MUSICA, ex.getCause());
        }

        return musicas.map(MusicaMapper::paraDomain);
    }

    @Override
    public void deletar(UUID idMusica) {
        try {
            repository.deleteById(idMusica);
        } catch (Exception ex) {
            log.error(MENSAGEM_ERRO_DELETAR_MUSICA, ex);
            throw new DataProviderException(MENSAGEM_ERRO_DELETAR_MUSICA, ex.getCause());
        }
    }

    @Override
    public Optional<Musica> consultarPorNome(String nome) {
        Optional<MusicaEntity> musica;

        try {
            musica = repository.findByNome(nome);
        } catch (Exception ex) {
            log.error(MENSAGEM_ERRO_CONSULTAR_MUSICA_NOME, ex);
            throw new DataProviderException(MENSAGEM_ERRO_CONSULTAR_MUSICA_NOME, ex.getCause());
        }

        return musica.map(MusicaMapper::paraDomain);
    }
}
