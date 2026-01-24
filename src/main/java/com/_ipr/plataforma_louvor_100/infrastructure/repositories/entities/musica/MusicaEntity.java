package com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica;

import com._ipr.plataforma_louvor_100.domain.musica.Clima;
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
@ToString
public class MusicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_musica")
    private UUID idMusica;

    private String nome;

    private String artista;

    @Enumerated(EnumType.ORDINAL)
    private TomMusica tom;

    @Enumerated(EnumType.ORDINAL)
    private Clima clima;

    private Integer bpm;

    private String compositor;

    private String link;

    private String cifra;
}
