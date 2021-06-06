package com.complexity.gaming.help_i.domain.repository.training;

import com.complexity.gaming.help_i.domain.model.training.TrainingMaterial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingMaterialRepository extends JpaRepository<TrainingMaterial, Long> {
    Page<TrainingMaterial> findByExpertId(Long expertId, Pageable pageable);
    Optional<TrainingMaterial> findByIdAndExpertId(Long id, Long expertId);
}
