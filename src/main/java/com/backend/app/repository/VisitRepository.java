package com.backend.app.repository;

import com.backend.app.model.Visit;
import com.backend.app.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {

    List<Visit> findAllByVisitant_EnterpriseEnterpriseName(String enterpriseName);
}
