package com._ipr.plataforma_louvor_100.infrastructure.repositories;

import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.SetlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SetlistRepository extends JpaRepository<SetlistEntity, UUID> {
}
