package com.backend.app.repository;

import com.backend.app.model.Visitant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitantRepository extends JpaRepository<Visitant, Integer> {
}
