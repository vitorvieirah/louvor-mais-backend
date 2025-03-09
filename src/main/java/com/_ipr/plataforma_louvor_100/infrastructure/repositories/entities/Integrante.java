package com._ipr.plataforma_louvor_100.infrastructure.repositories.entities;

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
public class Integrante {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idIntegrante;

    private String nome;

    @Enumerated(EnumType.STRING)
    private FuncaoIntegrante funcao;
}
