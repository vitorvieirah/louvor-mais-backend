package com._ipr.plataforma_louvor_100.infrastructure.dataprovider;

import com._ipr.plataforma_louvor_100.builder.IntegranteBuilder;
import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.IntegranteRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.IntegranteEntity;
import com._ipr.plataforma_louvor_100.validators.IntegranteValidator;
import com._ipr.plataforma_louvor_100.validators.MusicaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IntegranteDataProviderTest {

    @Mock
    private IntegranteRepository repository;

    @InjectMocks
    private IntegranteDataProvider dataProvider;

    private final Integrante integranteTeste = IntegranteBuilder.gerarIntegranteDomain();

    private final IntegranteEntity integranteTesteEntity = IntegranteBuilder.gerarIntegranteEntity();

    @Test
    void consultarPorId() {

    }

    @Test
    void consultarPorNome() {
    }

    @Test
    void testaSalvarIntegrante() {
        Mockito.when(repository.save(Mockito.any())).thenReturn(integranteTesteEntity);
        integranteTeste.setIdIntegrante(null);
        Integrante resultado = dataProvider.salvar(integranteTeste);
        IntegranteValidator.validaIntegranteDomain(resultado, integranteTeste);
        Assertions.assertNotNull(resultado.getIdIntegrante());
    }

    @Test
}