package com.complexity.gaming.help_i.games.domain.repository;

import com.complexity.gaming.help_i.games.domain.model.aggregate.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel, Long> {
}
