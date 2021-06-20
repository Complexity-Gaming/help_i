package com.complexity.gaming.help_i.games.application;

import com.complexity.gaming.help_i.games.domain.model.aggregate.GameModel;
import com.complexity.gaming.help_i.games.domain.repository.GameRepository;
import com.complexity.gaming.help_i.games.domain.service.GameFacade;
import com.complexity.gaming.help_i.games.domain.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proto.Game;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
   /* @Autowired
    private GameFacade gameFacade;*/
    @Autowired
    private GameRepository gameRepository;

    @Override
    public Page<GameModel> getAllGames(Pageable pageable) {
        /*List<Game> providedGames = gameFacade.getAllGames(pageable).toList();*/
        List<GameModel> games = gameRepository.findAll();
        /*for(GameModel game: games) {
            game.SetProviderInformation(providedGames.stream().filter(g -> g.getId() == game.getProviderId()));
        }*/
        return null;

    }

    @Override
    public GameModel getGameById(Long gameId) {
        return null;
    }
}
