package com._ipr.plataforma_louvor_100.aplication;

import com._ipr.plataforma_louvor_100.aplication.exceptions.IntegranteNaoEncontradoException;
import com._ipr.plataforma_louvor_100.aplication.gateways.IntegranteGateway;
import com._ipr.plataforma_louvor_100.domain.Integrante;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IntegranteUseCase {

    private final IntegranteGateway gateway;

    public Integrante consultarPorId(UUID idIntegrante) {
        Optional<Integrante> integrante = gateway.consultarPorId(idIntegrante);

        if(integrante.isEmpty()) {
            throw new IntegranteNaoEncontradoException();
        }

        return integrante.get();
    }
}
