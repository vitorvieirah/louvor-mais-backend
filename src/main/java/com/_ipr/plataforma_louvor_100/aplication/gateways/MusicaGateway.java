package com._ipr.plataforma_louvor_100.aplication.gateways;

import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface MusicaGateway {
    Musica salvar(Musica musica);

    Optional<Musica> consultarPorId(UUID musicaId);

    Page<Musica> listar(Pageable pageable);

    void deletar(UUID idMusica);

    Optional<Musica> consultarPorNome(String nome);
}
