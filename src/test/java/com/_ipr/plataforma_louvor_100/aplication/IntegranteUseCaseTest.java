package com._ipr.plataforma_louvor_100.aplication;

import com._ipr.plataforma_louvor_100.aplication.exceptions.integrante.IntegranteJaCadastradoException;
import com._ipr.plataforma_louvor_100.aplication.exceptions.integrante.IntegranteNaoEncontradoException;
import com._ipr.plataforma_louvor_100.aplication.gateways.IntegranteGateway;
import com._ipr.plataforma_louvor_100.builder.IntegranteBuilder;
import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.validators.IntegranteValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class IntegranteUseCaseTest {

    @Mock
    private IntegranteGateway gateway;

    @InjectMocks
    private IntegranteUseCase useCase;

    @Captor
    private ArgumentCaptor<Integrante> captor;

    private final Integrante integranteTeste = IntegranteBuilder.gerarIntegranteDomain();

    @Test
    void testeConsultaPeloId() {
        Mockito.when(gateway.consultarPorId(Mockito.any())).thenReturn(Optional.of(integranteTeste));

        Integrante resultado = useCase.consultarPorId(integranteTeste.getIdIntegrante());

        IntegranteValidator.validaIntegranteDomain(resultado, integranteTeste);
        Assertions.assertEquals(resultado.getIdIntegrante(), integranteTeste.getIdIntegrante());
    }

    @Test
    void testeExceptionConsultaPeloId() {
        Mockito.when(gateway.consultarPorId(Mockito.any())).thenReturn(Optional.empty());

        IntegranteNaoEncontradoException exception = Assertions
                .assertThrows(IntegranteNaoEncontradoException.class, () -> useCase.consultarPorId(integranteTeste.getIdIntegrante()));

        Assertions.assertEquals(exception.getMessage(), "Integrante não encontrado pelo seu id.");
    }

    @Test
    void testeCadastro() {
        Mockito.when(gateway.consultarPorNome(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(gateway.salvar(captor.capture())).thenReturn(integranteTeste);

        integranteTeste.setIdIntegrante(null);

        useCase.cadastrar(integranteTeste);

        Integrante resultado = captor.getValue();

        IntegranteValidator.validaIntegranteDomain(resultado, integranteTeste);
        Assertions.assertNull(resultado.getIdIntegrante());
    }

    @Test
    void testeExceptionCadastro() {
        Mockito.when(gateway.consultarPorNome(Mockito.any())).thenReturn(Optional.of(integranteTeste));

        integranteTeste.setIdIntegrante(null);

        IntegranteJaCadastradoException exception = Assertions.assertThrows(IntegranteJaCadastradoException.class,
                () -> useCase.cadastrar(integranteTeste));

        Assertions.assertEquals(exception.getMessage(), "Integrante já cadastrado com esse nome.");
    }
}