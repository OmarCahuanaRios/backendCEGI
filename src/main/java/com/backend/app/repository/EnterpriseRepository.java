package com.backend.app.repository;

import com.backend.app.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer> {
    Enterprise findByEnterpriseName(String enterpriseName);
}
