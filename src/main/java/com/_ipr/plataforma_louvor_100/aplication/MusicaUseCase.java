package com._ipr.plataforma_louvor_100.aplication;

import com._ipr.plataforma_louvor_100.aplication.exceptions.MusicaJaCadastradaException;
import com._ipr.plataforma_louvor_100.aplication.exceptions.MusicaNaoEncontradaException;
import com._ipr.plataforma_louvor_100.aplication.gateways.MusicaGateway;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MusicaUseCase {

    private final MusicaGateway gateway;

    public Musica cadastrar(Musica novaMusica) {
        Optional<Musica> musica = gateway.consultarPorNome(novaMusica.getNome());

        musica.ifPresent(musicaOptional -> {
            throw new MusicaJaCadastradaException();
        });

        return gateway.salvar(novaMusica);
    }

    public Musica consultarPorId(UUID musicaId) {
        Optional<Musica> musica = gateway.consultarPorId(musicaId);

        if(musica.isEmpty()) {
            throw new MusicaNaoEncontradaException();
        }

        return musica.get();
    }

    public Page<Musica> listar(Pageable pageable) {
        return gateway.listar(pageable);
    }

    public Musica editar(Musica novosDados, UUID idMusica) {
        Musica musica = this.consultarPorId(idMusica);
        musica.setDados(novosDados);
        return gateway.salvar(musica);
    }

    public void deletar(UUID idMusica) {
        consultarPorId(idMusica);
        this.gateway.deletar(idMusica);
    }
}
