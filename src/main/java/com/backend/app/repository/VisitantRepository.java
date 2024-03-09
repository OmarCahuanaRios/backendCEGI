package com.backend.app.repository;

import com.backend.app.model.Visitant;
import com.backend.app.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitantRepository extends JpaRepository<Visitant, Integer> {
    Optional<Visitant> findByDocumentId(String documentId);

    List<Visitant> findAllByEnterprise_EnterpriseName(String enterpriseName);
}
