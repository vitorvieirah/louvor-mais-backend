package com._ipr.plataforma_louvor_100.infrastructure.dataprovider;

import com._ipr.plataforma_louvor_100.builder.SetlistBuilder;
import com._ipr.plataforma_louvor_100.domain.Setlist;
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
    void listar() {
    }

    @Test
    void deletar() {
    }

    @Test
    void consultarPorId() {
    }
}