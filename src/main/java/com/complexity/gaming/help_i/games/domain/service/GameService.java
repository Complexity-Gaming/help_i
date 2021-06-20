package com.complexity.gaming.help_i.games.domain.service;

import com.complexity.gaming.help_i.games.domain.model.aggregate.GameModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GameService {
    Page<GameModel> getAllGames(Pageable pageable);
    GameModel getGameById(Long gameId);
}

