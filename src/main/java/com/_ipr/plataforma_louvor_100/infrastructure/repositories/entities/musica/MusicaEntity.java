package com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica;

import com._ipr.plataforma_louvor_100.domain.musica.DificuldadeMusica;
import com._ipr.plataforma_louvor_100.domain.musica.TomMusica;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity(name = "Musica")
@Table(name = "musicas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MusicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_musica")
    private UUID idMusica;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TomMusica tom;

    private String versao;

    @Enumerated(EnumType.STRING)
    private DificuldadeMusica dificuldade;

    private String link;

    private String cifra;
}
