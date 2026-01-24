package com._ipr.plataforma_louvor_100.aplication;

import com._ipr.plataforma_louvor_100.aplication.exceptions.SetlistNaoEncontradoException;
import com._ipr.plataforma_louvor_100.aplication.gateways.SetlistGateway;
import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.domain.Setlist;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SetlistUseCase {

    private final SetlistGateway gateway;
    private final MusicaUseCase musicaUseCase;
    private final IntegranteUseCase integranteUseCase;

    public Setlist cadastrar(Setlist setlist) {

        List<Musica> musicasSetlist = setlist.getMusicas()
                .stream()
                .map(musica -> musicaUseCase.consultarPorId(musica.getIdMusica()))
                .toList();

        List<Integrante> integrantesEscalados = setlist.getEscalados()
                .stream()
                .map(integrante -> integranteUseCase.consultarPorId(integrante.getIdIntegrante()))
                .toList();

        List<Integrante> todosIntegrantes = integranteUseCase.listar(PageRequest.of(0, 100)).stream().toList();

        Set<UUID> idsEscalados = integrantesEscalados.stream()
                .map(Integrante::getIdIntegrante)
                .collect(Collectors.toSet());

        List<Integrante> integrantesFolga = todosIntegrantes.stream()
                .filter(integrante -> !idsEscalados.contains(integrante.getIdIntegrante()))
                .toList();

        setlist.setMusicas(musicasSetlist);
        setlist.setEscalados(integrantesEscalados);
        setlist.setFolgas(integrantesFolga);

        return gateway.salvar(setlist);
    }

    public Page<Setlist> listar(Pageable pageable) {
        return gateway.listar(pageable);
    }

    public void deletar(UUID idSetlist) {
        this.validaSetlistExiste(idSetlist);
        gateway.deletar(idSetlist);
    }

    private void validaSetlistExiste(UUID idSetlist) {
        Optional<Setlist> setlistOptional = gateway.consultarPorId(idSetlist);

        if (setlistOptional.isEmpty()) {
            throw new SetlistNaoEncontradoException();
        }
    }
}
