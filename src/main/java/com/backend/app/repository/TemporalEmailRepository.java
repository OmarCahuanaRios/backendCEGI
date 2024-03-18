package com.backend.app.repository;

import com.backend.app.model.TemporalEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporalEmailRepository extends JpaRepository<TemporalEmail, Integer> {
}
