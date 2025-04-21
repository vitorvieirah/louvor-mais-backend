package com._ipr.plataforma_louvor_100.aplication;

import com._ipr.plataforma_louvor_100.aplication.gateways.SetlistGateway;
import com._ipr.plataforma_louvor_100.builder.IntegranteBuilder;
import com._ipr.plataforma_louvor_100.builder.MusicaBuilder;
import com._ipr.plataforma_louvor_100.builder.SetlistBuilder;
import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.domain.Setlist;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.infrastructure.mapper.SetlistMapper;
import com._ipr.plataforma_louvor_100.validators.SetlistValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class SetlistUseCaseTest {

    @Mock
    private SetlistGateway gateway;

    @Mock
    private MusicaUseCase musicaUseCase;

    @Mock
    private IntegranteUseCase integranteUseCase;

    @InjectMocks
    private SetlistUseCase useCase;

    @Captor
    private ArgumentCaptor<Setlist> captor;

    private final Setlist setlist = SetlistBuilder.gerarSetlistDomain();
    private final Musica musica = MusicaBuilder.gerarMusicaDomain();
    private final Integrante integrante = IntegranteBuilder.gerarIntegranteDomain();

    @Test
    void testaCadastroDeSetlist() {
        Mockito.when(musicaUseCase.consultarPorId(Mockito.any())).thenReturn(musica);
        Mockito.when(integranteUseCase.consultarPorId(Mockito.any())).thenReturn(integrante);
        Mockito.when(gateway.salvar(captor.capture())).thenReturn(setlist);

        setlist.setIdSetlist(null);

        useCase.cadastrar(setlist);

        Setlist resultado = captor.getValue();

        SetlistValidator.validaSetlistDomain(resultado, setlist);
    }

    @Test
    void testaListagemDeSetlist() {
        Page<Setlist> pageTeste = SetlistBuilder.gerarPageSetlistEntity().map(SetlistMapper::paraDomain);
        Pageable pageable = PageRequest.of(0, 10);
        Mockito.when(gateway.listar(Mockito.any())).thenReturn(pageTeste);

        Page<Setlist> resultado = useCase.listar(pageable);

        Assertions.assertEquals(resultado.getTotalElements(), pageTeste.getTotalElements());

        for (int i = 0; i < resultado.getNumberOfElements(); i++) {
            SetlistValidator.validaSetlistDomain(resultado.getContent().get(i), pageTeste.getContent().get(i));
            Assertions.assertEquals(resultado.getContent().get(i).getIdSetlist(), pageTeste.getContent().get(i).getIdSetlist());
        }
    }

    @Test
    void testeDelecaoSetlist() {
        Mockito.when(gateway.consultarPorId(Mockito.any())).thenReturn(Optional.of(setlist));
        Mockito.doNothing().when(gateway).deletar(Mockito.any());

        useCase.deletar(setlist.getIdSetlist());

        Mockito.verify(gateway, Mockito.times(1)).consultarPorId(setlist.getIdSetlist());
        Mockito.verify(gateway, Mockito.times(1)).deletar(setlist.getIdSetlist());
    }
}