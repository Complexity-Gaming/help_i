package com.complexity.gaming.help_i.games.domain.service;
import model.GameModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GameFacade {
    Page<GameModel> getAllGames(Pageable pageable, String fields);
    GameModel getGameById(int gameId);
}
