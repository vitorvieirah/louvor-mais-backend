package com._ipr.plataforma_louvor_100.infrastructure.repositories.entities;

import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Entity(name = "Setlist")
@Table(name = "setlists")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SetlistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_setlist")
    private UUID idSetlist;

    private LocalDate data;

    @ManyToMany
    @JoinTable(
            name = "musicas_setlist",
            joinColumns = @JoinColumn(name = "id_setlist", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_musica", nullable = false)
    )
    private List<MusicaEntity> musicas;

    @ManyToMany
    @JoinTable(
            name = "folgas_setlist",
            joinColumns = @JoinColumn(name = "id_setlist", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_integrante", nullable = false)
    )
    private List<IntegranteEntity> folgas;
}
