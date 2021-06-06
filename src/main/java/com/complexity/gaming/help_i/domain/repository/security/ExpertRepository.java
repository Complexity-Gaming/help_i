package com.complexity.gaming.help_i.domain.repository.security;

import com.complexity.gaming.help_i.domain.model.security.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long> {

}