package com.backend.app.repository;

import com.backend.app.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeRepository extends JpaRepository<Code, Integer> {
    List<Code> findAllByVisitant_Id(Integer id);
}
