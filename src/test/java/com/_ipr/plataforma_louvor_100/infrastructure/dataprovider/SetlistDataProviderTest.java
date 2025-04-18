package com._ipr.plataforma_louvor_100.infrastructure.dataprovider;

import com._ipr.plataforma_louvor_100.builder.SetlistBuilder;
import com._ipr.plataforma_louvor_100.domain.Setlist;
import com._ipr.plataforma_louvor_100.infrastructure.dataprovider.exceptions.DataProviderException;
import com._ipr.plataforma_louvor_100.infrastructure.mapper.SetlistMapper;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.SetlistRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.SetlistEntity;
import com._ipr.plataforma_louvor_100.validators.SetlistValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SetlistDataProviderTest {

    @Mock
    private SetlistRepository repository;

    @InjectMocks
    private SetlistDataProvider dataProvider;

    private final Setlist setlistDomainTeste = SetlistBuilder.gerarSetlistDomain();

    private final SetlistEntity setlistEntityTeste = SetlistBuilder.gerarSetlistEntity();

    private final Page<SetlistEntity> setlistEntityPage = SetlistBuilder.gerarPageSetlistEntity();


    @Test
    void testaSalvar() {
        Mockito.when(repository.save(Mockito.any())).thenReturn(setlistEntityTeste);
        setlistDomainTeste.setIdSetlist(null);
        Setlist resultado = dataProvider.salvar(setlistDomainTeste);
        SetlistValidator.validaSetlistDomain(resultado, setlistDomainTeste);
        Assertions.assertNotNull(resultado.getIdSetlist());
    }

    @Test
    void testaExcpetionSalvar() {
        Mockito.when(repository.save(Mockito.any())).thenThrow(RuntimeException.class);

        DataProviderException exception = Assertions.assertThrows(DataProviderException.class,
                () -> dataProvider.salvar(setlistDomainTeste));

        Assertions.assertEquals(exception.getMessage(), SetlistDataProvider.MENSAGEM_ERRO_SALVAR_SETLIST);
    }

    @Test
    void testaListar() {
        Pageable pageable = PageRequest.of(0, 10);

        Mockito.when(repository.findAll(pageable)).thenReturn(setlistEntityPage);

        Page<Setlist> resultado = dataProvider.listar(pageable);

        Assertions.assertEquals(resultado.getTotalElements(), setlistEntityPage.getTotalElements());

        for (int i = 0; i < resultado.getNumberOfElements(); i++) {
            SetlistValidator.validaSetlistDomainMapper(resultado.getContent().get(i), setlistEntityPage.getContent().get(i));
        }
    }

    @Test
    void testaExcpetionListagem() {
        Pageable pageable = PageRequest.of(0, 10);

        Mockito.when(repository.findAll(pageable)).thenThrow(RuntimeException.class);

        DataProviderException exception = Assertions.assertThrows(DataProviderException.class,
                () -> dataProvider.listar(pageable));

        Assertions.assertEquals(exception.getMessage(), SetlistDataProvider.MENSAGEM_ERRO_LISTAR_SETLIST);
    }


    @Test
    void testaDeletar() {
        Mockito.doNothing().when(repository).deleteById(Mockito.any());

        dataProvider.deletar(setlistDomainTeste.getIdSetlist());

        Mockito.verify(repository, Mockito.times(1)).deleteById(setlistDomainTeste.getIdSetlist());
    }

    @Test
    void testaConsultaPeloId() {
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(SetlistMapper.paraEntity(setlistDomainTeste)));

        Optional<Setlist> resultado = dataProvider.consultarPorId(setlistDomainTeste.getIdSetlist());

        resultado.ifPresent(setlist -> {
            SetlistValidator.validaSetlistDomain(setlistDomainTeste, setlist);
        });
    }

    @Test
    void testaExcpetionConsultaPeloId() {
        Mockito.when(repository.findById(Mockito.any())).thenThrow(RuntimeException.class);

        DataProviderException exception = Assertions.assertThrows(DataProviderException.class,
                () -> dataProvider.consultarPorId(setlistDomainTeste.getIdSetlist()));

        Assertions.assertEquals(exception.getMessage(), SetlistDataProvider.MENSAGEM_ERRO_CONSULTAR_SETLIST_POR_ID);
    }


}