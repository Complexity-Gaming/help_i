package com.complexity.gaming.help_i.games.application;
import com.complexity.gaming.help_i.games.domain.service.GameFacade;
import com.complexity.gaming.help_i.shared.exception.ResourceNotFoundException;
import idgbsdk.apicalypse.APICalypse;
import idgbsdk.model.GameModel;
import idgbsdk.request.IGDBFacade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GameFacadeImpl implements GameFacade {
    private final IGDBFacade facade = new IGDBFacade();

    public GameFacadeImpl() {
        facade.setCredentials("cg5hbasfqcgsspirqwwy5x69z1l14p", "bl1zptp1ie2jk0ruyua767f38wcupb");
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
