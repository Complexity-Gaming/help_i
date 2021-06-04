package com.complexity.gaming.help_i.domain.respository.Application;

import com.complexity.gaming.help_i.domain.model.Application.ExpertApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExpertApplicationRepository extends JpaRepository<ExpertApplication, Long> {

    Page<ExpertApplication> findByPlayerId(Long playerId, Pageable pageable);
}
