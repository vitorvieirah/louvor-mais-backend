package com._ipr.plataforma_louvor_100.infrastructure.repositories.entities;

import com._ipr.plataforma_louvor_100.domain.FuncaoIntegrante;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "Integrante")
@Table(name = "integrantes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class IntegranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_integrante")
    private UUID idIntegrante;

    private String nome;

    @Enumerated(EnumType.STRING)
    private FuncaoIntegrante funcao;
}
