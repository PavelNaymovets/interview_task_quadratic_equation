package com.interview.task.quadraticEquation.repository;

import com.interview.task.quadraticEquation.entity.EquationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquationRepository extends JpaRepository<EquationEntity, Long> {
}
