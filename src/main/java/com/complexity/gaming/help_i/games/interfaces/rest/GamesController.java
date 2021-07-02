package com.complexity.gaming.help_i.games.interfaces.rest;
import com.complexity.gaming.help_i.games.application.transform.mapper.GameMapper;
import com.complexity.gaming.help_i.games.application.transform.resource.GameResource;
import com.complexity.gaming.help_i.games.application.transform.resource.SaveGameResource;
import com.complexity.gaming.help_i.games.domain.model.aggregate.Game;
import com.complexity.gaming.help_i.games.domain.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class GamesController {
    @Autowired
    private GameService gameService;
    @Autowired
    private GameMapper mapper;

    @GetMapping("/games")
    public Page<GameResource> getAllGames(Pageable pageable){
        return gameService.getAllGames(pageable).map(game -> mapper.convertToResource(game));
    }
    @GetMapping("/games/{id}")
    public GameResource getGameById(@PathVariable(name = "id") Long gameId){
        return mapper.convertToResource(gameService.getGameById(gameId));
    }
    @PostMapping("/games")
    public Game saveGame(@RequestBody SaveGameResource resource){
        return gameService.save(resource);
    }
}
