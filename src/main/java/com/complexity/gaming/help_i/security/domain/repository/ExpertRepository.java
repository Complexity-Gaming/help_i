package com.complexity.gaming.help_i.security.domain.repository;

import com.complexity.gaming.help_i.security.domain.model.Expert;
import com.complexity.gaming.help_i.security.domain.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long> {
    Optional<Expert> findByEmail(String username);
    Page<Expert> findByGame(Pageable pageable, Long game);
}
