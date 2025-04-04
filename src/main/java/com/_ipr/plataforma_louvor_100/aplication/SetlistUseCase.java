package com._ipr.plataforma_louvor_100.aplication;

import com._ipr.plataforma_louvor_100.aplication.exceptions.SetlistNaoEncontradoException;
import com._ipr.plataforma_louvor_100.aplication.gateways.SetlistGateway;
import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.domain.Setlist;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

        List<Integrante> integrantesSeltist = new ArrayList<>();

        if(!setlist.getFolgas().isEmpty()) {
            integrantesSeltist = setlist.getFolgas()
                    .stream()
                    .map(integrante -> integranteUseCase.consultarPorId(integrante.getIdIntegrante()))
                    .toList();
        }

        setlist.setMusicas(musicasSetlist);
        setlist.setFolgas(integrantesSeltist);

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

        if(setlistOptional.isEmpty()) {
            throw new SetlistNaoEncontradoException();
        }
    }
}
