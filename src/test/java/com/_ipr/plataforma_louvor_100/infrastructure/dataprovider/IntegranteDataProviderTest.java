package com._ipr.plataforma_louvor_100.infrastructure.dataprovider;

import com._ipr.plataforma_louvor_100.builder.IntegranteBuilder;
import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.infrastructure.dataprovider.exceptions.DataProviderException;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.IntegranteRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.IntegranteEntity;
import com._ipr.plataforma_louvor_100.validators.IntegranteValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class IntegranteDataProviderTest {

    @Mock
    private IntegranteRepository repository;

    @InjectMocks
    private IntegranteDataProvider dataProvider;

    private final Integrante integranteTeste = IntegranteBuilder.gerarIntegranteDomain();

    private final IntegranteEntity integranteTesteEntity = IntegranteBuilder.gerarIntegranteEntity();

    @Test
    void testaConsultaIntegrantePeloId() {
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(integranteTesteEntity));
        Optional<Integrante> resultado = dataProvider.consultarPorId(integranteTeste.getIdIntegrante());

        resultado.ifPresent(integrante -> {
            IntegranteValidator.validaIntegranteDomain(integrante, integranteTeste);
            Assertions.assertEquals(integrante.getIdIntegrante(), integranteTeste.getIdIntegrante());
        });
    }

    @Test
    void testaExceptionConsultaIntegrantePeloId() {
        Mockito.when(repository.findById(Mockito.any())).thenThrow(RuntimeException.class);
        DataProviderException exception = Assertions
                .assertThrows(DataProviderException.class, () -> dataProvider.consultarPorId(integranteTeste.getIdIntegrante()));
        Assertions.assertEquals(exception.getMessage(), IntegranteDataProvider.MENSAGEM_ERRO_CONSULTAR_INTEGRANTE_POR_ID);
    }

    @Test
    void testaConsultarIntegrantePorNome() {
        Mockito.when(repository.findByNome(Mockito.any())).thenReturn(Optional.of(integranteTesteEntity));
        Optional<Integrante> resultado = dataProvider.consultarPorNome(integranteTeste.getNome());

        resultado.ifPresent(integrante -> {
            IntegranteValidator.validaIntegranteDomain(integrante, integranteTeste);
            Assertions.assertEquals(integrante.getIdIntegrante(), integranteTeste.getIdIntegrante());
        });
    }

    @Test
    void testaExceptionConsultaIntegrantePorNome() {
        Mockito.when(repository.findByNome(Mockito.any())).thenThrow(RuntimeException.class);
        DataProviderException exception = Assertions
                .assertThrows(DataProviderException.class, () -> dataProvider.consultarPorNome(integranteTeste.getNome()));
        Assertions.assertEquals(exception.getMessage(), IntegranteDataProvider.MENSAGEM_ERRO_CONSULTAR_INTEGRANTE_POR_NOME);
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
    void testaExceptionSavalIntegrante() {
        Mockito.when(repository.save(Mockito.any())).thenThrow(RuntimeException.class);
        DataProviderException exception = Assertions
                .assertThrows(DataProviderException.class, () -> dataProvider.salvar(integranteTeste));
        Assertions.assertEquals(exception.getMessage(), IntegranteDataProvider.MENSAGEM_ERRO_SALVAR_INTEGRANTE);
    }
}