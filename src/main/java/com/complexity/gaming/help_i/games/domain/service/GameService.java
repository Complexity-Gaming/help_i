package com.complexity.gaming.help_i.games.domain.service;

import com.complexity.gaming.help_i.games.application.transform.resource.SaveGameResource;
import com.complexity.gaming.help_i.games.domain.model.aggregate.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GameService {
    Page<Game> getAllGames(Pageable pageable);
    Game getGameById(Long gameId);
    Game save(SaveGameResource resource);
}


