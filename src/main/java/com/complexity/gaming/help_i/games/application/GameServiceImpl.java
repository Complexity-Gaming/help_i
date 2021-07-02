package com.complexity.gaming.help_i.games.application;
import com.complexity.gaming.help_i.games.application.transform.resource.SaveGameResource;
import com.complexity.gaming.help_i.games.domain.model.aggregate.Game;
import com.complexity.gaming.help_i.games.domain.repository.GameRepository;
import com.complexity.gaming.help_i.games.domain.service.GameFacade;
import com.complexity.gaming.help_i.games.domain.service.GameService;
import idgbsdk.model.GameModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameFacade gameFacade;
    @Autowired
    private GameRepository gameRepository;

    @Override
    public Page<Game> getAllGames(Pageable pageable) {

        List<Game> games = gameRepository.findAll();
        List<Integer> ids = games.stream().map(Game::getProviderId).collect(Collectors.toList());
        String fields = ids.toString();
        List<GameModel> providedGames = gameFacade.getAllGames(pageable, fields.substring(1,fields.length()-1)).toList();

        for ( var game : games  ) {
            var providedGame = providedGames.stream().filter(g -> g.getId() == game.getProviderId())
                    .findFirst().orElseThrow(() -> new ResourceAccessException("Game not found with id " + game.getProviderId()));
            game.setProviderInformation(providedGame);
        }
        return new PageImpl<>(games, pageable, games.size());
    }

    @Override
    public Game getGameById(Long gameId) {
        var game = gameRepository.findById(gameId);
        if (game.isEmpty())
            throw new ResourceAccessException("Game not found with id " + gameId);
        var providedGame = gameFacade.getGameById(game.get().getProviderId());
        return game.get().setProviderInformation(providedGame);
    }

    @Override
    public Game save(SaveGameResource resource) {
        Game game = new Game();
        game.setName(resource.getName());
        game.setProviderId(resource.getProviderId());
        return gameRepository.save(game);
    }
}

