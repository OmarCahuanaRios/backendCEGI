package com.backend.app.repository;

import com.backend.app.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    Optional<Worker> findByDocumentId(String documentId);
    List<Worker> findAllByEnterprise_EnterpriseName(String enterpriseName);
}
