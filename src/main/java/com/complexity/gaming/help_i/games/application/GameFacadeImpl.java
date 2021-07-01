package com.complexity.gaming.help_i.games.application;

import api.igdb.apicalypse.APICalypse;
import api.igdb.request.IGDBFacade;
import com.complexity.gaming.help_i.games.domain.service.GameFacade;
import com.complexity.gaming.help_i.shared.exception.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.GameModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GameFacadeImpl implements GameFacade {
    private final IGDBFacade facade = new IGDBFacade();

    public GameFacadeImpl() {
        facade.setCredentials("ov3od6hqyjyb0iurx0hbbvp6ijde7v", "24jlaiw72qgv0z64gi7h1tbz11x3dz");
    }

    @Override
    public Page<GameModel> getAllGames(Pageable pageable, String fields) {
        APICalypse apiCalypse = new APICalypse();
        try {
            var games = facade.getGames(apiCalypse.setWhere("id = (" + fields + ");")
                    .setFields("id, name, cover.*, screenshots.*, storyline, summary;"));
            return new PageImpl<>(games, pageable, games.size());
        }
        catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
    @Override
    public GameModel getGameById(int gameId) {
        APICalypse apiCalypse = new APICalypse();
        try {
            return facade.getGames(apiCalypse.setWhere("id = "+ gameId +";")
                    .setFields("id, name, cover.*, screenshots.*, storyline, summary;")).get(0);
        }
        catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
}
