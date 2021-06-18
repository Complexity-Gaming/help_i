package com.complexity.gaming.help_i.security.domain.repository;

import com.complexity.gaming.help_i.security.domain.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
