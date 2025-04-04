package com._ipr.plataforma_louvor_100.aplication.gateways;

import com._ipr.plataforma_louvor_100.domain.Setlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface SetlistGateway {
    Setlist salvar(Setlist setlist);

    Page<Setlist> listar(Pageable pageable);

    void deletar(UUID idSetlist);

    Optional<Setlist> consultarPorId(UUID idSetlist);
}
