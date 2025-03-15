package com._ipr.plataforma_louvor_100.infrastructure.repositories;

import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MusicaRepository extends JpaRepository<MusicaEntity, UUID> {
    Optional<MusicaEntity> findByNome(String nome);
}
