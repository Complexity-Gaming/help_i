package com.complexity.gaming.help_i.application.domain.repository;

import com.complexity.gaming.help_i.application.domain.model.aggregate.ExpertApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExpertApplicationRepository extends JpaRepository<ExpertApplication, Long> {

    Page<ExpertApplication> findByPlayerId(Long playerId, Pageable pageable);
}
